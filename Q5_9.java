
package Assignment5;

import java.util.Scanner;

public class Q5_9 {

	public static void main(String[] args) {
		//출력 형태를 만든다. 
		//사용자로부터 n을 입력받아 nxn의 출력형태를 만든다.
		Scanner in = new Scanner(System.in);
		
		System.out.print("n=");
		int n = in.nextInt();
		int number = 1;
		
		int row=0;
		
		
		while(row<n) {
			row++;
			int col=0;
			while(col<n) {
				col++;
				System.out.print(number%10+" ");
				number+=2;
				
			}
			System.out.println();
			
		}
//		for(int row=0; row<n; row++) {
//			for(int col=0; col<n; col++) {
//				System.out.print(number%10 +" ");
//				number+=2;             //number=number+2
//			}
//			System.out.println();
//		}

	}

}

