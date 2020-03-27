import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipleOf3 {
	public static int solution(int[] A) {
		List <Integer> temp = new ArrayList<>();
		
		for (int i = 0 ;i < A.length ; i++) {
			if(A[i]%3 == 0) {
				temp.add(A[i]);
			}
		}
		
		
	Collections.sort(temp,Collections.reverseOrder());
	
		
	return temp.get(0);
        // write your code in Java SE 8
    }
	public static void main(String[] args) {
		int[] A = {-6, -91, 1011, -100, 84, -22, 0, 1, 473};
		System.out.println(solution(A));
	}

}
