//TESTCASE (A036562 Shell Sort) 1: Running time on uniform and almost sorted input of 100 numbers

import java.util.*;

public class testcaseShellA0365621 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellA036562(); //noraml sort algo object
		testcaseShellA0365621 sat2 = new testcaseShellA0365621(); //testcase obj
		String testFile = "test100.txt";
		System.out.println("A036562 SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100 numbers
		System.out.println("running on uniformly distributed input of 100 numbers");
		sat2.data = sortfunc.readFile(testFile);
		sat2.gaps = sortfunc.generateGap(sat2.data);
		long start1 = System.nanoTime()/1000;
		sat2.sort = sortfunc.sortFunction(sat2.data,sat2.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat2.sort);
		System.out.println();
		sat2.data.clear(); //clearing all global arrays after use
		sat2.gaps.clear();
		sat2.sort.clear();
		//running on almost sorted input of 100 numbers
		System.out.println("running on almost sorted input of 100 numbers");
		sat2.almostSort = sortfunc.generateAlmostSorted(100);
		sat2.gaps = sortfunc.generateGap(sat2.almostSort);
		long start2 = System.nanoTime()/1000;
		sat2.sort = sortfunc.sortFunction(sat2.almostSort,sat2.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat2.sort);
		System.out.println();
		sat2.almostSort.clear(); //clearing all global arrays after use
		sat2.gaps.clear();
		sat2.sort.clear();
	}

}