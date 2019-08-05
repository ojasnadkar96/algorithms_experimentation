//TESTCASE (A036562 Shell Sort) 5: Running time on uniform and almost sorted input of 1000000 numbers

import java.util.*;

public class testcaseShellA0365625 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellA036562(); //noraml sort algo object
		testcaseShellA0365625 sat5 = new testcaseShellA0365625(); //testcase obj
		String testFile = "test1000000.txt";
		System.out.println("A036562 SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100 numbers
		System.out.println("running on uniformly distributed input of 1000000 numbers");
		sat5.data = sortfunc.readFile(testFile);
		sat5.gaps = sortfunc.generateGap(sat5.data);
		long start1 = System.nanoTime()/1000;
		sat5.sort = sortfunc.sortFunction(sat5.data,sat5.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat5.sort);
		System.out.println();
		sat5.data.clear(); //clearing all global arrays after use
		sat5.gaps.clear();
		sat5.sort.clear();
		//running on almost sorted input of 1000000 numbers
		System.out.println("running on almost sorted input of 1000000 numbers");
		sat5.almostSort = sortfunc.generateAlmostSorted(1000000);
		sat5.gaps = sortfunc.generateGap(sat5.almostSort);
		long start2 = System.nanoTime()/1000;
		sat5.sort = sortfunc.sortFunction(sat5.almostSort,sat5.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sat5.sort);
		System.out.println();
		sat5.almostSort.clear(); //clearing all global arrays after use
		sat5.gaps.clear();
		sat5.sort.clear();
	}

}