package Week5;
import java.util.Random;
import java.util.Scanner;

public class UP_Down {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int iValue= rand.nextInt(100)+1;
		Scanner in = new Scanner(System.in);
		System.out.println("1~100������ ���ڸ� ������� ���ڸ� ���纸�ÿ�. ");
		
		int i,n=0;
		do
		{
			System.out.println("���� �Է�>");
			 n= in.nextInt();
			if (iValue>n)
			{
				System.out.print("���� �� ���ڴ� �� ū �� �Դϴ�.");
				i++;
				continue;
			}
			else if (iValue<n)
			{
				System.out.print("���� �� ���ڴ� �� ���� �� �Դϴ�.");
				i++;
				continue;
			}
			
		}
			while (iValue!=n);
			System.out.printf("�����Դϴ�.%d������ ���߼̽��ϴ�.",i);
		}
	}
	

		
			
		
	
		
		
		
		
		
		
//		Random rand = new Random();
//		int iValue = rand.nextInt(100)+1;
//		System.out.println("����: "+ iValue );
//		
//		Scanner input=new Scanner(System.in);
//		System.out.println("1~100 ������ ���ڸ� ������� ���ڸ� ���纸�ÿ�.");
//		
//		
//		
//		//for(int i = 1; i<1000000; i++)
//		for(;;)
//			//while(true)// whi��e�� ���̸� ��� �ݺ��ϱ� ������ true�� ���� ���ѹݺ���
//				int i=1;
//		{
//			
//			System.out.println("�����Է�> ");
//		    int number = input.nextInt();
//		    
//			if (number>iValue) {
//				System.out.println("Ʋ�Ƚ��ϴ�, ���� �� ���ڴ� �� ���� �� �Դϴ�.");}
//			else if (number<iValue) {
//				System.out.println("Ʋ�Ƚ��ϴ�, ���� �� ���ڴ� �� ū �� �Դϴ�.");}
//			else {
//				System.out.println("�����Դϴ�!!");
//				System.out.println(i + "������ ���߼̽��ϴ�.");
//			break;}
//			
//			
//			
	

