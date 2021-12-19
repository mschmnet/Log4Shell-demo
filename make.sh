#!/bin/sh

docker run -i --rm --name docker -v /var/run/docker.sock:/var/run/docker.sock -v "$(pwd):/opt/app/" mschmnet/dind-compose-make:0.3 "$@" < /dev/stdin
