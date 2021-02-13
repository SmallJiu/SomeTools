package cat.jiu.util;
import java.util.*;
import javax.net.ssl.*;

import cat.jiu.*;

import java.io.*;

public class TestRandom {
	

	public static void randomList(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("=============");
		System.out.println("输入需要执行的程序id");
		System.out.println("0=返回主菜单");
		System.out.println("1=Int");
		System.out.println("2=Float");
		System.out.println("=============");
		int i = input.nextInt();

		if(i == 0) {
			Main.main(args);
		}if(i == 1) {
			testIntRandom();
			randomList(args);
		}if(i == 2) {
			testFloatRadom();
			randomList(args);
		}if(i == 3) {
			randomList(args);
		}if(i == 4) {
			randomList(args);
		}else {
			System.out.println("");
			TestRandom.randomList(args);
		}
	}
	
	
	
	public static void testIntRandom(){
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("循环多少次");
		int i = input.nextInt();
		System.out.println("最大值");
		int u = input.nextInt();
		int l = 0;
		for(int k = 0; k < i; k++) {
			int j = rand.nextInt(u)+1;
			System.out.println(j);
			if (j == 50) {
				int o = l++;
				System.out.println("50出现的次数："+o);
			}
		}
	}
	
	public static void testFloatRadom() {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("循环多少次");
		int i = input.nextInt();
		System.out.println("最大值");
		int u = input.nextInt();
		
		for(int k = 0; k < i; k++) {
			int o = rand.nextInt(u);
			double j = rand.nextDouble();
			System.out.println(o+j + "==" + k);
			if(((o+j) < 9.9999) && ((o+j) > 9.9999)) {
				System.out.println("Hello Damon_Jiu");
				System.out.println(k);
				break;
			}
		}
	}	
}
