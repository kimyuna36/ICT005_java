package Assignment4;

import java.util.Scanner;

public class Q4_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("100������ ������ �Է��Ͻÿ�: ");
		int n =in.nextInt();
		int sum=0;
		for(int i=n; i<=100; i++) {
			sum+=i;
		}
		System.out.printf("%d���� 100������ ����:%d", n, sum);
		
		

	}

}
