//TESTCASE (Pratt Shell Sort) 4: Running time on uniform and almost sorted input of 100000 numbers

import java.util.*;

public class testcaseShellPratt4 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellPratt(); //noraml sort algo object
		testcaseShellPratt4 spt4 = new testcaseShellPratt4(); //testcase obj
		String testFile = "test100000.txt";
		System.out.println("PRATT SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100000 numbers
		System.out.println("running on uniformly distributed input of 100000 numbers");
		spt4.data = sortfunc.readFile(testFile);
		spt4.gaps = sortfunc.generateGap(spt4.data);
		long start1 = System.nanoTime()/1000;
		spt4.sort = sortfunc.sortFunction(spt4.data,spt4.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt4.sort);
		System.out.println();
		spt4.data.clear(); //clearing all global arrays after use
		spt4.gaps.clear();
		spt4.sort.clear();
		//running on almost sorted input of 100000 numbers
		System.out.println("running on almost sorted input of 100000 numbers");
		spt4.almostSort = sortfunc.generateAlmostSorted(100000);
		spt4.gaps = sortfunc.generateGap(spt4.almostSort);
		long start2 = System.nanoTime()/1000;
		spt4.sort = sortfunc.sortFunction(spt4.almostSort,spt4.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(spt4.sort);
		System.out.println();
		spt4.almostSort.clear(); //clearing all global arrays after use
		spt4.gaps.clear();
		spt4.sort.clear();
	}

}