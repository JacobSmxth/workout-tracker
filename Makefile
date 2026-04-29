CC=javac
RUN=java

SRC=src
MAIN=com.jacob.workout.Main
OUT=out

compile:
	mkdir -p $(OUT)
	$(CC) -sourcepath $(SRC) -d $(OUT) $(SRC)/com/jacob/workout/Main.java

run: compile
	$(RUN) -cp $(OUT) $(MAIN)

clean:
	rm -rf $(OUT)
