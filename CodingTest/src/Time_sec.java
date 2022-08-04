class Second{

	boolean check(int year) { //윤년 계산
		return (((year%4==0) && (year%100!=0)) || (year%400==0));
	}
	int year(int year){
		int day_year=0;
		for(int i=0; i<year; i++) { //연별 일수 계산
			if(check(i)) {day_year+=366;}
			else{day_year+=365;}
		}
		return day_year;
	}
	
	int mon(int year, int mon) {
		int day_mon=0;
		for(int i=1; i<mon; i++) { //월별 일수 계산
			switch(i) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					day_mon+=31;
					break;
				case 4: case 6: case 9: case 11: 
					day_mon+=30;
					break;
				case 2:
					if(check(year)) {
						day_mon+=29;
					}else {
						day_mon+=28;
					}
					break;
			}
		}
		return day_mon;
	}
	
	int change(int year,int mon,int day,int hour,int min,int sec) { //초로 변환시키기
		int sec_sum;
		
		sec_sum=sec + (min*60) + (hour*60*60) + (day*24*60*60) + (mon(year, mon)*24*60*60) + (year(year)*24*60*60); //초 합산
		return sec_sum;
	}
}

public class Time_sec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Second sc1 = new Second();
		Second sc2 = new Second();

		int sec1 = sc1.change(2020,2,2,2,2,2); //기준일
		int sec2 = sc2.change(2021,2,2,2,2,2); //비교일
				
		if(sec1<=sec2) { //기준보다 같거나 크면 차이 출력
			System.out.println("기준일보다 "+(sec2-sec1)+" 초 지났습니다.");
		}else {System.out.println("기준일 보다 과거입니다.");} //기준보다 작을때

	}

}
