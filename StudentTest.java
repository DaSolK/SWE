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
				if(i == 10)
					System.out.println("더이상 입력할 수 없습니다");
				else{
					System.out.println("[학생 정보 입력]");
					st[i] = new Student();
					scan.nextLine();  // 자바 Scanner의 문제로 불필요한 개행문자를 제거하기 위해 임시로 넣은 코드임
					System.out.print("ID:");
					st[i].ID = scan.nextLine();
					System.out.print("name:");
					st[i].Sname = scan.nextLine();
					System.out.print("department:");
					st[i].department = scan.nextLine();
					System.out.print("phon number:");
					st[i].phonNumber = scan.nextLine();
					i++;
				}
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
