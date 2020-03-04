package baiTapString;

import java.util.ArrayList;
import java.util.List;

public class Bai1 {

	static ArrayList<Integer> liskytu;
	static ArrayList<Integer> lischuoicon;

	public static void main(String[] args) {
		String chuoi = "abcdefabca";
		String kytu = "a";
		String chuoicon = "abc";
		liskytu = new ArrayList<>();
		lischuoicon = new ArrayList<>();
		String chuoi4 = "e,r,t,de,y,u,f,u";
//		decodetring(chuoi4);
//		System.out.println(count(chuoi, chuoicon));
//		getliskytu(chuoi, kytu);
//		getlistcon(chuoi, chuoicon);
//		 timmaxcount(chuoi);
		//lischuoicon(chuoi);
		System.out.println(result("i am fresher is fresher","fresher","pro"));
	}
// bai1 lấy danh sách xuất hiện của 1 ký tự
	private static void getliskytu(String chuoi, String kytu) {
		for (int i = 0; i < chuoi.length(); i++) {
			if (kytu.equals(String.valueOf(chuoi.charAt(i)))) {
				liskytu.add(i);
			}
		}

		for (Integer j : liskytu) {
			System.out.println("vi tri la: " + j);
		}
	}
// bai1 lấy danh sách xuất hiện của 1 chuỗi con
	private static void getlistcon(String chuoi, String chuoicon) {
		int tall = chuoicon.length();
		int trunggian = 0;
		int n = -1;
		while (chuoi.length() > chuoicon.length()) {
			n = chuoi.indexOf(chuoicon);
			if(n > -1) {
			lischuoicon.add(n + trunggian);
			trunggian = n + tall;
			chuoi = chuoi.substring(n + tall);
			n = -1;
			}else {
				break;
			}
		}
		
		for (Integer integer : lischuoicon) {
			System.out.println(integer);
		}
	}
// đếm số lần xuất hiện của chuỗi con
	private static int count(String chuoi, String chuoicon) {
		int tall = chuoicon.length();
		int dem = 0;
		int n = -1; 
		while (chuoi.length() > chuoicon.length()) {
			n = chuoi.indexOf(chuoicon);
			if(n >= 0) {
			dem++;
			chuoi = chuoi.substring(n + tall);
			n = -1;
			}else {
				break;
			}
		}
		return dem;
	}
// bài 2 tìm chuỗi con xuất hiện nhiều nhất
	private static void timmaxcount(String chuoi) {
		int max = 0;
		String chuoimax = "";
		for (int i = 0; i < chuoi.length() - 1; i++) {
			for (int j = i + 1; j < chuoi.length(); j++) {
				String chuoicon = chuoi.substring(i, j);
				if (count(chuoi, chuoicon) > max) {
					max = count(chuoi, chuoicon);
					chuoimax = chuoicon;
				}
			}
		}
		System.out.println("chuoi max là " + chuoimax + " với sô lần " + max);
	}
// trả về danh sách chuỗi con
	private static void lischuoicon(String chuoi) {
		ArrayList<String> ar = new ArrayList<>();
		for (int i = 0; i < chuoi.length() - 1; i++) {
			for (int j = i + 1; j < chuoi.length(); j++) {
				ar.add(chuoi.substring(i, j));
			}
		}
		for (String string : ar) {
			System.out.println(string);
		}
	}
	
	//bài 3 chuyển list -> string
	
	public static String encodetring(List<String> lis){
		String str = "";
		for (String string : lis) {
			str += lis + ",";
		}
		return str;
	}
	// bài 4 chuyển string -> list
	
	public static void decodetring(String str){
		List<String> lis = new ArrayList<>();
		String[] words = str.split(",");
		for (String string : words) {
			System.out.println(string);
		}
	}
	// bài 5
	public static String result(String raw,String from, String to) {
		String result = raw.replace(from, to);
		return result;
	}
}
