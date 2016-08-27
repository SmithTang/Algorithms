package per.tj.sort;

import java.util.Random;

public class Utils {

	public static int[] RandomIntegers(int length, int maximum) {
		
		int[] randomIntegers = new int[length] ;
		
		if(length < 0) {
			System.out.println("Length can't lower than 0...");
			return null;
		}
		
		else if(length == 0)
			return null;
		
		else {
			Random rm = new Random();
			rm.setSeed(System.currentTimeMillis());
			for(int i = 0; i< length; ++i) {
				randomIntegers[i] = rm.nextInt(maximum);
			}
			
			return randomIntegers;
		}
	}
	
}
