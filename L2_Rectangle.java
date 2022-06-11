package Practice;

import java.util.Scanner;

public class L2_Rectangle {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double w;
		double h;
		double area;
		double perimeter;
		
		
		System.out.print("사각형의 가로를 입력하세요: ");
		w= input.nextInt();
		
		System.out.print("사각형의 세로를 입력하세요: ");
		h= input.nextInt();
		
		area = w*h;
		System.out.println("사각형의 넓이는: " + area);
		
		perimeter =  (w+h)*2.0;
		System.out.println("사각형의 둘레는: " + perimeter);
		
		
		
		

	}

}
