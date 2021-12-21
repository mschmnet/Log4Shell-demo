package net.mschm.log4shell.vulnerableserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger log = LogManager.getLogger(Controller.class);

    @GetMapping("/some-endpoint")
    public void page(@RequestParam("foo") String foo) {
        log.info(foo);
    }
}
