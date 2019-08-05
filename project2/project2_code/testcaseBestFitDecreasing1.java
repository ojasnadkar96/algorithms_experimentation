//TESTCASE (Best Fit Decreasing) 1: Taking example given in the slides and comparing answer for correctness

import java.util.*;

public class testcaseBestFitDecreasing1 {

	ArrayList<Double> slideData = new ArrayList<>(Arrays.asList(0.2,0.5,0.4,0.7,0.1,0.3,0.8)); 
	//numbers given in the slides
	
	public static void main(String args[]) {
		BinOperations binfunc = new BestFitDecreasing();
		testcaseBestFitDecreasing1 bfd1 = new testcaseBestFitDecreasing1();
		System.out.println("BEST FIT DECREASING");
		System.out.println();
		double numBins = binfunc.getBins(bfd1.slideData);
		double dataSum = binfunc.getSum(bfd1.slideData);
		double wasteFunc = binfunc.getWaste(numBins,dataSum);
		System.out.println("Data is: " + bfd1.slideData.toString());
		System.out.println();
		System.out.println("Number of bins required: " + numBins);
		System.out.println();
		System.out.println("Sum of all the numbers in data: " + dataSum);
		System.out.println();
		System.out.println("Waste W(A): " + wasteFunc);
		System.out.println();
	}
}