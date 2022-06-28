package Assignments6;
import java.util.Scanner;
import java.util.ArrayList;
public class Q6_3 {

	public static void main(String[] args) {
		double [] scores = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		Scanner in = new Scanner(System.in);
		
		System.out.print("평균을 알고 싶은 두 반의 번호를 입력하시오 (1-6)");
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		
		double sum= scores[n1-1]+scores[n2-1];
		
		
		sum=Math.round(sum*10);
		System.out.print("두 반의 평균의 합은: "+sum/10);

}
}
