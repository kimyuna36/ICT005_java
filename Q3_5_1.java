package Assignment3;

import java.util.Scanner;

public class Q3_5_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String gender;
		int age;
		
		System.out.print("�ڽ��� ������ �Է��Ͻÿ�(���ڴ� 'M', ���ڴ�'F'):  ");
		gender = in.nextLine();
		System.out.print("�ڽ��� ���̸� �Է��Ͻÿ�:  ");
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
