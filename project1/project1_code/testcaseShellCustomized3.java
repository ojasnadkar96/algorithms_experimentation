//TESTCASE (Customized Shell Sort) 3: Running time on uniform and almost sorted input of 10000 numbers

import java.util.*;

public class testcaseShellCustomized3 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellCustomized(); //noraml sort algo object
		testcaseShellCustomized3 sct4 = new testcaseShellCustomized3(); //testcase obj
		String testFile = "test10000.txt";
		System.out.println("CUSTOMIZED SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 10000 numbers
		System.out.println("running on uniformly distributed input of 10000 numbers");
		sct4.data = sortfunc.readFile(testFile);
		sct4.gaps = sortfunc.generateGap(sct4.data);
		long start1 = System.nanoTime()/1000;
		sct4.sort = sortfunc.sortFunction(sct4.data,sct4.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct4.sort);
		System.out.println();
		sct4.data.clear(); //clearing all global arrays after use
		sct4.gaps.clear();
		sct4.sort.clear();
		//running on almost sorted input of 10000 numbers
		System.out.println("running on almost sorted input of 10000 numbers");
		sct4.almostSort = sortfunc.generateAlmostSorted(10000);
		sct4.gaps = sortfunc.generateGap(sct4.almostSort);
		long start2 = System.nanoTime()/1000;
		sct4.sort = sortfunc.sortFunction(sct4.almostSort,sct4.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct4.sort);
		System.out.println();
		sct4.almostSort.clear(); //clearing all global arrays after use
		sct4.gaps.clear();
		sct4.sort.clear();
	}

}