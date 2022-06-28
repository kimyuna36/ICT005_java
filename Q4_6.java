package Assignment4;


import java.util.Scanner;

public class Q4_6 {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		while(true){
			System.out.print("Base= ");
			double base = in.nextInt();
			System.out.println("Height= ");
			double height = in.nextInt();
			double width = (base * height)/2;
			width= Math.round(width*10);
			System.out.println("Triangle width= "+width/10); 
			System.out.println("Continue?");
			in.nextLine();
			String a= in.nextLine();
			if (!a.equals("Y")&&!a.equals("y"))
					{		
				break;
			}
			
																			
		}
			
	}

}