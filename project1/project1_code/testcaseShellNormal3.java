//TESTCASE (Normal Shell Sort) 3: Running time on uniform and almost sorted input of 10000 numbers

import java.util.*;

public class testcaseShellNormal3 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellNormal(); //noraml sort algo object
		testcaseShellNormal3 snt3 = new testcaseShellNormal3(); //testcase obj
		String testFile = "test10000.txt";
		System.out.println("NORMAL SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 10000 numbers
		System.out.println("running on uniformly distributed input of 10000 numbers");
		snt3.data = sortfunc.readFile(testFile);
		snt3.gaps = sortfunc.generateGap(snt3.data);
		long start1 = System.nanoTime()/1000;
		snt3.sort = sortfunc.sortFunction(snt3.data,snt3.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt3.sort);
		System.out.println();
		snt3.data.clear(); //clearing all global arrays after use
		snt3.gaps.clear();
		snt3.sort.clear();
		//running on almost sorted input of 10000 numbers
		System.out.println("running on almost sorted input of 10000 numbers");
		snt3.almostSort = sortfunc.generateAlmostSorted(10000);
		snt3.gaps = sortfunc.generateGap(snt3.almostSort);
		long start2 = System.nanoTime()/1000;
		snt3.sort = sortfunc.sortFunction(snt3.almostSort,snt3.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt3.sort);
		System.out.println();
		snt3.almostSort.clear(); //clearing all global arrays after use
		snt3.gaps.clear();
		snt3.sort.clear();
	}

}