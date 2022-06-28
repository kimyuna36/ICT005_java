package Assignment1;

import java.util.Scanner;

public class Q1_5 {

	public static void main(String[] args) {
		
		double yard;
		double centimetre;
		//1yd = 91.44cm
		
		
		Scanner input = new Scanner(System.in);
		
	    System.out.print("Yard?" + " ");
		yard = input.nextDouble();
		
		centimetre= yard * 9144/100;
		centimetre=Math.round(centimetre*10);
		System.out.println(yard + "yard" + "=" + centimetre/10 + "cm");
			
		
		
	}

}
