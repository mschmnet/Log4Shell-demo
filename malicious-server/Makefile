help:
	@echo run
	@echo stop
	@echo logs

run:
	docker-compose build --build-arg CODEBASE_URL=$(CODEBASE_URL)
	docker-compose up -d --force-recreate

stop:
	docker-compose stop

logs:
	docker-compose logs -f

.PHONY: help run stop logs
