//TESTCASE (Normal Shell Sort) 2: Running time on uniform and almost sorted input of 1000 numbers

import java.util.*;

public class testcaseShellNormal2 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellNormal(); //noraml sort algo object
		testcaseShellNormal2 snt2 = new testcaseShellNormal2(); //testcase obj
		String testFile = "test1000.txt";
		System.out.println("NORMAL SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000 numbers
		System.out.println("running on uniformly distributed input of 1000 numbers");
		snt2.data = sortfunc.readFile(testFile);
		snt2.gaps = sortfunc.generateGap(snt2.data);
		long start1 = System.nanoTime()/1000;
		snt2.sort = sortfunc.sortFunction(snt2.data,snt2.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt2.sort);
		System.out.println();
		snt2.data.clear(); //clearing all global arrays after use
		snt2.gaps.clear();
		snt2.sort.clear();
		//running on almost sorted input of 1000 numbers
		System.out.println("running on almost sorted input of 1000 numbers");
		snt2.almostSort = sortfunc.generateAlmostSorted(1000);
		snt2.gaps = sortfunc.generateGap(snt2.almostSort);
		long start2 = System.nanoTime()/1000;
		snt2.sort = sortfunc.sortFunction(snt2.almostSort,snt2.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt2.sort);
		System.out.println();
		snt2.almostSort.clear(); //clearing all global arrays after use
		snt2.gaps.clear();
		snt2.sort.clear();
	}

}