package day1;

import java.util.Scanner;

public class hello {
	private String name;

	public hello(String name) {
		super();
		this.name = name;
		System.out.println("Welcome to the world of java " + name);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your name my friend ");
		hello h1 = new hello(sc.nextLine());		
	}

}
