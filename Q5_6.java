package Assignment5;
import java.util.Scanner;
public class Q5_6 {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		System.out.print("1부터 100까지의 정수 중 한개를 입력하시오: " );
		
		int a= in.nextInt();
		for(int i=1;a*i<=100; i++ ) {
			System.out.print(a*i+" ");
			if ((a*i)%10==0) {
				break;
			}
		}
		
		
		
		
		
		
//		System.out.print("1부터 100까지의 정수 중 한개를 입력하시오: ");
//		int a= in.nextInt();
//		for(int i=1;a*i<=100;i++) {
//			System.out.print(a*i+" ");
//			if ((a*i)%10==0) {
//				break;
//			}
//		}
		

	}

}
