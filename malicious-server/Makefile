MARP=./node_modules/.bin/marp
HTTP_SERVER=./node_modules/.bin/http-server

FILES:=$(patsubst %.md, %, $(wildcard *.md))
FILES:=$(filter-out README, $(FILES))

all: pdf html

pdf: $(patsubst %,pdf/%.pdf,$(FILES))

html: $(patsubst %,html/%.htm,$(FILES))

pdf/%.pdf: %.md
	$(MAKE) $(MARP) 
	@echo "Generating pdf slides..."
	$(MARP) --allow-local-files $< --output $@	

html/%.htm: %.md
	$(MAKE) $(MARP)
	@echo "Generating html slides..."
	mkdir -p html/img
	cp img/* html/img/
	$(MARP) --allow-local-files $< --output $@	

$(MARP):
	npm install --save-dev @marp-team/marp-cli	

show:
	$(MAKE) $(HTTP_SERVER)	
	http-server ./html/

$(HTTP_SERVER):
	npm install --save-dev http-server

clean:
	rm pdf/*.pdf
	rm html/*.htm

help: list

list:
	@echo "make [all]: Generates html and pdf slides"
	@echo "make html: Generates html slides"
	@echo "make pdf: Generates pdf slides"
	@echo "make clean: Remove all generated files"
	@echo "make show: Show HTML slides in http-server"


.PHONY: pdf html help list clean show

