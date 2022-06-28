package Assignment5;

import java.util.Scanner;

public class Q5_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("자연수를 하나 입력하시오: ");
		int a= in.nextInt();
		for(int i=0;i<a;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=(a-i)*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
