import java.util.ArrayList;
import java.util.List;

public class sumDiagonal {

	public static void main(String[] args) {
		int sum=0;
		int sum2=0;
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		temp.add(23);
		
		list.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(5);
		temp.add(6);
		list.add(temp);
		temp = new ArrayList<>();
		temp.add(7);
		temp.add(8);
		temp.add(9);
		list.add(temp);
		
		for(int i =0; i<list.size();i++) {
			sum = sum + list.get(i).get(i);
			sum2 =sum2 + list.get(i).get(list.get(i).size() -1 -i);
		}
		System.out.println(sum + " " + sum2);
	
	}

}
