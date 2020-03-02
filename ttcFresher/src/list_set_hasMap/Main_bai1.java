package list_set_hasMap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

public class Main_bai1 {

	private static List<Integer> arr;
	private static int n;
	private static Scanner sc;

	public static void main(String[] args) {
		control();
		input(n);
		int sopt = 0;
		System.out.println("nhập số pt cần tính");
		sopt = sc.nextInt();
		System.out.println("tổng cần tính là : " + tinhtong(sopt));
	}

	private static void control() {
		System.out.println("nhap so pt ");
		sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new ArrayList<>();
	}

	private static void input(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("nhap pt : ");
			int point = sc.nextInt();
			arr.add(point);
		}
		output();
		sort();
	}
	
	private static void output() {
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}

	private static int tinhtong(int sopt) {
		int tong = 0;
		try {
			for(int i = 0;i< sopt; i++) {
				tong = tong + arr.get(i);
			}
			
		} catch (Exception e) {
			System.out.println("số lượng pt không đủ");
		}
		return tong;
	}
	private static void sort() {
		Collections.sort(arr);
		System.out.println("mang sau khi sap xep ");
		output();
	}
}
