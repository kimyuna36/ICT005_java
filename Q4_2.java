package Assignment4;

import java.util.Scanner;

public class Q4_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("100이하의 정수를 입력하시오: ");
		int n =in.nextInt();
		int sum=0;
		for(int i=n; i<=100; i++) {
			sum+=i;
		}
		System.out.printf("%d부터 100까지의 합은:%d", n, sum);
		
		

	}

}
