import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     EXAM MANAGEMENT SYSTEM");
        System.out.println("=================================");

        System.out.println("\n---------- STUDENT REGISTRATION ----------");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Maximum Qualification: ");
        String qualification = sc.nextLine();

        System.out.print("Enter Percentage: ");
        double percentage = sc.nextDouble();

        System.out.print("Enter Contact Number: ");
        String contactNo = sc.next();

        // Create Student object
        Student student = new Student(
                name,
                age,
                qualification,
                percentage,
                contactNo
        );

        System.out.println("\n=================================");
        System.out.println("    REGISTRATION SUCCESSFUL");
        System.out.println("=================================");

        System.out.println("Name            : " + student.getName());
        System.out.println("Age             : " + student.getAge());
        System.out.println("Qualification   : " + student.getQualification());
        System.out.println("Percentage      : " + student.getPercentage());
        System.out.println("Contact No      : " + student.getContactNo());

        System.out.println("\nYour Login Details");
        System.out.println("----------------------------");

        System.out.println("Registration ID : "
                + student.getRegistrationId());

        System.out.println("Password        : "
                + student.getPassword());

        System.out.println("\nPlease keep your Registration ID and Password safe.");

        sc.close();
    }
}