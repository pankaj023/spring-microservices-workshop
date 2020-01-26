import java.util.ArrayList;
import java.util.List;

public class Result_2 {
	static List <String> list = new ArrayList<>();

	public static String rearrangeWord(String word) {
		boolean flag = false;
		String result ="no answer";
		rearrangeList(word,"");
		System.out.println(list);
		
		char [] ch = word.toCharArray();
		
		for (String s : list) {
			if(s.equals(word)) {
				continue;
			}
			char[] temp = s.toCharArray();
			for(int i =0;i<temp.length;i++) {
				int a = temp[i];
				int b = ch[i];
				System.out.println(temp[i] + " " + a + " " + ch[i] + " " + b );
				if(a > b) {
					flag= true;
					break;
				}
			}
			if(flag) {
				result = s;
				break;
			}
		}
		return result;

	}

	static void rearrangeList(String word, String temp) 
	{ 

		if (word.length() == 0) { 
			list.add(temp);
			return ; 
		} 

		for (int i = 0; i < word.length(); i++) { 

			char ch = word.charAt(i); 

			String tempWord = word.substring(0, i) +  
					word.substring(i + 1); 

			rearrangeList(tempWord, temp + ch); 
		} 
	}
	public static void main(String[] args) {
		System.out.println(rearrangeWord("zzwspq"));

	}

}
