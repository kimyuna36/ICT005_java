package Practice;

import java.util.Scanner;

public class L2_Rectangle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double w;
		double h;
		double area;
		double perimeter;
		
		
		System.out.print("�簢���� ���θ� �Է��ϼ���: ");
		w= input.nextInt();
		
		System.out.print("�簢���� ���θ� �Է��ϼ���: ");
		h= input.nextInt();
		
		area = w*h;
		System.out.println("�簢���� ���̴�: " + area);
		
		perimeter =  (w+h)*2.0;
		System.out.println("�簢���� �ѷ���: " + perimeter);
		
		
		
		

	}

}
