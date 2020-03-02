package list_set_hasMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
//		sort();
//		output();
		groupbydate();
	}

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

	private static void output() {
		for (Bill bill : lisbill) {
			System.out.println(bill.toString());
		}
	}

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

	public static void distinct() {
		datecreate = new ArrayList<>();
		for (Bill bill : lisbill) {
			datecreate.add(bill.getDate());
		}
		System.out.println("danh sach ngay la");
		for (String str : datecreate) {
			System.out.println(str);
		}
	}

	public static List<Bill> seachlistbill() {
		List<Bill> lis = new ArrayList<>();
		for (Bill bill : lisbill) {
			if (bill.getMoney() > 1000000) {
				lis.add(bill);
			}
		}
		return lis;
	}
	
	@SuppressWarnings("deprecation")
	public static void groupbydate() {
		List<ArrayList<Bill>> arrliss = new ArrayList<ArrayList<Bill>>();
		for(int k = 0;k < lisbill.size();k++) {
			List<Bill> lis = new ArrayList<>();
			lis.add(lisbill.get(k));
			for(int i = k+1;i< lisbill.size();i++) {
				try {
					Date ngay1 = new SimpleDateFormat("yyyy-MM-dd").parse(lisbill.get(k).getDate());
					Date ngay2 = new SimpleDateFormat("yyyy-MM-dd").parse(lisbill.get(i).getDate());
//					System.out.println("n1"+ngay1+" n2  "+ngay2);
					if(lisbill.get(k).equals(lisbill.get(i))) {
						lis.add(lisbill.get(i));
						lisbill.remove(i);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			arrliss.add((ArrayList<Bill>) lis);
		}
		
		for (ArrayList<Bill> arr1 : arrliss) {
			System.out.println("group to : ");
			for (Bill bill : arr1) {
				System.out.println(bill.toString());
			}
		}
	}

}
