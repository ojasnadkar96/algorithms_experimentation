//TESTCASE (Hibbard Shell Sort) 3: Running time on uniform and almost sorted input of 10000 numbers

import java.util.*;

public class testcaseShellHibbard3 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellHibbard(); //noraml sort algo object
		testcaseShellHibbard3 sht3 = new testcaseShellHibbard3(); //testcase obj
		String testFile = "test10000.txt";
		System.out.println("HIBBARD SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 10000 numbers
		System.out.println("running on uniformly distributed input of 100 numbers");
		sht3.data = sortfunc.readFile(testFile);
		sht3.gaps = sortfunc.generateGap(sht3.data);
		long start1 = System.nanoTime()/1000;
		sht3.sort = sortfunc.sortFunction(sht3.data,sht3.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht3.sort);
		System.out.println();
		sht3.data.clear(); //clearing all global arrays after use
		sht3.gaps.clear();
		sht3.sort.clear();
		//running on almost sorted input of 10000 numbers
		System.out.println("running on almost sorted input of 10000 numbers");
		sht3.almostSort = sortfunc.generateAlmostSorted(10000);
		sht3.gaps = sortfunc.generateGap(sht3.almostSort);
		long start2 = System.nanoTime()/1000;
		sht3.sort = sortfunc.sortFunction(sht3.almostSort,sht3.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht3.sort);
		System.out.println();
		sht3.almostSort.clear(); //clearing all global arrays after use
		sht3.gaps.clear();
		sht3.sort.clear();
	}

}