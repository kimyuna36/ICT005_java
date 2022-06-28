package Assignment2;

import java.util.Scanner;

public class Q2_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("민수와 기영이의 키와 몸무게를 차례로 입력하시오: ");
		int m_height=in.nextInt();
		int m_weight=in.nextInt();
		int k_height=in.nextInt();
		int k_weight=in.nextInt();
		
		if((m_height>k_height)&&(m_weight>k_weight)){
			System.out.print(true);
		}
		else {
			System.out.print(false);
			
		}

	}

}
