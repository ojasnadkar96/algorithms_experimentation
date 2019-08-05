//TESTCASE (Hibbard Shell Sort) 4: Running time on uniform and almost sorted input of 100000 numbers

import java.util.*;

public class testcaseShellHibbard4 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellHibbard(); //noraml sort algo object
		testcaseShellHibbard4 sht4 = new testcaseShellHibbard4(); //testcase obj
		String testFile = "test100000.txt";
		System.out.println("HIBBARD SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100000 numbers
		System.out.println("running on uniformly distributed input of 100000 numbers");
		sht4.data = sortfunc.readFile(testFile);
		sht4.gaps = sortfunc.generateGap(sht4.data);
		long start1 = System.nanoTime()/1000;
		sht4.sort = sortfunc.sortFunction(sht4.data,sht4.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht4.sort);
		System.out.println();
		sht4.data.clear(); //clearing all global arrays after use
		sht4.gaps.clear();
		sht4.sort.clear();
		//running on almost sorted input of 100000 numbers
		System.out.println("running on almost sorted input of 100000 numbers");
		sht4.almostSort = sortfunc.generateAlmostSorted(100000);
		sht4.gaps = sortfunc.generateGap(sht4.almostSort);
		long start2 = System.nanoTime()/1000;
		sht4.sort = sortfunc.sortFunction(sht4.almostSort,sht4.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(sht4.sort);
		System.out.println();
		sht4.almostSort.clear(); //clearing all global arrays after use
		sht4.gaps.clear();
		sht4.sort.clear();
	}

}