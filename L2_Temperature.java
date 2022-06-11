package Practice;

import java.util.Scanner;

public class L2_Temperature {

	public static void main(String[] args) {
// 사용자로부터 화씨 온도를 입력받아 섭씨 온도로 변환하여 출력하는 프로그램
		
		double c;
		double f;
		
		
		Scanner  in = new Scanner(System.in);
		
		
		
		System.out.print("화씨 온도를 입력하시오: ");
		f =in.nextInt();
		
		c=5/9*(f-32);
		
		System.out.println("섭씨 온도는: " + c);
		
		

	}

}
