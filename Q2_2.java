package Assignment2;

import java.util.Scanner;

public class Q2_2 {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
		int x;
		int y;
		int z;
		
		System.out.print("첫번째 숫자를 입력하시오: ");
		x = input.nextInt();
		
		System.out.print("두번째 숫자를 입력하시오: ");
		y = input.nextInt();
		
		System.out.print("세번째 숫자를 입력하시오: ");
		z = input.nextInt();
		
		
		
		System.out.println(((x>=y)&&(x>=z))+"");
		System.out.println(((x==y)&&(x==z)) +" ");
	}

}
