import java.io.*;
import java.util.*;

public class ShellPratt extends SortOperations {
	
	public ArrayList<Integer> readFile(String filename) {
		ArrayList<Integer> genData = new ArrayList<>();
		File file = new File(filename);
		Scanner sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNext()) {
				if(sc.hasNextInt()) {
					genData.add(sc.nextInt());
				}
				else {
					sc.next();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return genData;
	}
	
	public ArrayList<Integer> generateGap(ArrayList<Integer> numbers) {
		ArrayList<Integer> gapSeq = new ArrayList<>();
		for(int p=0; p<numbers.size(); p++) {
			for(int q=0; q<numbers.size(); q++) {
				int gap1 = (int)Math.pow(2,p);
				int gap2 = (int)Math.pow(3,q);
				int gap = gap1 * gap2;
				if(gap<numbers.size()) {
					gapSeq.add(gap);
				}
				else {
					break;
				}
			}
		}
		Collections.sort(gapSeq,Collections.reverseOrder());
		return gapSeq;
	}
	
	public ArrayList<Integer> sortFunction(ArrayList<Integer> numbers, ArrayList<Integer> gapSequence) {
		ArrayList<Integer> sorted = new ArrayList<>();
		sorted.addAll(numbers);
		for(int g: gapSequence) {
			for(int i=g; i<sorted.size(); i++) {
				int temp = sorted.get(i);
				int j;
				for(j=i; j>=g && sorted.get(j-g)>temp; j-=g) {
					sorted.set(j,sorted.get(j-g));
				}
				sorted.set(j,temp);
			}
		}
		return sorted;
	}
	
	public void checkCorrect(ArrayList<Integer> sortList) {
		int flag = 0;
		for(int i=1; i<sortList.size(); i++) {
			if(sortList.get(i)<sortList.get(i-1)) {
				flag = 1;
			}
		}
		if(flag==0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
	public ArrayList<Integer> generateAlmostSorted(int n) {
		ArrayList<Integer> almostSorted = new ArrayList<>();
		Random rand = new Random();
		for(int i=1; i<=n; i++) {
			almostSorted.add(i);
		}
		int b = (int)(Math.log(n/Math.log(2)))+1;
		int times = 2*b;
		while(times>0) {
			int rand1 = rand.nextInt(n);
			int rand2 = rand.nextInt(n);
			Collections.swap(almostSorted,rand1,rand2);
			times--;
		}
		return almostSorted;
	}
	
}
