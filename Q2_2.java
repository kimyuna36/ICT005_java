package Assignment2;

import java.util.Scanner;

public class Q2_2 {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
		int x;
		int y;
		int z;
		
		System.out.print("ù��° ���ڸ� �Է��Ͻÿ�: ");
		x = input.nextInt();
		
		System.out.print("�ι�° ���ڸ� �Է��Ͻÿ�: ");
		y = input.nextInt();
		
		System.out.print("����° ���ڸ� �Է��Ͻÿ�: ");
		z = input.nextInt();
		
		
		
		System.out.println(((x>=y)&&(x>=z))+"");
		System.out.println(((x==y)&&(x==z)) +" ");
	}

}
