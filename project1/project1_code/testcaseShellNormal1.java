//TESTCASE (Normal Shell Sort) 1: Running time on uniform and almost sorted input of 100 numbers

import java.util.*;

public class testcaseShellNormal1 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellNormal(); //noraml sort algo object
		testcaseShellNormal1 snt1 = new testcaseShellNormal1(); //testcase obj
		String testFile = "test100.txt";
		System.out.println("NORMAL SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100 numbers
		System.out.println("running on uniformly distributed input of 100 numbers");
		snt1.data = sortfunc.readFile(testFile);
		snt1.gaps = sortfunc.generateGap(snt1.data);
		long start1 = System.nanoTime()/1000;
		snt1.sort = sortfunc.sortFunction(snt1.data,snt1.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt1.sort);
		System.out.println();
		snt1.data.clear(); //clearing all global arrays after use
		snt1.gaps.clear();
		snt1.sort.clear();
		//running on almost sorted input of 100 numbers
		System.out.println("running on almost sorted input of 100 numbers");
		snt1.almostSort = sortfunc.generateAlmostSorted(100);
		snt1.gaps = sortfunc.generateGap(snt1.almostSort);
		long start2 = System.nanoTime()/1000;
		snt1.sort = sortfunc.sortFunction(snt1.almostSort,snt1.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt1.sort);
		System.out.println();
		snt1.almostSort.clear(); //clearing all global arrays after use
		snt1.gaps.clear();
		snt1.sort.clear();
	}

}
