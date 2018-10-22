JAVAC=javac

FILES=$(shell ls | egrep '\.java$$' | sed -re 's/^(.+)\.java$$/\1/')
SOURCES=$(foreach file,$(FILES),$(file).java)
CLASSES=$(foreach file,$(FILES),$(file).class)

.PHONY: all
all: $(CLASSES)

%.class: %.java
	javac $<

.PHONY: clean
clean:
	rm *.class
