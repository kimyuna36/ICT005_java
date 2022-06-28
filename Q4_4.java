package Assignment4;

import java.util.Scanner;

public class Q4_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("100이하의 양의 정수를 입력하시오: ");
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
