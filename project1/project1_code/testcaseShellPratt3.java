//TESTCASE (Pratt Shell Sort) 3: Running time on uniform and almost sorted input of 10000 numbers

import java.util.*;

public class testcaseShellPratt3 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellPratt(); //noraml sort algo object
		testcaseShellPratt3 spt3 = new testcaseShellPratt3(); //testcase obj
		String testFile = "test10000.txt";
		System.out.println("PRATT SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 10000 numbers
		System.out.println("running on uniformly distributed input of 10000 numbers");
		spt3.data = sortfunc.readFile(testFile);
		spt3.gaps = sortfunc.generateGap(spt3.data);
		long start1 = System.nanoTime()/1000;
		spt3.sort = sortfunc.sortFunction(spt3.data,spt3.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt3.sort);
		System.out.println();
		spt3.data.clear(); //clearing all global arrays after use
		spt3.gaps.clear();
		spt3.sort.clear();
		//running on almost sorted input of 10000 numbers
		System.out.println("running on almost sorted input of 10000 numbers");
		spt3.almostSort = sortfunc.generateAlmostSorted(10000);
		spt3.gaps = sortfunc.generateGap(spt3.almostSort);
		long start2 = System.nanoTime()/1000;
		spt3.sort = sortfunc.sortFunction(spt3.almostSort,spt3.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt3.sort);
		System.out.println();
		spt3.almostSort.clear(); //clearing all global arrays after use
		spt3.gaps.clear();
		spt3.sort.clear();
	}

}