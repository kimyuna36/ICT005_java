package Assignments6;
import java.util.Scanner;
import java.util.ArrayList;
public class Q6_3 {

	public static void main(String[] args) {
		double [] scores = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		Scanner in = new Scanner(System.in);
		
		System.out.print("����� �˰� ���� �� ���� ��ȣ�� �Է��Ͻÿ� (1-6)");
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		
		double sum= scores[n1-1]+scores[n2-1];
		
		
		sum=Math.round(sum*10);
		System.out.print("�� ���� ����� ����: "+sum/10);

}
}
