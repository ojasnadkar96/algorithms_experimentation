import java.util.*;
import java.text.*;
import java.io.*;
import java.math.*;

public class NextFit extends BinOperations {

	ArrayList<Double> data;
	
	public ArrayList<Double> genNumbers(int size) {
		DecimalFormat dec =  new DecimalFormat("#.#");
		BigDecimal bds = new BigDecimal("0.1");
		BigDecimal bdf = new BigDecimal("0.8");
		data = new ArrayList<>();
		Random rand = new Random();
		for(int i=0; i<size; i++) {
			Double tempNum = rand.nextDouble()*(bdf.doubleValue()-bds.doubleValue()) + bds.doubleValue();
			Double format = Double.valueOf(dec.format(tempNum));
			data.add(format);
		}
		return data;
	}
	
	public ArrayList<Double> readFile(String filename) {
		data = new ArrayList<>();
		File file = new File(filename);
		DecimalFormat dec =  new DecimalFormat("#.#");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNext()) {
				if(sc.hasNextDouble()) {
					Double tempData = Double.valueOf(dec.format(sc.nextDouble()));
					data.add(tempData);
				}
				else {
					sc.next();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public double getBins(ArrayList<Double> data) {
		double numBins = 0;
		Double size = 1.0;
		for(Double d: data) {
			BigDecimal bd1 = new BigDecimal(size.toString());
			BigDecimal bd2 = new BigDecimal(d.toString());
			if(bd1.compareTo(bd2)<0) {
				BigDecimal bd3 = new BigDecimal("1.0");
				numBins++;
				bd3 = bd3.subtract(bd2);
				size = bd3.doubleValue();
			}
			else {
				bd1 = bd1.subtract(bd2);
				size = bd1.doubleValue();
			}
		}
		return numBins+1;
	}
	
	public double getSum(ArrayList<Double> data) {
		double sum = 0.0;
		DecimalFormat dec =  new DecimalFormat("#.#");
		for(Double dSum: data) {
			sum = sum + dSum;
		}
		return Double.valueOf(dec.format(sum));
	}
	
	public double getWaste(Double bins, Double sum) {
		BigDecimal bd4 = new BigDecimal(bins.toString());
		BigDecimal bd5 = new BigDecimal(sum.toString());
		bd4 = bd4.subtract(bd5);
		double waste = bd4.doubleValue();
		return waste;
	}
	
}
