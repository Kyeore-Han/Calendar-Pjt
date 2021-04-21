package Calendar;

public class CalenderAuto {
	private static final int[] Maxdays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_Maxdays = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 윤년일 경우 2월을 29일까지 출력

	public boolean isLeapYear(int year) {

		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getmaxDaysOfmonth(int year, int month) { // input도 있고 output도 있는 메소드 // 반드시 불러오고 싶으면 parameter를 입력해줘야 하는
														// 형식
		if (isLeapYear(year)) {
			return LEAP_Maxdays[(month)];
		} else {
			return Maxdays[(month)]; 
		}
	}
	public int getWeekDay(int year, int month, int day) {
		
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; //1970/1/1 = Thursday
		
		int count = 0;
		
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for (int j =1; j < month; j++) {
			int delta = getmaxDaysOfmonth(year, j);
			count += delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		
		return weekday;
	}
	

	public void printCalenderMethod(int year, int month) {
		System.out.printf("   << %4d 년%3d 월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		int maxDay = getmaxDaysOfmonth(year, month);
		int blankNum = getWeekDay(year, month, 1);
		
		for (int j = 0; j <= blankNum-1; j++) {
			if (blankNum == 0) {
				break;
			}
			System.out.print("   ");
		}
		
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if ((i + blankNum) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		}
		

}
