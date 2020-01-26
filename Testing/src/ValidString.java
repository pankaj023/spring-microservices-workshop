import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class ValidString {
	public static void main(String[] args) {
		String regex = "^[a-zA-Z]+[a-zA-Z0-9+._$&#@-]*$";
		String name="asd146._$&#@-546546";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
       System.out.println(matcher.matches());
       
       String number = "MH14FP";
       number = number.substring(0,2) + " " + number.substring(2,4) + " " + number.substring(4,6) + " " + number.substring(6);
       System.out.println(number);
       
       try { 
    	   String input="1211";
           MessageDigest md = MessageDigest.getInstance("SHA-1"); 
           byte[] messageDigest = md.digest(input.getBytes()); 
           BigInteger no = new BigInteger(1, messageDigest); 
           String hashtext = no.toString(16); 
           while (hashtext.length() < 32) { 
               hashtext = "0" + hashtext; 
           } 
           System.out.println(hashtext);
 
       } 
 
       // For specifying wrong message digest algorithms 
       catch (NoSuchAlgorithmException e) { 
           throw new RuntimeException(e); 
       } 
	}

}
