import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       EXAM MANAGEMENT SYSTEM");
            System.out.println("========================================");

            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:
                    registerStudent(sc, students);
                    break;

                case 2:
                    loginStudent(sc, students);
                    break;

                case 3:
                    System.out.println("\nThank you for using Exam Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }


    // Student Registration
    public static void registerStudent(
            Scanner sc,
            ArrayList<Student> students) {

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


    // Student Login
    public static void loginStudent(
            Scanner sc,
            ArrayList<Student> students) {

        System.out.println("\n---------- STUDENT LOGIN ----------");

        System.out.print("Enter Registration ID: ");
        String registrationId = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        boolean loginSuccessful = false;

        for (Student student : students) {

            if (student.getRegistrationId().equals(registrationId)
                    && student.getPassword().equals(password)) {

                loginSuccessful = true;

                System.out.println("\n=================================");
                System.out.println("       LOGIN SUCCESSFUL");
                System.out.println("=================================");

                System.out.println("Welcome, " + student.getName() + "!");

                break;
            }
        }

        if (!loginSuccessful) {

            System.out.println("\nInvalid Registration ID or Password.");
            System.out.println("Please try again.");
        }
    }
}