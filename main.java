import java.util.Scanner;
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("=================================");
        System.out.println("     EXAM MANAGEMENT SYSTEM");
        System.out.println("=================================");



        System.out.println("\n---------Student Registration---------");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        sc.nextLine(); // Consume the newline character

        System.out.print("Enter Student Qualification: ");
        String qualification = sc.nextLine();

        System.out.print("Enter Student Percentage: ");
        double percentage = sc.nextDouble();

        sc.nextLine(); // Consume the newline character

        System.out.print("Enter Student Contact Number: ");
        String contactNo = sc.next();

        System.out.println("\nRegistration Details");
        System.out.println("--------------------");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Qualification: " + qualification);
        System.out.println("Percentage: " + percentage);
        System.out.println("Contact Number: " + contactNo);

        sc.close();     
        
    }
}