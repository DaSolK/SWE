package project1;

import java.util.Scanner;
import java.io.*;

class Student implements Serializable {
	public String ID;
	public String Sname;
	public String department;
	public String phonNumber;
}

public class StudentTest { 
	
	public static void main(String args){
		
		Student[] st = new Student[10];
		int i = 0;
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do{
			do{
				System.out.println("------------------------------");
				System.out.println("1 add");
				System.out.println("2 view");
				System.out.println("3 update");
				System.out.println("4 delete");
				System.out.println("5 File save");
				System.out.println("6 File open");
				System.out.println("7 Exit");
				System.out.println("------------------------------");
				System.out.print("Enter the enu");
				menu = scan.nextInt();
			}while(menu < 1 || menu > 7);
			switch(menu){
			case 1: //add
				
			case 2: //view
				
			case 3: //update
				
			case 4: //delete
				
			case 5: //file save
				
			case 6: //file open
				
			case 7: //quit
				System.out.println("Quit");
				
			}
		}while(menu != 7);
	}

}
