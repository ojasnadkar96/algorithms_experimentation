//TESTCASE (Next Fit) 1: Taking example given in the slides and comparing answer for correctness

import java.util.*;

public class testcaseNextFit1 {

	ArrayList<Double> slideData = new ArrayList<>(Arrays.asList(0.5,0.7,0.5,0.2,0.4,0.2,0.5,0.1,0.6)); 
	//numbers given in the slides
	
	public static void main(String args[]) {
		BinOperations binfunc = new NextFit();
		testcaseNextFit1 nf1 = new testcaseNextFit1();
		System.out.println("NEXT FIT");
		System.out.println();
		double numBins = binfunc.getBins(nf1.slideData);
		double dataSum = binfunc.getSum(nf1.slideData);
		double wasteFunc = binfunc.getWaste(numBins,dataSum);
		System.out.println("Data is: " + nf1.slideData.toString());
		System.out.println();
		System.out.println("Number of bins required: " + numBins);
		System.out.println();
		System.out.println("Sum of all the numbers in data: " + dataSum);
		System.out.println();
		System.out.println("Waste W(A): " + wasteFunc);
		System.out.println();
	}
}
