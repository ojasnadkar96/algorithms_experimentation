//TESTCASE (Normal Shell Sort) 4: Running time on uniform and almost sorted input of 100000 numbers

import java.util.*;

public class testcaseShellNormal4 {
	
	ArrayList<Integer> data;
	ArrayList<Integer> gaps;
	ArrayList<Integer> sort;
	ArrayList<Integer> almostSort;
	
	public static void main(String args[]) {
		SortOperations sortfunc = new ShellNormal(); //noraml sort algo object
		testcaseShellNormal4 snt4 = new testcaseShellNormal4(); //testcase obj
		String testFile = "test100000.txt";
		System.out.println("NORMAL SHELL SORT");
		System.out.println();
		//running on uniformly distributed input of 100000 numbers
		System.out.println("running on uniformly distributed input of 100000 numbers");
		snt4.data = sortfunc.readFile(testFile);
		snt4.gaps = sortfunc.generateGap(snt4.data);
		long start1 = System.nanoTime()/1000;
		snt4.sort = sortfunc.sortFunction(snt4.data,snt4.gaps);
		long end1 = System.nanoTime()/1000;
		int time1 = (int)(end1-start1);
		System.out.println("Time: " + time1 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt4.sort);
		System.out.println();
		snt4.data.clear(); //clearing all global arrays after use
		snt4.gaps.clear();
		snt4.sort.clear();
		//running on almost sorted input of 100 numbers
		System.out.println("running on almost sorted input of 100000 numbers");
		snt4.almostSort = sortfunc.generateAlmostSorted(100000);
		snt4.gaps = sortfunc.generateGap(snt4.almostSort);
		long start2 = System.nanoTime()/1000;
		snt4.sort = sortfunc.sortFunction(snt4.almostSort,snt4.gaps);
		long end2 = System.nanoTime()/1000;
		int time2 = (int)(end2-start2);
		System.out.println("Time: " + time2 + " microseconds");
		System.out.print("Is sorted array correct? ");
		sortfunc.checkCorrect(snt4.sort);
		System.out.println();
		snt4.almostSort.clear(); //clearing all global arrays after use
		snt4.gaps.clear();
		snt4.sort.clear();
	}

}
