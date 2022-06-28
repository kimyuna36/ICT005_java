package Assignments6;
import java.util.Scanner;
public class Q6_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("6명의 몸무게를 입력하시오:  ");
				//				double w1= in.nextDouble();
				//				double w2= in.nextDouble();
				//				double w3= in.nextDouble();
				//				double w4= in.nextDouble();
				//				double w5= in.nextDouble();
				//				double w6= in.nextDouble();
				//				System.out.println(w1+w2+w3+w4+w5+w6/6.0);

				double[] weights = new double[6];
				//double sum=0;
				//사용자 입력을 처리하는 반복문
				for (int i=0; i<weights.length;i++)

				{
					weights[i] = in.nextDouble();

					//sum+=weights[i]=in.nextDouble();

				}

				//몸무게의 합을 계산하는 반복문
				double sum=0;
				for(int i=0; i<weights.length; i++)
				{
					sum+= weights [i];
				}
				double avg = sum/weights.length;
				avg=Math.round(avg*10);
				System.out.println("몸무게의 평균; "+(avg/10));
			

	}
}
