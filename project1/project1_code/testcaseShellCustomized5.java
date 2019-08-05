//TESTCASE (Customized Shell Sort) 5: Running time on uniform and almost sorted input of 1000000 numbers

import java.util.*;

public class testcaseShellCustomized5 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellCustomized(); //noraml sort algo object
		testcaseShellCustomized5 sct5 = new testcaseShellCustomized5(); //testcase obj
		String testFile = "test1000000.txt";
		System.out.println("CUSTOMIZED SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000000 numbers
		System.out.println("running on uniformly distributed input of 1000000 numbers");
		sct5.data = sortfunc.readFile(testFile);
		sct5.gaps = sortfunc.generateGap(sct5.data);
		long start1 = System.nanoTime()/1000;
		sct5.sort = sortfunc.sortFunction(sct5.data,sct5.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct5.sort);
		System.out.println();
		sct5.data.clear(); //clearing all global arrays after use
		sct5.gaps.clear();
		sct5.sort.clear();
		//running on almost sorted input of 1000000 numbers
		System.out.println("running on almost sorted input of 1000000 numbers");
		sct5.almostSort = sortfunc.generateAlmostSorted(1000000);
		sct5.gaps = sortfunc.generateGap(sct5.almostSort);
		long start2 = System.nanoTime()/1000;
		sct5.sort = sortfunc.sortFunction(sct5.almostSort,sct5.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sct5.sort);
		System.out.println();
		sct5.almostSort.clear(); //clearing all global arrays after use
		sct5.gaps.clear();
		sct5.sort.clear();
	}

}