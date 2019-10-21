package cn.com.demo.test;
/**
 * 分析数列
 * 1 x+0  1x+1  2x+1 3x+2 5x+3 ...
 * n>=3   尾数是：尾数(n)=尾数(n-1) + 尾数(n-2)
 *        
 * */
public class TestMain {
	
	public static int begin(int n) {
		int result = -1;
		if(n == 1) {
			result = 0;
		}else if(n == 2) {
			result = 1;
		}else {
			result = begin(n-1) + begin(n-2);
		}
		return result;
	}
	public static int end(int n) {
		int result = -1;
		if(n ==1) {
			result = 1;
		}else if(n == 2) {
			result = 0;
		}else {
			result = end(n-1) + end(n-2);
		}
		return result;
	}

	public static void main(String[] args) {
		// F(n) = end(n) + begin(n)x
		// x = (f(n)- end(n))/begin(n);
		
		double x = (100-end(10))/(double)begin(10);
		System.out.println(x);
		
		x = (89-end(10))/(double)begin(10);
		System.out.println(x);
	}
	
}
