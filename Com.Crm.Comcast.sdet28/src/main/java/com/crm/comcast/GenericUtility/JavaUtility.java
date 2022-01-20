package com.crm.comcast.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Rohit
 *
 */
public class JavaUtility {
	/**
	 * This method will return random number
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int randomNumber=ran.nextInt(4000);
		return randomNumber;
	}
	/**
	 * This method will return system data and time
	 * @return
	 */
	public String systemDateAndTime() {
		Date date = new Date();
		String dateAndTime = date.toString();
		return dateAndTime;
		
		
		
	}

}
