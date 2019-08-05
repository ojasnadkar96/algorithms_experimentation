import java.util.*;

public abstract class BinOperations {
	
	public abstract ArrayList<Double> genNumbers(int size);
	public abstract ArrayList<Double> readFile(String filename);
	public abstract double getBins(ArrayList<Double> data);
	public abstract double getSum(ArrayList<Double> data);
	public abstract double getWaste(Double bins, Double sum);
	
}