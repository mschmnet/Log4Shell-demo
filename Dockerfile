FROM docker:20.10.12

RUN apk add --update --no-cache py-pip python3-dev libffi-dev openssl-dev gcc libc-dev rust cargo make && \
    pip install docker-compose

RUN apk add --update --no-cache curl && \
    curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" && \
    install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

WORKDIR /opt/app

ENTRYPOINT ["/usr/bin/make"]
