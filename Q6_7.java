package Assignments6;
import java.util.Scanner;
public class Q6_7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int[] number = new int[10];
        System.out.print("100�̸��� ���� ������ �Է��Ͻÿ�");
        while (true) {
            int inputNumber = in.nextInt();
            
            if (inputNumber == 0) {
                break;
            }
            int a = inputNumber/10;
            number[a]++;
        }

        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                System.out.println(i + " : " + number[i]);
            }
        }
        
    }
}
	
//		Scanner in = new Scanner(System.in);
//		
//		System.out.print("100�̸��� ���� ������ �Է��Ͻÿ�: ");
//		
//		int [] numbers = new int[100];
//		
//		while(true) {
//			int inputNumbers = in.nextInt();
//			
//			if (numbers[i]==0) {
//			break;
//			}
//		}
//		int a = inputNumbers/10;
//		numbers[a]++;
//	}
//		for(int i=0;i<number.length; i++ ) {
//			if (number[i]!=0) {
//				System.out.println(i+" : " + number[i] );
//			}
//		
//		
//
//	}
//
//}
