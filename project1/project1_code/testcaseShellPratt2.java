//TESTCASE (Pratt Shell Sort) 2: Running time on uniform and almost sorted input of 1000 numbers

import java.util.*;

public class testcaseShellPratt2 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellPratt(); //noraml sort algo object
		testcaseShellPratt2 spt2 = new testcaseShellPratt2(); //testcase obj
		String testFile = "test1000.txt";
		System.out.println("PRATT SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000 numbers
		System.out.println("running on uniformly distributed input of 1000 numbers");
		spt2.data = sortfunc.readFile(testFile);
		spt2.gaps = sortfunc.generateGap(spt2.data);
		long start1 = System.nanoTime()/1000;
		spt2.sort = sortfunc.sortFunction(spt2.data,spt2.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt2.sort);
		System.out.println();
		spt2.data.clear(); //clearing all global arrays after use
		spt2.gaps.clear();
		spt2.sort.clear();
		//running on almost sorted input of 1000 numbers
		System.out.println("running on almost sorted input of 1000 numbers");
		spt2.almostSort = sortfunc.generateAlmostSorted(1000);
		spt2.gaps = sortfunc.generateGap(spt2.almostSort);
		long start2 = System.nanoTime()/1000;
		spt2.sort = sortfunc.sortFunction(spt2.almostSort,spt2.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt2.sort);
		System.out.println();
		spt2.almostSort.clear(); //clearing all global arrays after use
		spt2.gaps.clear();
		spt2.sort.clear();
	}

}