package Assignments6;
import java.util.Scanner;
public class Q6_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("6���� �����Ը� �Է��Ͻÿ�:  ");
				//				double w1= in.nextDouble();
				//				double w2= in.nextDouble();
				//				double w3= in.nextDouble();
				//				double w4= in.nextDouble();
				//				double w5= in.nextDouble();
				//				double w6= in.nextDouble();
				//				System.out.println(w1+w2+w3+w4+w5+w6/6.0);

				double[] weights = new double[6];
				//double sum=0;
				//����� �Է��� ó���ϴ� �ݺ���
				for (int i=0; i<weights.length;i++)

				{
					weights[i] = in.nextDouble();

					//sum+=weights[i]=in.nextDouble();

				}

				//�������� ���� ����ϴ� �ݺ���
				double sum=0;
				for(int i=0; i<weights.length; i++)
				{
					sum+= weights [i];
				}
				double avg = sum/weights.length;
				avg=Math.round(avg*10);
				System.out.println("�������� ���; "+(avg/10));
			

	}
}
