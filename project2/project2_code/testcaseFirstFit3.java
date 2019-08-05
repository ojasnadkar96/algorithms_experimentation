//TESTCASE (First Fit) 3: Running time random input of 1000 floating point numbers in range [0.1-0.8]

import java.util.*;
import java.math.*;
import java.text.*;

public class testcaseFirstFit3 {

	ArrayList<Double> data; 
	//storing the input
	
	public static void main(String args[]) {
		BinOperations binfunc = new FirstFit();
		testcaseFirstFit3 ff3 = new testcaseFirstFit3();
		int testSize = 1000;
		String filename = "test1000.txt";
		ff3.data = binfunc.readFile(filename);
		System.out.println("FIRST FIT - (With Extra Credit - Average Case O(nlogn))");
		System.out.println();
		double sumWaste = 0.0;
		System.out.println("Randomly generated iterations");
		System.out.println();
		for(int i=1; i<=10; i++) {
			System.out.println("Iteration: " + i);
			System.out.println();
			ff3.data = binfunc.genNumbers(testSize);
			double numBins = binfunc.getBins(ff3.data);
			double dataSum = binfunc.getSum(ff3.data);
			double wasteFunc = binfunc.getWaste(numBins,dataSum);
			sumWaste += wasteFunc;
			System.out.println("Input of 1000 random floating point numbers in range [0.1-0.8]");
			System.out.println();
			System.out.println("Number of bins required: " + numBins);
			System.out.println();
			System.out.println("Sum of all the numbers in data: " + dataSum);
			System.out.println();
			System.out.println("Waste W(A): " + wasteFunc);
			System.out.println();
		}
		DecimalFormat dec =  new DecimalFormat("#.#");
		Double formatWaste = Double.valueOf(dec.format(sumWaste));
		BigDecimal bdw1 = new BigDecimal("10.0");
		BigDecimal bdw2 = new BigDecimal(formatWaste.toString());
		bdw2 = bdw2.divide(bdw1,RoundingMode.CEILING);
		System.out.println("AVERAGE WASTE W(A) OVER 10 RANDOMLY GENERATED ITERATIONS IS: " + bdw2.doubleValue());
		System.out.println();
		ff3.data.clear();
		System.out.println("Reading from generated file");
		System.out.println();
		ff3.data = binfunc.readFile(filename);
		double numBins = binfunc.getBins(ff3.data);
		double dataSum = binfunc.getSum(ff3.data);
		double wasteFunc = binfunc.getWaste(numBins,dataSum);
		System.out.println("Input of 1000 random floating point numbers in range [0.1-0.8]");
		System.out.println();
		System.out.println("Number of bins required: " + numBins);
		System.out.println();
		System.out.println("Sum of all the numbers in data: " + dataSum);
		System.out.println();
		System.out.println("Waste W(A): " + wasteFunc);
		System.out.println();
	}
}