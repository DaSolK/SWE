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
				for (int j = 0; j < i; j++) {
					int k = j + 1;
					System.out.println( k + ": " + mc[j].ID +"/"+mc[j].Sname+"/"+mc[j].department+"/"+mc[j].phonNumber);
				} 
				break;
			case 3: //update
				Scanner scan1 = new Scanner(System.in);
				System.out.print("update하고자 하는 학생 ID을 입력하세요:");
				String ID = scan1.nextLine();
			    for(int j = 0; j<i; j++){
					if (ID.equals(mc[j].ID)) {
						System.out.println(mc[j].ID +"/"+mc[j].Sname+"/"+mc[j].department+"/"+mc[j].phonNumber);
						System.out.println("update할 정보를 입력 하세요");
						System.out.print("phon number:");
						mc[j].phonNumber = scan1.nextLine();
						System.out.println("update 되었습니다.");
						break;
					}
					else{
						System.out.println("존재하지 않는 ID 입니다.");
					}
				} 
			    break;
			case 4: //delete
				Scanner scan2 = new Scanner(System.in);
				System.out.print("delete하고자 하는 학생 ID을 입력하세요:");
				String ID1 = scan2.nextLine();
			    int t = -1;
			    for(int j = 0; j<i; j++){
					if (ID1.equals(mc[j].ID)) {
						System.out.println(mc[j].ID +"/"+mc[j].Sname+"/"+mc[j].department+"/"+mc[j].phonNumber);
						t = j;
						break;
					}
				}
			    if(t != -1){
			    	for(;t<i;t++){
			    		mc[t] = mc[t+1];
			    	}
			    	i = i-1;
			    	System.out.println("위의 학생 정보가 delete 되었습니다.");
			    }
			    else{
			    	System.out.println("존재하지 않는 ID 입니다.");
			    }
			    break;
			case 5: //file save
				
			case 6: //file open
				
			case 7: //quit
				System.out.println("Quit");
				
			}
		}while(menu != 7);
	}

}
