//TESTCASE (Hibbard Shell Sort) 2: Running time on uniform and almost sorted input of 1000 numbers

import java.util.*;

public class testcaseShellHibbard2 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellHibbard(); //noraml sort algo object
		testcaseShellHibbard2 sht2 = new testcaseShellHibbard2(); //testcase obj
		String testFile = "test1000.txt";
		System.out.println("HIBBARD SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000 numbers
		System.out.println("running on uniformly distributed input of 1000 numbers");
		sht2.data = sortfunc.readFile(testFile);
		sht2.gaps = sortfunc.generateGap(sht2.data);
		long start1 = System.nanoTime()/1000;
		sht2.sort = sortfunc.sortFunction(sht2.data,sht2.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht2.sort);
		System.out.println();
		sht2.data.clear(); //clearing all global arrays after use
		sht2.gaps.clear();
		sht2.sort.clear();
		//running on almost sorted input of 1000 numbers
		System.out.println("running on almost sorted input of 1000 numbers");
		sht2.almostSort = sortfunc.generateAlmostSorted(1000);
		sht2.gaps = sortfunc.generateGap(sht2.almostSort);
		long start2 = System.nanoTime()/1000;
		sht2.sort = sortfunc.sortFunction(sht2.almostSort,sht2.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht2.sort);
		System.out.println();
		sht2.almostSort.clear(); //clearing all global arrays after use
		sht2.gaps.clear();
		sht2.sort.clear();
	}

}