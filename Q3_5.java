package Assignment3;

import java.util.Scanner;

public class Q3_5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String gender;
		int age;
		
		System.out.print("�ڽ��� ������ �Է��Ͻÿ�(���ڴ� 'M', ���ڴ� 'F'): ");
		gender = input.nextLine();
		
		System.out.print("�ڽ��� ���̸� �Է��Ͻÿ�: ");
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
