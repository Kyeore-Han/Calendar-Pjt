package Calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		CalenderAuto pcal = new CalenderAuto();
		int year = 0;
		int month = 0;
		
		while (true) {
			System.out.println("년도를 입력하시오.");
			System.out.print(PROMPT);
			year = scan.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달을 입력하시오.");
			System.out.print(PROMPT);
			month = scan.nextInt(); // 다음입력을 기다리기 때문에 print문이 무한히 빠르게 출력되지 않는다.
			if (month == -1) {
				break;
			}

			pcal.printCalenderMethod(year, month);

		}
		scan.close();
	}
	
	public static void main(String[] args) {
				
		Prompt p = new Prompt();
		p.runPrompt();
		System.out.println("종료됩니다.");
		
		
	}

}
