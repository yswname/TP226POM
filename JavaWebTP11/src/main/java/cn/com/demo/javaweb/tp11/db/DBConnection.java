package cn.com.demo.javaweb.tp11.db;

import java.lang.reflect.Method;

import cn.com.demo.javaweb.tp11.anno.DbInfo;

public class DBConnection {
	private static DBConnection DBCONN = null;// 饿汉
	private DBConnection()throws Exception{
		this.init();
	}
	
	public static DBConnection getInstance() {
		try {
			if(DBCONN == null) {
				DBCONN = new DBConnection();
			}
		}catch(Exception e) {e.printStackTrace();}
		return DBCONN;
	}

	@DbInfo(driverName="com.jdbc.mysql.Driver",url="jdbc:mysql://localhost:3306/my_db",userName="root",password="123456", age=20)
	private void init() throws Exception{
		// 读配置信息
		Class cls = DBConnection.class;
		Method initMethod = cls.getDeclaredMethod("init", null);
		DbInfo dbInfo = (DbInfo)initMethod.getAnnotation(DbInfo.class);
		String driverName = dbInfo.driverName();
		int age = dbInfo.age();
		System.out.println(driverName +"," + age);
		// 加载驱动类
		// 将其它信息，保存到成员变量中（url username password）
	}
}
