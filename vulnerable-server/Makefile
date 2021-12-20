help:
	@echo run
	@echo stop
	@echo logs

run:
	docker-compose up -d --build --force-recreate

stop:
	docker-compose stop

logs:
	docker-compose logs -f

.PHONY: help run stop logs
