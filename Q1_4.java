
package Assignment1;

import java.util.Scanner;

public class Q1_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요: ");
		int var1 = input.nextInt();
		
		System.out.print("두번째 숫자를 입력하세요: ");
		int var2 = input.nextInt();
		
		System.out.print("세번째 숫자를 입력하세요: ");
		int var3 = input.nextInt();
		
		int sum = var1+var2+var3;
		System.out.println("sum="+sum);
		
		int avg = (var1+var2+var3)/3;
		System.out.println("avg="+avg);
				
				
	}
	

}
