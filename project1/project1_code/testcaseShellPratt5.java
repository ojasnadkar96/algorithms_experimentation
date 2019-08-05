//TESTCASE (Pratt Shell Sort) 5: Running time on uniform and almost sorted input of 1000000 numbers

import java.util.*;

public class testcaseShellPratt5 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellPratt(); //noraml sort algo object
		testcaseShellPratt5 spt5 = new testcaseShellPratt5(); //testcase obj
		String testFile = "test1000000.txt";
		System.out.println("PRATT SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000000 numbers
		System.out.println("running on uniformly distributed input of 1000000 numbers");
		spt5.data = sortfunc.readFile(testFile);
		spt5.gaps = sortfunc.generateGap(spt5.data);
		long start1 = System.nanoTime()/1000;
		spt5.sort = sortfunc.sortFunction(spt5.data,spt5.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt5.sort);
		System.out.println();
		spt5.data.clear(); //clearing all global arrays after use
		spt5.gaps.clear();
		spt5.sort.clear();
		//running on almost sorted input of 1000000 numbers
		System.out.println("running on almost sorted input of 1000000 numbers");
		spt5.almostSort = sortfunc.generateAlmostSorted(1000000);
		spt5.gaps = sortfunc.generateGap(spt5.almostSort);
		long start2 = System.nanoTime()/1000;
		spt5.sort = sortfunc.sortFunction(spt5.almostSort,spt5.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt5.sort);
		System.out.println();
		spt5.almostSort.clear(); //clearing all global arrays after use
		spt5.gaps.clear();
		spt5.sort.clear();
	}

}