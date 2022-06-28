package Assignment3;

import java.util.Scanner;

public class Q3_2 {

	public static void main(String[] args) {
		String letter , grade;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("A-F 중 문자 하나를 입력하시오.: ");
		letter =input.nextLine();
		
		switch(letter) {
		
		case "A":
			grade = "Excellent";
			break;
		case "B":
			grade = "Good";
			break;
		case "C":
			grade = "Usually";
			break;
		case "D":
			grade = "Effort";
			break;
		case "F":
			grade = "Failure";
			break;
		default:
			grade = "Error";
			break;
			
		}
			System.out.print(grade);
		}
				
				
		
		
		

	}


