
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	SortOperations.java \
    ShellNormal.java \
    ShellHibbard.java \
    ShellPratt.java \
	ShellA036562.java \
	ShellCustomized.java \
	testcaseShellNormal1.java \
	testcaseShellNormal2.java \
	testcaseShellNormal3.java \
	testcaseShellNormal4.java \
	testcaseShellNormal5.java \
	testcaseShellHibbard1.java \
	testcaseShellHibbard2.java \
	testcaseShellHibbard3.java \
	testcaseShellHibbard4.java \
	testcaseShellHibbard5.java \
	testcaseShellPratt1.java \
	testcaseShellPratt2.java \
	testcaseShellPratt3.java \
	testcaseShellPratt4.java \
	testcaseShellPratt5.java \
	testcaseShellA0365621.java \
	testcaseShellA0365622.java \
	testcaseShellA0365623.java \
	testcaseShellA0365624.java \
	testcaseShellA0365625.java \
	testcaseShellCustomized1.java \
	testcaseShellCustomized2.java \
	testcaseShellCustomized3.java \
	testcaseShellCustomized4.java \
	testcaseShellCustomized5.java \
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class