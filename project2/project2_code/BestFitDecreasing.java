import java.util.*;
import java.text.*;
import java.io.*;
import java.math.*;

public class BestFitDecreasing extends BinOperations {

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
		TreeMap<Double,Integer> bestFitMap = new TreeMap<>();
		Collections.sort(data,Collections.reverseOrder());
		for(Double d: data) {
			if(bestFitMap.isEmpty()) {
				BigDecimal bd1 = new BigDecimal("1.0");
				BigDecimal bd2 = new BigDecimal(d.toString());
				bd1 = bd1.subtract(bd2);
				bestFitMap.put(bd1.doubleValue(),1);
				continue;
			}
			if(bestFitMap.containsKey(d)) {
				BigDecimal bd3 = new BigDecimal(d.toString());
				BigDecimal bd4 = new BigDecimal(0.0);
				if(bestFitMap.get(bd3.doubleValue())>1) {
					int tempVal = bestFitMap.get(bd3.doubleValue())-1;
					bestFitMap.put(bd3.doubleValue(),tempVal);
				}
				else {
					bestFitMap.remove(bd3.doubleValue());
				}
				bestFitMap.put(bd4.doubleValue(),bestFitMap.getOrDefault(bd4.doubleValue(),0)+1);
				continue;
			}
			else if(bestFitMap.higherKey(d)!=null) {
				BigDecimal bd5 = new BigDecimal(d.toString());
				BigDecimal bd6 = new BigDecimal(bestFitMap.higherKey(d).toString());
				if(bestFitMap.get(bd6.doubleValue())>1) {
					int tempVal = bestFitMap.get(bd6.doubleValue())-1;
					bestFitMap.put(bd6.doubleValue(),tempVal);
				}
				else {
					bestFitMap.remove(bd6.doubleValue());
				}
				bd6 = bd6.subtract(bd5);
				bestFitMap.put(bd6.doubleValue(),bestFitMap.getOrDefault(bd6.doubleValue(),0)+1);
				continue;
			}
			else {
				BigDecimal bd7 = new BigDecimal("1.0");
				BigDecimal bd8 = new BigDecimal(d.toString());
				bd7 = bd7.subtract(bd8);
				bestFitMap.put(bd7.doubleValue(),bestFitMap.getOrDefault(bd7.doubleValue(),0)+1);
				continue;
			}
		}
		int sumBins = 0;
		Iterator<Integer> valueIterator = bestFitMap.values().iterator();
		while(valueIterator.hasNext()) {
			sumBins = sumBins + valueIterator.next();
		}
		return (double)sumBins;
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
