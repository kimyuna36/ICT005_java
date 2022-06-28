package Assignments6;

import java.util.Scanner;

public class Q6_9 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] scores = new int[4][3];
        int sum = 0;

        for(int i = 0; i < 4; i++) {
            System.out.print(i + 1 + "class? ");

           for(int c = 0; c < 3; c++) {
               scores[i][c] = in.nextInt();
           }
        }
        for(int i = 0; i < 4; i++) {
            for(int c = 0; c < 3; c++) {
                sum += scores[i][c];
            }
            System.out.println(i + 1 + "class : " + sum);
            sum = 0;
        }
		}


}
