
public class ReverseString {
	 static String rev;
	  public static String reverse(String str) 
	    { 
	        if ((str==null)||(str.length() <= 1)) {
	           return str;
	        }
	        else
	        { 
	            return str.substring(str.length()-1) + reverse(str.substring(0,str.length()-1)); 
	        } 
	    } 

	public static void main(String[] args) {
		String s = "sachin";
		for (int i =s.length()-1; i>=0;i--) {
			s=s + s.toCharArray()[i];
		}
		String s2 = "sachin";
		System.out.println(s.substring(s.length()/2));
		System.out.println(reverse("sachin"));
		System.out.println(s2.substring(0,s2.length()-1));
		System.out.println(s2.substring(s2.length()-1));
	
		

	}

}
