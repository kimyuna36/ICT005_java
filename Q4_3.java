package Assignment4;
import java.util.Scanner;
public class Q4_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("자연수 1개를 입력하시오:");
			int	n = in.nextInt();
			for(int i=1; i<=10; i++) {
				int multiples = n*i;
				System.out.print(" "+multiples);
			}
	

	}

}
