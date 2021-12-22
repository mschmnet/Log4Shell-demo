# Log4Shell in action

This project aims to demonstrate how the Log4Shell / CVE-2021-44228 vulnerability works.

## Requirements

You only need to have Docker installed. Ideally you have two different virtual machines. One for the _vulnerable server_ and one for the _malicious server_ that will host the malicious codebase and a LDAP server.

Optionally you have _Make_ and _Docker Compose_ installed but this is **not** necesarry since this repo also contains a `make.sh` to skip these requirements and use them from within a docker container.

## Install Docker (optionally)

If you haven't already, here are the steps to install Docker on a Debian VM. You can use these steps: https://gist.github.com/mschmnet/5d8c979920801c73e148c901a5989b46

## Download the repository

```
git clone git@github.com:mschmnet/Log4Shell-demo.git 
```

## Install vulnerable server

```
cd vulnerable-server
../make.sh run # Or you coud execute make run if you hade Make and Docker Compose installed
```

## Start malicious server.

This will start a basic LDAP server and basic Python server to serve the malicious Java classes.

You need to provide the IP address or domain name where these servers will be available

```
cd malicious-server
    ../make.sh run CODEBASE_URL=SERVER_IP_OR_DOMAIN_NAME # Optionally make instead of ../make.sh if you had Make and Docker Compose installed
``` 

## How to stop any of them

```
../make.sh stop
```

## How to show the logs 

```
../make.sh logs 
```
