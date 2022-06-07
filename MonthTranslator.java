package Week3;

import java.util.Scanner;

public class MonthTranslator {

	public static void main(String[] args) {
		
		String month;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월의 이름을 입력하시오: ");
		month = scan.next();
			
		int monthNumber;
		switch (month) {
		case "January":
			monthNumber = 1;
			break;
		case "February":
			monthNumber = 2;
			break;
		case "March":
			monthNumber = 3;
			break;
		case "April":
		    monthNumber = 4;
		    break;
		case "May":
		    monthNumber = 5;
		    break;
		case "June":
			monthNumber = 6;
			break;
		case "July":
			monthNumber = 7;
			break;
		case "August":
			monthNumber = 8;
		    break;
		case "September":
			monthNumber = 9;
			break;
		case "October":
			monthNumber = 10;
			break;
		case "November":
			monthNumber = 11;
			break;
		case "December":
			monthNumber = 12;
			break;
		default:
		    monthNumber = 0;
		    break;
		    
	}
		System.out.println(monthNumber);	
}		
}
			
		 
		