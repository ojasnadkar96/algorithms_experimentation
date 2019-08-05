//TESTCASE (Hibbard Shell Sort) 5: Running time on uniform and almost sorted input of 1000000 numbers

import java.util.*;

public class testcaseShellHibbard5 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellHibbard(); //noraml sort algo object
		testcaseShellHibbard5 sht5 = new testcaseShellHibbard5(); //testcase obj
		String testFile = "test1000000.txt";
		System.out.println("HIBBARD SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000000 numbers
		System.out.println("running on uniformly distributed input of 1000000 numbers");
		sht5.data = sortfunc.readFile(testFile);
		sht5.gaps = sortfunc.generateGap(sht5.data);
		long start1 = System.nanoTime()/1000;
		sht5.sort = sortfunc.sortFunction(sht5.data,sht5.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht5.sort);
		System.out.println();
		sht5.data.clear(); //clearing all global arrays after use
		sht5.gaps.clear();
		sht5.sort.clear();
		//running on almost sorted input of 1000000 numbers
		System.out.println("running on almost sorted input of 1000000 numbers");
		sht5.almostSort = sortfunc.generateAlmostSorted(1000000);
		sht5.gaps = sortfunc.generateGap(sht5.almostSort);
		long start2 = System.nanoTime()/1000;
		sht5.sort = sortfunc.sortFunction(sht5.almostSort,sht5.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht5.sort);
		System.out.println();
		sht5.almostSort.clear(); //clearing all global arrays after use
		sht5.gaps.clear();
		sht5.sort.clear();
	}

}