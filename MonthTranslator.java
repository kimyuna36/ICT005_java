package Week3;

import java.util.Scanner;

public class MonthTranslator {

	public static void main(String[] args) {
		
		int number;
		int marks;
		char grade; 
		String month	;
		Scanner input = new Scanner(System.in);
		
		System.out.print("성적을 입력하시오:");
	    marks = input.nextInt();
		number = marks/10;
		
		switch (number)
		{
		case 10:	
		case 9:
			grade = 'A';
			break;
			
		case 8:
			grade = 'B';
			break;
			
		case 7:
			grade = 'C';
			break;
			
		case 6:
			grade = 'D';
			break;
			
		default:
			grade = 'F';
			break;
		}
		System.out.print("학점: "+ grade);

		
	}

}
