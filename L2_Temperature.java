package Practice;

import java.util.Scanner;

public class L2_Temperature {

	public static void main(String[] args) {
// ����ڷκ��� ȭ�� �µ��� �Է¹޾� ���� �µ��� ��ȯ�Ͽ� ����ϴ� ���α׷�
		
		double c;
		double f;
		
		
		Scanner  in = new Scanner(System.in);
		
		
		
		System.out.print("ȭ�� �µ��� �Է��Ͻÿ�: ");
		f =in.nextInt();
		
		c=5/9*(f-32);
		
		System.out.println("���� �µ���: " + c);
		
		

	}

}
