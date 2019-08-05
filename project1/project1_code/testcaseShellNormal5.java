//TESTCASE (Normal Shell Sort) 5: Running time on uniform and almost sorted input of 1000000 numbers

import java.util.*;

public class testcaseShellNormal5 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellNormal(); //noraml sort algo object
		testcaseShellNormal5 snt5 = new testcaseShellNormal5(); //testcase obj
		String testFile = "test1000000.txt";
		System.out.println("NORMAL SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 1000000 numbers
		System.out.println("running on uniformly distributed input of 1000000 numbers");
		snt5.data = sortfunc.readFile(testFile);
		snt5.gaps = sortfunc.generateGap(snt5.data);
		long start1 = System.nanoTime()/1000;
		snt5.sort = sortfunc.sortFunction(snt5.data,snt5.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt5.sort);
		System.out.println();
		snt5.data.clear(); //clearing all global arrays after use
		snt5.gaps.clear();
		snt5.sort.clear();
		//running on almost sorted input of 1000000 numbers
		System.out.println("running on almost sorted input of 1000000 numbers");
		snt5.almostSort = sortfunc.generateAlmostSorted(1000000);
		snt5.gaps = sortfunc.generateGap(snt5.almostSort);
		long start2 = System.nanoTime()/1000;
		snt5.sort = sortfunc.sortFunction(snt5.almostSort,snt5.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt5.sort);
		System.out.println();
		snt5.almostSort.clear(); //clearing all global arrays after use
		snt5.gaps.clear();
		snt5.sort.clear();
	}

}