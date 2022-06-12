package Assignment3;

import java.util.Scanner;

public class Q3_5_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String gender;
		int age;
		
		System.out.print("자신의 성별을 입력하시오(남자는 'M', 여자는'F'):  ");
		gender = in.nextLine();
		System.out.print("자신의 나이를 입력하시오:  ");
		age= in.nextInt();
		
		if(gender=="F"&& age>=18) {
			System.out.print("WOMAN");
		}
		else if (gender=="F"&& age<18) {
			System.out.print("GIRL");
		}
		else if (gender=="M"&& age>=18) {
			System.out.print("MAN");
		}
		else if (gender=="M"&& age<18)  {
			System.out.print("BOY");
		}
	}

}
