package Assignment3;

import java.util.Scanner;


public class Q1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		System.out.print("������ �Է��Ͻÿ�: ");
		int n = in.nextInt();
		
		if (n==0){
			System.out.print("zero");
			}
		
		else if (n>0) {
			System.out.print("plus");
		}
		
		else {
			System.out.print("minus");
		}
					
		
		
	}

}
