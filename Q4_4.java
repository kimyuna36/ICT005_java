package Assignment4;

import java.util.Scanner;

public class Q4_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("100������ ���� ������ �Է��Ͻÿ�: ");
		int n = in.nextInt();
		int sum=0;
		int i=1;
		while (i<=n) {
			sum+=i;
			i++;
			
		}
		System.out.println(sum);
	

	}

}
