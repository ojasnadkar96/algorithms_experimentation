//TESTCASE (A036562 Shell Sort) 3: Running time on uniform and almost sorted input of 10000 numbers

import java.util.*;

public class testcaseShellA0365623 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellA036562(); //noraml sort algo object
		testcaseShellA0365623 sat3 = new testcaseShellA0365623(); //testcase obj
		String testFile = "test10000.txt";
		System.out.println("A036562 SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 10000 numbers
		System.out.println("running on uniformly distributed input of 10000 numbers");
		sat3.data = sortfunc.readFile(testFile);
		sat3.gaps = sortfunc.generateGap(sat3.data);
		long start1 = System.nanoTime()/1000;
		sat3.sort = sortfunc.sortFunction(sat3.data,sat3.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat3.sort);
		System.out.println();
		sat3.data.clear(); //clearing all global arrays after use
		sat3.gaps.clear();
		sat3.sort.clear();
		//running on almost sorted input of 10000 numbers
		System.out.println("running on almost sorted input of 10000 numbers");
		sat3.almostSort = sortfunc.generateAlmostSorted(10000);
		sat3.gaps = sortfunc.generateGap(sat3.almostSort);
		long start2 = System.nanoTime()/1000;
		sat3.sort = sortfunc.sortFunction(sat3.almostSort,sat3.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat3.sort);
		System.out.println();
		sat3.almostSort.clear(); //clearing all global arrays after use
		sat3.gaps.clear();
		sat3.sort.clear();
	}

}