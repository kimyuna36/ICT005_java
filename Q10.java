package Mid;
import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
//		15명의 학생의 성적을 입력받아 세로 히스토그램을 그려주는 프로그램을 작성하시오
	Scanner in = new Scanner (System.in);
	System.out.print("15명의 학생의 성적 입력: ");
	int [] scores = new int [15];
	String[]grades=new String[10];
	for(int i=0;i<15;i++) {
		scores[i]=in.nextInt();
	}
	//15개의 숫자를 입력받는다.
	for(int i=0; i<10;i++) {
		grades[i]=(i*10)+"~"+((i+1)*10)+":";
	}
	
	for(int i=0; i<10;i++) 
		for(int j=0; j<15;j++) 
			if((i*10)<=scores[j]&&scores[j]<=(i+1)*10) 
			grades[i]+="*";	
			
		
	
		
	for(int i=0;i<10;i++) {
		System.out.println(grades[i]);
	}
}
}
//	while(true) {
//		int inputScores=in.nextInt();
//		
//		int a= inputScores/10;
//		scores[a]++;
//	}
//	for(int s=0;s<10;s++) {
//		
//			System.out.printf("%d~%d: %d \n",s*10,(s+1)*10,scores[s]);
//		}
//	}
//	}
//
//
//
//
//		
//	for(int i=0;i<10;i++) {
//		System.out.printf("%d~%d: \n" ,i*10,(i+1)*10);
//	for (int i=0; i<15; i++) {
//		scores[i]= in.nextInt();
//		switch(scores[i]/10) {
//		case 0:
//			stars[0]++;
//			break;
//		case 1:
//			stars[1]++;
//			break;
//		case 2:
//			stars[2]++;
//			break;
//		case 3:
//			stars[3]++;
//			break;
//		case 4:
//			stars[4]++;
//			break;
//		case 5:
//			stars[5]++;
//			break;
//		case 6:
//			stars[6]++;
//			break;
//		case 7:
//			stars[7]++;
//			break;
//		case 8:
//			stars[8]++;
//			break;
//		case 9:
//			stars[9]++;
//			break;
//		
//		}
//		for (int a=0; a<10; a++) {
//			
//			if(stars[a]!=0) {
//				int b = stars[a];
//				System.out.print(i*10 + "~" + (i+1)*10 + ":");
//				for(int k=0; k<10; k++) {
//				
//					System.out.print("*");
//				}
//				System.out.println();			}
//		}
//		
//	}
//	}


