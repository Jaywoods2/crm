package cn.zk.daoimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//String svr_due_date =
		Date d2=format.parse("2015-12-23");
		Date d1=new Date();
		long diff=d1.getTime()-d2.getTime();
		long days=diff / (1000 * 60 * 60 * 24); 
		System.out.println(days);
	}

}
