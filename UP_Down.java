package Week5;
import java.util.Random;
import java.util.Scanner;

public class UP_Down {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int iValue= rand.nextInt(100)+1;
		Scanner in = new Scanner(System.in);
		System.out.println("1~100사이의 숫자를 골랐으니 숫자를 맞춰보시오. ");
		
		int i,n=0;
		do
		{
			System.out.println("숫자 입력>");
			 n= in.nextInt();
			if (iValue>n)
			{
				System.out.print("제가 고른 숫자는 더 큰 수 입니다.");
				i++;
				continue;
			}
			else if (iValue<n)
			{
				System.out.print("제가 고른 숫자는 더 작은 수 입니다.");
				i++;
				continue;
			}
			
		}
			while (iValue!=n);
			System.out.printf("정답입니다.%d번만에 맞추셨습니다.",i);
		}
	}
	

		
			
		
	
		
		
		
		
		
		
//		Random rand = new Random();
//		int iValue = rand.nextInt(100)+1;
//		System.out.println("정답: "+ iValue );
//		
//		Scanner input=new Scanner(System.in);
//		System.out.println("1~100 사이의 숫자를 골랐으니 숫자를 맞춰보시오.");
//		
//		
//		
//		//for(int i = 1; i<1000000; i++)
//		for(;;)
//			//while(true)// whiㅣe은 참이면 계속 반복하기 때문에 true를 쓰면 무한반복임
//				int i=1;
//		{
//			
//			System.out.println("숫자입력> ");
//		    int number = input.nextInt();
//		    
//			if (number>iValue) {
//				System.out.println("틀렸습니다, 제가 고른 숫자는 더 작은 수 입니다.");}
//			else if (number<iValue) {
//				System.out.println("틀렸습니다, 제가 고른 숫자는 더 큰 수 입니다.");}
//			else {
//				System.out.println("정답입니다!!");
//				System.out.println(i + "번만에 맞추셨습니다.");
//			break;}
//			
//			
//			
	

