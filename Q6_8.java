package Assignments6;
import java.util.Scanner;
public class Q6_8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int [][]array1= new int[2][4];
		int [][]array2= new int[2][4];
		int [][]array3= new int[2][4];
		
		System.out.println("first array");
		for (int i=0; i<2; i++) {
			for(int c=0; c<4; c++) {
				array1[i][c]=in.nextInt();
			}
		}
		System.out.println("second array");
		for(int i=0; i<2; i++) {
			for(int c=0;c<4;c++)
				array2[i][c]=in.nextInt();
			}
		for(int i=0; i<2; i++) {
			for(int c=0;c<4;c++) {
				array3[i][c]=array1[i][c]*array2[i][c];
				System.out.print(array3[i][c]+" ");
		}
		System.out.println();
		
	}

}
}