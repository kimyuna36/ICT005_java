package Assignment2;

import java.util.Scanner;

public class Q2_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x; //ù��° ���� ����
		int y; //�ι�° ���� ����
		
		System.out.print("ù��° ���ڸ� �Է��Ͻÿ�: ");
		x= input.nextInt();
		
		System.out.print("�ι�° ���ڸ� �Է��Ͻÿ�: ");
		y= input.nextInt();
		
		System.out.println(x + ">" + y +"---"+ (x>y)+ "");
		System.out.println(x + "<" + y +"---"+(x<y) +"");
		System.out.println(x + ">=" + y +"---"+(x>=y)+"");
		System.out.println(x + "<=" + y +"---"+(x<=y)+"");
		
		
				

	}

}


