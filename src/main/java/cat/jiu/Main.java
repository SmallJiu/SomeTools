package cat.jiu;

import java.util.*;
import java.io.*;

import java.io.IOException;
import java.util.Scanner;

import cat.jiu.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("================");
		System.out.println("=====输入数字====");
		System.out.println("================");
		System.out.println("0:退出该程序");
		System.out.println("1:矿物相关");
		System.out.println("2:随机相关");
		System.out.println("================");
		
		Scanner input = new Scanner(System.in);
		int u = input.nextInt();
		
		if (u == 0) {
			System.exit(0);
		}
		if (u == 1) {
			try {
				OreDict.oreList(args);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (u == 2) {
			try {
				TestRandom.randomList(args);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("请再输入一次");
			main(args);
		}
		input.close();
	}
}
