package Assignment5;
import java.util.Scanner;
public class Q5_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
			for (int row=1; row<=n; row++) {
			for(int col=1; col<=row; col++) {
				System.out.print("*");
		}
		
		System.out.println();

	}

}
}
