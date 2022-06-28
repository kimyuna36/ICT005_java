package Assignment5;

import java.util.Scanner;

public class Q5_2 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		
		if(a>b) {
		for(int i=1;i<=9;i++) {
			for(int j=a;j>=b;j--) {
				System.out.printf("%d*%d=%2d",j,i,j*i);
				System.out.print("   ");
				
			}
			System.out.println();
		}
		}
		
		else {
			for (int i=1;i<=9;i++) {
				for (int j=a; j<=b;j++) {
					System.out.printf("%d*%d=%2d",j,i,j*i);
					System.out.print("   ");
				}
			System.out.println();
			}
		}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner in = new Scanner(System.in);
//		System.out.print("2부터 9까지의 수 2개를 입력하시오: ");
//		int a =in.nextInt();
//		int b =in.nextInt();
//		
//		if(a>b) {
//			for(int i=1;i<=9;i++) {
//				for(int j=a;j>=b; j--) {
//					System.out.printf("%d*%d=%2d     ",j,i,j*i);
//				}
//				System.out.println();
//			}
//		}
//		else {
//			for (int i=1; i<=9; i++) {
//				for (int j=b; j>=a; j--) {
//					System.out.printf("%d*%d=%2d     ",j,i,j*i);
//				}
//				System.out.println();
//			}
//		}
//		
//		
//	}


