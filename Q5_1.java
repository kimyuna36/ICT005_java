package Assignment5;
import java.util.Scanner;
public class Q5_1 {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		
		System.out.print("�ڿ����� �Է��Ͻÿ�:   ");
		int number=in.nextInt();
		int count =0;
		int sum=0;
		
		
		for (int i=1;sum<number;i++) {
			if (i%2==1) {
				sum+=i;
				count++;
			}
			
		}
		System.out.printf("%d %d",count,sum);

	}

}
