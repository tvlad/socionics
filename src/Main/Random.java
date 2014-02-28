package Main;


import org.testng.annotations.Test;

public class Random {
		
	public static String randomEmail(){
		
		String allowedChars = "abcdefghiklmnopqrstuvwxyz";
		String randommail = "";
		int num = (int) (Math.floor(Math.random()*(8-3))+3);
		
		for (int i=0; i<num; i++){
			int rnum = (int) Math.floor(Math.random()*allowedChars.length());
			randommail = randommail + allowedChars.subSequence(rnum, rnum+1);
		}
		
		randommail += "@gmail.com";
		//System.out.println(randomstring);
		return randommail;
		
	}
		
	
	public static String randomLogin(){
		
		String randomstring = "";
		String allowedChars1 = "bcdfghklmnpqrstvwxz";
		String allowedChars2 = "aeiouy";
		int num = (int) (Math.floor(Math.random()*(4-3))+3);
		
		for (int i=0; i<num; i++){
			if (i%2==0)
		    {
	          int rnum2 = (int) Math.floor(Math.random() * allowedChars1.length());
		      randomstring += allowedChars1.substring(rnum2,rnum2+1);
		    }

		   else 
		    {
		      int rnum = (int) Math.floor(Math.random() * allowedChars2.length());
		      randomstring += allowedChars2.substring(rnum,rnum+1);
		    }
		}
		randomstring = randomstring.toUpperCase().substring(0, 1) + randomstring.substring(1);
		
		
		return randomstring; 
	}
	
	public static int rInt() {
		int num = (int) (Math.floor(Math.random()*(7-0))+0);
		return num;
	}
	
	@Test
	public void Print (){
		String a = randomEmail();
		System.out.println(a);
		
		System.out.println(" ");
		
		String b = randomLogin();
		System.out.println(b);
		
	}
	
}
