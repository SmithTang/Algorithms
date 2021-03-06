package per.tj.sort;

import java.util.Random;
import java.lang.reflect.*;

/**
 * Common Utils:<br>
 * Math_About: RandomIntegers,<br>
 * @version 1.0
 * @author Coder_T
 * @Time 2016-8-27 21:54:56
 *
 */
public class Utils {

	//noninstantiability
	private Utils() {
		throw new AssertionError();
	}
	
	/**
	 * 
	 * @param length
	 * @param maximum
	 * @return new int[length] and bounded between 0 ~ maximum
	 */
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
	
	/**
	 * way to use: <br>
	 * Object[] a; <br>
	 * a = (Object[]) copyOf(a, 100);
	 * @param a must be an Array
	 * @param newLength
	 * @return Object newArray
	 */
	@SuppressWarnings("rawtypes")
	public static Object copyOf(Object a, int newLength) {
		Class cl = a.getClass();
		if(!cl.isArray()) return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
	
}
