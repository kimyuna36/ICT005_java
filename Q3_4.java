package Assignment3;

import java.util.Scanner;

public class Q3_4 {
	


	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int number, days;
		
		
		System.out.print("월을 숫자로 입력하시오(1-12):  ");
		number = input.nextInt();
		
		switch(number) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
			

		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
			
		default:
			days = 28;
			break;
			
				
			
		}
		System.out.print(days);
		
		

	}

}
