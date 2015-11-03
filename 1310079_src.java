

package sowegong;

import java.util.Scanner;
import java.io.*;

class Student implements Serializable {
   public String ID;
   public String Sname;
   public String department;
   public String phonNumber;
}

class StudentClass {

   Student[] st = new Student[100];
   static int i=0;

   public static void add(Student[] st, Scanner scan) {
      if (i == 100)
         System.out.println("Too many students records here");
      else {
         System.out.println("Enter students information");
         st[i] = new Student();
         scan.nextLine();
         System.out.println("ID : ");
         st[i].ID = scan.nextLine();
         System.out.print("name:");
         st[i].Sname = scan.nextLine();
         System.out.print("department:");
         st[i].department = scan.nextLine();
         System.out.print("phone number:");
         st[i].phonNumber = scan.nextLine();
      }
   }

   public static void view(Student[] st, Scanner scan) throws Exception {
      for (int j = 0; j < i; j++) {
         int k = j + 1;
         System.out.println(k + ")\nID: " + st[j].ID + "\n" + "name: "
               + st[j].Sname + "\n" + "department: " + st[j].department
               + "\n" + "phone number: " + st[j].phonNumber);
         System.out.println();
      }
   }

   public static void update(Student[] st, Scanner scan) {
      Scanner scan1 = new Scanner(System.in);
      System.out.print("Enter the student's ID who you want to update phone number:");
      String ID = scan1.nextLine();
      for (int j = 0; j < i; j++) {
         if (ID.equals(st[j].ID)) {
            System.out.println("ID: " + st[j].ID + "\n" +
            "name: " + st[j].Sname + "\n" + "department: "
                  + st[j].department + "\n" + "phone number: " + st
                  [j].phonNumber);
            System.out.println("Enter new phone number");
            System.out.print("phone number:");
            st[j].phonNumber = scan1.nextLine();
            System.out.println("Update completed");
            break;
         } 
         else 
            System.out.println("There is no such ID");
      }
   }

   public static void delete(Student[] st, Scanner scan) {
      Scanner scan2 = new Scanner(System.in);
      System.out.print("Enter the student's ID who you want to delete:");
      String ID1 = scan2.nextLine();
      int t = -1;
      for (int j = 0; j < i; j++) {
         if (ID1.equals(st[j].ID)) {
            System.out.println("ID: " + st[j].ID + "\n" + "name: "
                  + st[j].Sname + "\n" + "department: "
                  + st[j].department + "\n" + "phone number: "
                  + st[j].phonNumber);
            t = j;
            break;
         }
      }
      if (t != -1) {
         for (; t < i; t++) 
            st[t] = st[t + 1];
         i = i - 1;
         System.out.println("Delete completed");
      } 
      else 
         System.out.println("There is no such ID");
      
   }
   
   public static void fileSave(Student [] st) throws Exception {
      ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("tmp.txt"));
      oos.writeInt(i);
      for (int j = 0; j < i; j++)
         oos.writeObject(st[j]);
      oos.close();
      System.out.println("All records are saved");
   }
   
   public static void fileOpen(Student [] st) throws Exception{
      System.out.println("Records from file");
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmp.txt"));
      i = ois.readInt();
      System.out.println(i);
      for (int j = 0; j < i; j++) {
         st[j] = (Student) ois.readObject();
         System.out.println("ID: " + st[j].ID + "\n" + "name: "
               + st[j].Sname + "\n" + "department: "
               + st[j].department + "\n" + "phone number: "
               + st[j].phonNumber);
      }
   }

   public static void main(String[] args) throws Exception {
      Student[] st = new Student[10];
      i = 0;
      Scanner scan = new Scanner(System.in);
      int menu = 0;
      do {
         do {
            System.out.println("------------------------------");
            System.out.println("1 add");
            System.out.println("2 view");
            System.out.println("3 update");
            System.out.println("4 delete");
            System.out.println("5 File save");
            System.out.println("6 File open");
            System.out.println("7 Exit");
            System.out.println("------------------------------");
            System.out.print("menu");
            menu = scan.nextInt();
         } while (menu < 1 || menu > 7);

         switch (menu) {
         case 1: // add
            if (i == 100)
               System.out.println("Too many students records here");
            else {
               add(st, scan);
               i++;
            }
            break;
         case 2: // view
            view(st, scan);
            break;
         case 3: // update
            update(st, scan);
            break;
         case 4: // delete
            delete(st,scan);
            break;
         case 5: // file save
            fileSave(st);
            break;
         case 6: // file open
            fileOpen(st);
            break;
         case 7: // quit
            System.out.println("Quit");
         }
      } while (menu != 7);
   }
}