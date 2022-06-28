package Assignment4;

import java.util.Scanner;

public class Q4_1 {

	public static void main(String[] args) {
		
		
		
		System.out.print("100이하의 양의 정수를 입력하시오: ");
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int i=1;
		int sum=0;
		while (i<=n){
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		
		
		}
		
		
		
	

	}


