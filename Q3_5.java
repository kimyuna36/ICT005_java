package Assignment3;

import java.util.Scanner;

public class Q3_5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String gender;
		int age;
		
		System.out.print("자신의 성별을 입력하시오(남자는 'M', 여자는 'F'): ");
		gender = input.nextLine();
		
		System.out.print("자신의 나이를 입력하시오: ");
		age = input.nextInt();
		
			if(gender=="F") {
				if(age>=18) 
				System.out.print("WOMAN");
				else 
				System.out.print("GIRL");
			}
			else if(gender=="M") {
				if(age>=18) 
				System.out.print("MAN");
				else 
				System.out.print("BOY");
			}	

	}

}
