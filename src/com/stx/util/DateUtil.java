package com.stx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static void main(String[] args) {
		System.out.println(getTimeFileName("aa.doc"));
	}
	
	public static String getTimeFileName(String srcName) {
		//获取后缀名那个分隔符'.'的索引
		int pos = srcName.lastIndexOf(".");
		//取得文件的完整后缀名
		String subfix = srcName.substring(pos);
		//返回按照时间格式定义的新的文件的名字
		return getTimeString() + subfix;
	}
	
	public static String getTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
}
