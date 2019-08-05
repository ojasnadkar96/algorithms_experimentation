//TESTCASE (A036562 Shell Sort) 4: Running time on uniform and almost sorted input of 100000 numbers

import java.util.*;

public class testcaseShellA0365624 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellA036562(); //noraml sort algo object
		testcaseShellA0365624 sat4 = new testcaseShellA0365624(); //testcase obj
		String testFile = "test100000.txt";
		System.out.println("A036562 SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100000 numbers
		System.out.println("running on uniformly distributed input of 100000 numbers");
		sat4.data = sortfunc.readFile(testFile);
		sat4.gaps = sortfunc.generateGap(sat4.data);
		long start1 = System.nanoTime()/1000;
		sat4.sort = sortfunc.sortFunction(sat4.data,sat4.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat4.sort);
		System.out.println();
		sat4.data.clear(); //clearing all global arrays after use
		sat4.gaps.clear();
		sat4.sort.clear();
		//running on almost sorted input of 100000 numbers
		System.out.println("running on almost sorted input of 100000 numbers");
		sat4.almostSort = sortfunc.generateAlmostSorted(100000);
		sat4.gaps = sortfunc.generateGap(sat4.almostSort);
		long start2 = System.nanoTime()/1000;
		sat4.sort = sortfunc.sortFunction(sat4.almostSort,sat4.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat4.sort);
		System.out.println();
		sat4.almostSort.clear(); //clearing all global arrays after use
		sat4.gaps.clear();
		sat4.sort.clear();
	}

}