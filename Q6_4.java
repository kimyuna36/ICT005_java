package Assignments6;

import java.util.ArrayList;

import java.util.Scanner;
public class Q6_4 {

	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
			int [] numbers=new int[10];
			double oddsum=0;
			int evensum=0;
			System.out.print("10개의 숫자를 입력하시오: ");
			
			for(int i=0;i<10;i++) {
			int inP =in.nextInt();
			numbers[i]= inP;
			}
			for(int i=1; i<10;i+=2) {
				evensum+= numbers[i];
				
			}
			
			for(int i=0; i<10; i+=2) {
				oddsum+=(double)numbers[i];
			}
				double oddavg=oddsum/5;
			    oddavg=Math.round(oddavg*10);
			    
				System.out.println("sum: "+ evensum);
				System.out.print("avg: "+oddavg/10);
	}
			
}

		

