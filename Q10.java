package Mid;
import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
//		15���� �л��� ������ �Է¹޾� ���� ������׷��� �׷��ִ� ���α׷��� �ۼ��Ͻÿ�
	Scanner in = new Scanner (System.in);
	System.out.print("15���� �л��� ���� �Է�: ");
	int [] scores = new int [15];
	String[]grades=new String[10];
	
    int [] grade_Cnt = new int [10]; // �� ��޺� ī��Ʈ ����
	
	
	for(int i=0;i<15;i++)
	{
		scores[i]=in.nextInt();	
	}
	
	for(int i=0;i<10;i++)
	{
		grades[i]=(i*10)+"~"+((i+1)*10)+":";
		
		grade_Cnt[i]=0;  //�ʱⰪ 0 ����
	}
	
	
	for(int i=0; i<10;i++)
	{ 
		for(int j=0; j<15;j++)
		{
			if((i*10)<=scores[j]&&scores[j]<(i+1)*10)
			{
				grades[i]+="*";
				grade_Cnt[i]++; //�ش� ������ ������ �ִ� ��� ī��Ʈ
			}
		}
	}
	
	for(int i=0;i<10;i++)
	{
		if(grade_Cnt[i]>0)
		{
			//if(scores[i]!=0){
			System.out.println(grades[i]);
		}
	}

//34 2 27 37 24 40 28 60 68 81 70 41 91 89 21
	}
}