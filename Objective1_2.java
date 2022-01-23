package example;

import java.util.*;

import org.w3c.dom.Text;

import java.io.*;
import java.math.*;

class Objective1_2 {
	
	static String returnValue(int key) throws Exception {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Quarter");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Ninteeen");
		map.put(20, "Twenty");
		map.put(21, "Twenty One");
		map.put(22, "Twenty Two");
		map.put(23, "Twenty Three");
		map.put(24, "Twenty Four");
		map.put(25, "Twenty Five");
		map.put(26, "Twenty Six");
		map.put(27, "Twenty Seven");
		map.put(28, "Twenty Eight");
		map.put(29, "Twenty Nine");
		map.put(30, "Half");
		return map.get(key);
	}

	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String arr[] = sc.next().split(":");
		try {
			int e1 = Integer.parseInt(arr[0]);
			int e2 = Integer.parseInt(arr[1]);
			if(e1 == 0) {
				e1 = 12;
			}
			if ((e1 >= 24 && e2 > 0)) {
				System.out.println("Invalid Time");
				return;
			}
			if (e1 > 12)
				e1 = e1 - 12;
			sb = sb.append(returnValue(e1));
			if (e2 == 00) {
				System.out.println(sb.append(" O'Clock").toString());
				return;
			}
			if (e2 > 60 || e2 < 0)
				throw new Exception("Invalid Time");
			if (e2 > 30) {
				e2 = 60 - e2;
				e1++;
				sb = sb2.append(returnValue(e2) + " to " + e1);
				System.out.println(sb.toString());
				return;
			}

			sb = sb2.append(returnValue(e2) + " past " + e1);
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println("Invalid Time");
		}
	}
}