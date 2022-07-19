package Mid;
import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
//		15명의 학생의 성적을 입력받아 세로 히스토그램을 그려주는 프로그램을 작성하시오
	Scanner in = new Scanner (System.in);
	System.out.print("15명의 학생의 성적 입력: ");
	int [] scores = new int [15];
	String[]grades=new String[10];
	
    int [] grade_Cnt = new int [10]; // 각 등급별 카운트 변수
	
	
	for(int i=0;i<15;i++)
	{
		scores[i]=in.nextInt();	
	}
	
	for(int i=0;i<10;i++)
	{
		grades[i]=(i*10)+"~"+((i+1)*10)+":";
		
		grade_Cnt[i]=0;  //초기값 0 설정
	}
	
	
	for(int i=0; i<10;i++)
	{ 
		for(int j=0; j<15;j++)
		{
			if((i*10)<=scores[j]&&scores[j]<(i+1)*10)
			{
				grades[i]+="*";
				grade_Cnt[i]++; //해당 구간의 성적이 있는 경우 카운트
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