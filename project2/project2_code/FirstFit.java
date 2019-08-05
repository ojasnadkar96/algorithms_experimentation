import java.util.*;
import java.text.*;
import java.io.*;
import java.math.*;

public class FirstFit extends BinOperations {

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
		SortedMap<Integer,Double> firstFitMap = new TreeMap<>();
		int globalIndex = 1;
		for(Double d: data) {
			int flag = 0;
			Iterator<Integer> keyIterator = firstFitMap.keySet().iterator();
			if(firstFitMap.isEmpty()) {
				BigDecimal bd1 = new BigDecimal("1.0");
				BigDecimal bd2 = new BigDecimal(d.toString());
				bd1 = bd1.subtract(bd2);
				firstFitMap.put(globalIndex,bd1.doubleValue());
				globalIndex++;
				continue;
			}
			while(keyIterator.hasNext()) {
				Integer nextVal = keyIterator.next();
				BigDecimal bd3 = new BigDecimal(firstFitMap.get(nextVal).toString());
				BigDecimal bd4 = new BigDecimal(d.toString());
				if(bd3.compareTo(bd4)>=0) {
					bd3 = bd3.subtract(bd4);
					firstFitMap.put(nextVal,bd3.doubleValue());
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				BigDecimal bd5 = new BigDecimal("1.0");
				BigDecimal bd6 = new BigDecimal(d.toString());
				bd5 = bd5.subtract(bd6);
				firstFitMap.put(globalIndex,bd5.doubleValue());
				globalIndex++;
			}
		}
		return firstFitMap.size();
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
		BigDecimal bd7 = new BigDecimal(bins.toString());
		BigDecimal bd8 = new BigDecimal(sum.toString());
		bd7 = bd7.subtract(bd8);
		double waste = bd7.doubleValue();
		return waste;
	}
	
}