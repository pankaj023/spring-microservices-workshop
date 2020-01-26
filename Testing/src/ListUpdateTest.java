import java.util.ArrayList;
import java.util.List;

public class ListUpdateTest {

	public static void updateList(List<Integer> list) {
		int counter = 1;

		while (true) {

			if(counter == 0) {
				break;
			}
			counter = 0;
			for(int i = 1;i< list.size()-1; i++) {
				if((list.get(i) < list.get(i-1)) && (list.get(i) < list.get(i+1))) {
					list.remove(i);
					counter ++;
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		list.add(40);
		list.add(8);
		list.add(6);
		list.add(22);
		list.add(9);
		list.add(7);
		list.add(50);
		
//		list.add(10);
//		list.add(20);
//		list.add(5);
//		list.add(30);
//		list.add(4);
//		list.add(20);
//		list.add(60);
		updateList(list);

	}

}
