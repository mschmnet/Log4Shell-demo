package net.mschm.log4shell.vulnerableserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
public class Controller {
    private static final Logger log = LogManager.getLogger(Controller.class);

    @GetMapping("/some-endpoint")
    public void page(@RequestParam("foo") String foo) {
        log.info(foo);
    }

    public static void main(String[] args) throws Exception {
        String absoluteFilePath = Controller.class.getResource("/static/index.html").getFile().toString();        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("/bin/sh", "-c", "echo hacked >> " + absoluteFilePath);
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
    }
}
