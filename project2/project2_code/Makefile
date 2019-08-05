
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	BinOperations.java \
    NextFit.java \
    FirstFit.java \
    BestFit.java \
	FirstFitDecreasing.java \
	BestFitDecreasing.java \
	testcaseNextFit1.java \
	testcaseNextFit2.java \
	testcaseNextFit3.java \
	testcaseNextFit4.java \
	testcaseNextFit5.java \
	testcaseFirstFit1.java \
	testcaseFirstFit2.java \
	testcaseFirstFit3.java \
	testcaseFirstFit4.java \
	testcaseFirstFit5.java \
	testcaseBestFit1.java \
	testcaseBestFit2.java \
	testcaseBestFit3.java \
	testcaseBestFit4.java \
	testcaseBestFit5.java \
	testcaseFirstFitDecreasing1.java \
	testcaseFirstFitDecreasing2.java \
	testcaseFirstFitDecreasing3.java \
	testcaseFirstFitDecreasing4.java \
	testcaseFirstFitDecreasing5.java \
	testcaseBestFitDecreasing1.java \
	testcaseBestFitDecreasing2.java \
	testcaseBestFitDecreasing3.java \
	testcaseBestFitDecreasing4.java \
	testcaseBestFitDecreasing5.java \
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class