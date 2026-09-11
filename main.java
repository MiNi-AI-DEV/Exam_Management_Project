import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        registerStudent(sc, students);
    }

    public static void registerStudent(Scanner sc, ArrayList<Student> students) {
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
        students.add(student);

        System.out.println("\n=================================");
        System.out.println("    REGISTRATION SUCCESSFUL");
        System.out.println("=================================");

        System.out.println("Name            : " + student.getName());
        System.out.println("Registration ID : " + student.getRegistrationId());
        System.out.println("Password        : " + student.getPassword());

       
        System.out.println("\nPlease keep your Registration ID and Password safe.");

    }
}