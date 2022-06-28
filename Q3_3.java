package Assignment3;

import java.util.Scanner;

public class Q3_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number;
		String animal;
		
		
		System.out.print("Number?  ");
		number=input.nextInt();
		
		switch(number) {
		case 1:
			animal = "dog";
			break;
		case 2:
			animal = "cat";
			break;
		case 3:
			animal = "chick";
			break;
		default:
			animal = "I don't know.";
			break;
			
		}
		System.out.println(animal);
		

	}

}
