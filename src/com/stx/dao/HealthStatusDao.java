package com.stx.dao;

public class HealthStatusDao {
/**
 * 输入身高、体重 算BIM
 * 体重指数BMI=体重/身高的平方（国际单位kg/㎡）
 * @param int hight,int weight
 * @return double BIM
 */
	public static double bim(double hight,double weight) {
		double 	bim=weight/Math.pow(hight/100, 2);
		return  Double.parseDouble(String.format("%.2f", bim));
	}
	
/**s
 *	算取体脂率
 * @param BIM 、年龄、性别
 * @return BFR
 */
	public static double bfr(double bim,int age,int gender) {
		double bfr=1.2*bim+0.23*age-5.4-10.8*gender;
		return Double.parseDouble(String.format("%.2f", bfr));
	}
}
