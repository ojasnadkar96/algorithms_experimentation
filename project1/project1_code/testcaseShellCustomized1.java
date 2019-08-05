//TESTCASE (Customized Shell Sort) 1: Running time on uniform and almost sorted input of 100 numbers

import java.util.*;

public class testcaseShellCustomized1 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellCustomized(); //noraml sort algo object
		testcaseShellCustomized1 sct2 = new testcaseShellCustomized1(); //testcase obj
		String testFile = "test100.txt";
		System.out.println("CUSTOMIZED SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100 numbers
		System.out.println("running on uniformly distributed input of 100 numbers");
		sct2.data = sortfunc.readFile(testFile);
		sct2.gaps = sortfunc.generateGap(sct2.data);
		long start1 = System.nanoTime()/1000;
		sct2.sort = sortfunc.sortFunction(sct2.data,sct2.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct2.sort);
		System.out.println();
		sct2.data.clear(); //clearing all global arrays after use
		sct2.gaps.clear();
		sct2.sort.clear();
		//running on almost sorted input of 100 numbers
		System.out.println("running on almost sorted input of 100 numbers");
		sct2.almostSort = sortfunc.generateAlmostSorted(100);
		sct2.gaps = sortfunc.generateGap(sct2.almostSort);
		long start2 = System.nanoTime()/1000;
		sct2.sort = sortfunc.sortFunction(sct2.almostSort,sct2.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct2.sort);
		System.out.println();
		sct2.almostSort.clear(); //clearing all global arrays after use
		sct2.gaps.clear();
		sct2.sort.clear();
	}

}