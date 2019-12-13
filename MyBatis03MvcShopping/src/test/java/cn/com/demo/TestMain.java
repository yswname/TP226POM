package cn.com.demo;

public class TestMain {

	public static void main(String[] args) {
		猫 mao = new 猫();
		动物 a = mao;
		System.out.println("over");
		
		动物 d = new 猫();
		猫 m = (猫)d;
	}

}
