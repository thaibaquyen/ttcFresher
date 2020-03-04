package baiTapDate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainDate {

	public static void main(String[] args) {
		String datestring = "2020-03-04 22:22:22";
//		bai1(datestring);
		bai2(datestring);
//		sosanhdate("1111-09-05","1111-03-06");
//		khoangcach("1111-03-05","1111-04-06");
//		bai5("2020/03/03 22:22:22");
//		bai7("2020/03/03 22:22:22");
	}

	// bài 1
	public static void bai1(String str) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// bài 2
	public static void bai2(String str) {
		try {
			ArrayList<Integer> lisfirstdayofweek = new ArrayList<>();
			SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			String ngay = new SimpleDateFormat("E").format(date);
			int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
			System.out.println(ngay);
			String ngaydauthang = "1";

			Calendar cal = new GregorianCalendar();
//			int day = cal.get(Calendar.DAY_OF_MONTH);
			int month = (cal.get(Calendar.MONTH))+1;
			cal.setTime(date);
			String ngaycuoithang = "";
			if (cal.get(Calendar.YEAR) % 4 == 0) {
				if (month == 2) {
					ngaycuoithang = "29";
				} else {
					if (month % 2 == 0) {
						ngaycuoithang = "30";
					} else {
						ngaycuoithang = "31";
					}
				}
			} else {
				if (month == 2) {
					ngaycuoithang = "28";
				} else {
					if (month % 2 == 0) {
						ngaycuoithang = "30";
					} else {
						ngaycuoithang = "31";
					}
				}
			}
//			System.out.println("hhh " + day);
			cal.add(Calendar.DATE, +100);
			String apter100 = sp.format(cal.getTime());
			int tg = 0;
			switch (ngay) {
			case "Mon":
				tg = day - day*(day/7);
				for(int i = 0; i < 4;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Tue":
				tg = (day - 1) - (day-1)*(day/7);
				for(int i = 0; i < 4;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Wed":
				tg = (day - 2) - (day-2)*(day/7);
				for(int i = 0; i < 4;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Thu":
				tg = (day - 3) - (day-3)*(day/7);
				for(int i = 0; i < 4;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Fri":
				tg = (day - 4) - (day-4)*(day/7);
				for(int i = 1; i < 5;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Sat":
				tg = (day - 5) - (day-5)*(day/7);
				for(int i = 1; i < 5;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			case "Sun":
				tg = (day - 6) - (day-6)*(day/7);
				for(int i = 1; i < 5;i++) {
					lisfirstdayofweek.add(tg + 7*i);
				}
				break;
			default:
				break;
			}
			String result = "ngày đầu tháng là :"+ ngaydauthang + "\n ngày cuối tháng là : " + ngaycuoithang + "\n các ngày đầu tuần là :"+lisfirstdayofweek.toString()+"\n ngày sau 100 ngày là :  "+apter100;
			System.out.println(result);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

	// bài 3
	public static void sosanhdate(String date1, String date2) {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date_1 = sp.parse(date1);
			Date date_2 = sp.parse(date2);
			if (date_1.compareTo(date_2) > 0) {
				System.out.println("string1 > string2");
			} else {
				if (date_1.compareTo(date_2) == 0) {
					System.out.println("string1 = string2");
				} else {
					System.out.println("string1 < string2");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	// bài 4
	private static void khoangcach(String date1, String date2) {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date_1 = sp.parse(date1);
			Date date_2 = sp.parse(date2);
			float ngay = Math.abs(date_1.getTime() - date_2.getTime()) / (60 * 60 * 24 * 1000);
			System.out.println("so ngay la: " + ngay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// bài 5
	private static void bai5(String stringdate) {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date = sp.parse(stringdate);
			Timestamp Timestamp = new Timestamp(date.getTime());
			System.out.println("Timestap :  " + Timestamp);
			Date date2 = new Date(Timestamp.getTime());
			System.out.println("day :  " + date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// bài 7
	private static void bai7(String stringdate) {
		SimpleDateFormat sp1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sp3 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");

		try {
			Date date1 = sp1.parse(stringdate);
			String date2 = sp2.format(date1);
			String date3 = sp3.format(date1);
			System.out.println(date1 + "\n kiểu2: " + date2 + "\n  kiểu3 : " + date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
