package Assignment2;

import java.util.Scanner;

public class Q2_3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x;
		int y;

		
		
		System.out.print("첫번재 숫자를 입력하세요: ");
		x = in.nextInt();
		
		System.out.print("두번째 숫자를 입력하세요: ");
		y = in.nextInt();
		
		
		
		int nextx = x++;
		int nexty = --y;
		int z = nextx*nexty;
		
		System.out.print(x+" " + y + " "+ z);
		
		
		
		
		

	}

}
