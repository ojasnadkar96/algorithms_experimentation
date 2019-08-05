import java.util.*;

public abstract class SortOperations {
	
	public abstract ArrayList<Integer> readFile(String filename);
	public abstract ArrayList<Integer> generateGap(ArrayList<Integer> data);
	public abstract ArrayList<Integer> sortFunction(ArrayList<Integer> data, ArrayList<Integer> gaps);
	public abstract void checkCorrect(ArrayList<Integer> sort);
	public abstract ArrayList<Integer> generateAlmostSorted(int n);
}
