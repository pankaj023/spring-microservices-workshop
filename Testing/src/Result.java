
public class Result {


	public static void maxStep(int n, int k) {
		int position =0;
		int action = n;
		int badStep = k;
		int counter =1;
		while(action > 0) {
			if(badStep != (position + counter)) {
				position = position + counter;
			}
			action--;
			counter ++;
		}
		System.out.println(position);
	}

	public static void main(String[] args) {
		maxStep(3,3);
		// TODO Auto-generated method stub

	}

}
