package Assignment2;

import java.util.Scanner;

public class Q2_3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x;
		int y;

		
		
		System.out.print("ù���� ���ڸ� �Է��ϼ���: ");
		x = in.nextInt();
		
		System.out.print("�ι�° ���ڸ� �Է��ϼ���: ");
		y = in.nextInt();
		
		
		
		int nextx = x++;
		int nexty = --y;
		int z = nextx*nexty;
		
		System.out.print(x+" " + y + " "+ z);
		
		
		
		
		

	}

}
