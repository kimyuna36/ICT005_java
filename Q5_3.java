package Assignment5;
import java.util.Scanner;
public class Q5_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("��� ���� ���� �Է��Ͻÿ�: ");
		int a=in.nextInt();
		int b=in.nextInt();
		for(int i=1;i<=a; i++) {
			for(int j=1;j<=b; j++) {
				System.out.print(i*j+" ");
			}
			System.out.println(" ");
		}
	}

}
