package Assignment4;
import java.util.Scanner;
public class Q4_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("정수를 계속 입력하시오:");
		int count=0;
		while(true) {
			int number = in.nextInt();
			
			if (number%3!=0 && number%5!=0) {
				count++;
			}
			else if(number==0) {
				break;
			}
		}
		System.out.print(count);
	

	}

}
