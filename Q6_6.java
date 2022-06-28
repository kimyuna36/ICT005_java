package Assignments6;

import java.util.Scanner;

public class Q6_6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("10개의 숫자를 입력하시오: ");
		
		int [] numbers = new int[10];
		for(int i=0; i<numbers.length; i++) {
			numbers[i]= in.nextInt();
			
			
		}
		int min= numbers[0];
		for(int i=1; i<numbers.length; i++) {
			if (min>numbers[i])
				min=numbers[i];
		
		 

	}
	System.out.println(min);

}
}
