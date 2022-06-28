package Assignments6;
import java.util.Scanner;
import java.util.ArrayList;
public class Q6_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("정수를 100개 입력하시오: ");
		int [] n =new int[100];
		for(int i=0;i<n.length; i++) {
			
		n[i]=in.nextInt();
		if(n[i]==0) 
			break;
		
		}
		for(int i=n.length-1; i>=0; i--) {
			if (n[i]!=0)
				System.out.print(n[i]+" ");
		}
		

	}

}
