package list_set_hasMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.xml.crypto.Data;

import been.Bill;

public class Main_Bai3 {

	private static List<Bill> lisbill;
	private static int n;
	private static Scanner sc;
	private static ArrayList<String> datecreate;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("nhập pt list ");
		n = sc.nextInt();
		input(n);
		output();
		
//		sort();                         // bài 3
//		output();
//		bai6();
//		groupbydate();				// bài 7
		bai8();
	}
// nhập vào
	private static void input(int n) {
		lisbill = new ArrayList<Bill>();
		for (int i = 0; i < n; i++) {
			Bill bill = new Bill();
			System.out.println("nhập id ");
			bill.setId(sc.nextInt());
			sc.nextLine();
			System.out.println("nhập name ");
			bill.setName(sc.nextLine());
			System.out.println("nhập money ");
			bill.setMoney(sc.nextLong());
			System.out.println("nhập date ");
			sc.nextLine();
			bill.setDate(sc.nextLine());
			bill.toString();
			lisbill.add(bill);
		}
	}
// in ra
	private static void output() {
		for (Bill bill : lisbill) {
			System.out.println(bill.toString());
		}
	}
// bài 3 : sắp xếp
	private static void sort() {
		Collections.sort(lisbill, new Comparator<Bill>() {

			@Override
			public int compare(Bill o1, Bill o2) {
				if (o1.getMoney() > o2.getMoney()) {
					return 1;
				} else {
					if (o1.getMoney() < o2.getMoney()) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
	}
// bài 4
	public static void lisngay() {
		datecreate = new ArrayList<>();
		for (Bill bill : lisbill) {
			datecreate.add(bill.getDate());
		}
		System.out.println("danh sach ngay la");
		datecreate.stream().distinct();
		for (String str : datecreate) {
			System.out.println(str);
		}
	}
// bài 5
	public static List<Bill> seachlistbill() {
		List<Bill> lis = new ArrayList<>();
		for (Bill bill : lisbill) {
			if (bill.getMoney() > 1000000) {
				lis.add(bill);
			}
		}
		return lis;
	}
	
	// bài 7
	public static void groupbydate() {
		List<ArrayList<Bill>> arrliss = new ArrayList<ArrayList<Bill>>();
		while(lisbill.size() > 0) {
			List<Bill> lisbillngay = new ArrayList<>();
			lisbillngay.add(lisbill.get(0));
			for(int i = 1;i< lisbill.size();i++) {
				if(lisbill.get(0).getDate().equals(lisbill.get(i).getDate())) {
					lisbillngay.add(lisbill.get(i));
					lisbill.remove(i);
				}
			}
			lisbill.remove(0);
			arrliss.add((ArrayList<Bill>) lisbillngay);
		}
		// in ra màn hình
		for (ArrayList<Bill> arrayList : arrliss) {
			System.out.println("nhóm : ");
			for (Bill bill : arrayList) {
				System.out.println(bill.toString());
			}
		}
		
//		for(int k = 0;k < lisbill.size();k++) {
//			List<Bill> lis = new ArrayList<>();
//			lis.add(lisbill.get(k));
//			for(int i = k+1;i< lisbill.size();i++) {
//				try {
//					Date ngay1 = new SimpleDateFormat("yyyy-MM-dd").parse(lisbill.get(k).getDate());
//					Date ngay2 = new SimpleDateFormat("yyyy-MM-dd").parse(lisbill.get(i).getDate());
////					System.out.println("n1"+ngay1+" n2  "+ngay2);
//					if(lisbill.get(k).getDate().equals(lisbill.get(i).getDate())) {
//						lis.add(lisbill.get(i));
//					}
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//			}
//			lis.stream().distinct();
//			arrliss.add((ArrayList<Bill>) lis);
//		}
//		
//		for (ArrayList<Bill> arr1 : arrliss) {
//			System.out.println("group to : ");
//			for (Bill bill : arr1) {
//				System.out.println(bill.toString());
//			}
//		}
	}
	
// bài 6
	public static void bai6() {
		HashMap<String, List<Bill>> hsmap = new HashMap<>();
		while(lisbill.size() > 0) {
			List<Bill> lisbillngay = new ArrayList<>();
			lisbillngay.add(lisbill.get(0));
			for(int i = 1;i< lisbill.size();i++) {
				if(lisbill.get(0).getDate().equals(lisbill.get(i).getDate())) {
					lisbillngay.add(lisbill.get(i));
					lisbill.remove(i);
				}
			}
			lisbill.remove(0);
			hsmap.put(lisbillngay.get(0).getDate(), lisbillngay);
		}
		
		Set<Map.Entry<String, List<Bill>>> setHashMap = hsmap.entrySet();
        
	    System.out.println("Các entry có trong setHashMap:");
	    System.out.println(setHashMap);
	}
	 // bài 8
	public static void bai8() {
		Set<Bill> setbill = new HashSet<>();
		while(lisbill.size() > 0) {
			int dem = 0;
			for(int i = 1;i< lisbill.size();i++) {
				if(lisbill.get(0).getName().equals(lisbill.get(i).getName()) && (lisbill.get(0).getId() == lisbill.get(i).getId())) {
					setbill.add(lisbill.get(i));
					lisbill.remove(i);
					dem++;
				}
			}
			if(dem > 0) {
				setbill.add(lisbill.get(0));
				lisbill.remove(0);
			}else {
				lisbill.remove(0);
			}	
		}
		
		//in ra ds
		for (Bill bill : setbill) {
			System.out.println("bill cung id và name là :");
			System.out.println(bill.toString());
		}
	}
}
