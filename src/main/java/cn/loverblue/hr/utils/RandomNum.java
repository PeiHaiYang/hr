package cn.loverblue.hr.utils;

/**
 * 随机数 可以指定相应的随机位数
 */

import java.util.Random;

public class RandomNum {

	public static String Rand() {
	    String para = "";
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			Integer num = rand.nextInt(10);
			para += num.toString();
		}
		return para;
	}

	
}