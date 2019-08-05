//TESTCASE (Next Fit) 3: Running time random input of 10000 floating point numbers in range [0.1-0.8]

import java.util.*;
import java.math.*;
import java.text.*;

public class testcaseNextFit4 {

	ArrayList<Double> data; 
	//storing the input
	
	public static void main(String args[]) {
		BinOperations binfunc = new NextFit();
		testcaseNextFit4 nf4 = new testcaseNextFit4();
		int testSize = 10000;
		String filename = "test10000.txt";
		nf4.data = binfunc.readFile(filename);
		System.out.println("NEXT FIT");
		System.out.println();
		double sumWaste = 0.0;
		System.out.println("Randomly generated iterations");
		System.out.println();
		for(int i=1; i<=10; i++) {
			System.out.println("Iteration: " + i);
			System.out.println();
			nf4.data = binfunc.genNumbers(testSize);
			double numBins = binfunc.getBins(nf4.data);
			double dataSum = binfunc.getSum(nf4.data);
			double wasteFunc = binfunc.getWaste(numBins,dataSum);
			sumWaste += wasteFunc;
			System.out.println("Input of 10000 random floating point numbers in range [0.1-0.8]");
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
		nf4.data.clear();
		System.out.println("Reading from generated file");
		System.out.println();
		nf4.data = binfunc.readFile(filename);
		double numBins = binfunc.getBins(nf4.data);
		double dataSum = binfunc.getSum(nf4.data);
		double wasteFunc = binfunc.getWaste(numBins,dataSum);
		System.out.println("Input of 10000 random floating point numbers in range [0.1-0.8]");
		System.out.println();
		System.out.println("Number of bins required: " + numBins);
		System.out.println();
		System.out.println("Sum of all the numbers in data: " + dataSum);
		System.out.println();
		System.out.println("Waste W(A): " + wasteFunc);
		System.out.println();
	}
}