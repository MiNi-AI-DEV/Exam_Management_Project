import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Store all register patients

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

        //Add students to array list

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

        //Search register patients

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

    //Create 10 questions
    public static ArrayList<Question> createQuestions() {
        ArrayList<Question> questions = new ArrayList>();

        questions.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            "A. implements",
            "B. extends",
            "C. inherits",
            "D. super",
            "B"
        ));
        questions.add(new Question(
            "Which method is the starting point of a Java program?",
            "A. start()",
            "B. run()",
            "C. main()",
            "D. execute()",
            "C"
        ));
        questions.add(new Question(
            "Which keyword is used to create an object in Java?",
            "A. class",
            "B. object",
            "C. new",
            "D. create",
            "C"
        ));
        questions.add(new Question(
            "Which of the following is used to achieve multiple inheritance in Java?",
            "A. Class",
            "B. Interface",
            "C. Constructor",
            "D. Variable",
            "B"
        ));
        questions.add(new Question(
            "Which keyword is used to define an interface?",
            "A. interface",
            "B. Interface",
            "C. implements",
            "D. extends",
            "A"
        ));
        questions.add(new Question(
            "Which concept allows a method to have the same name with different parameters?",
            "A. Inheritance",
            "B. Method Overloading",
            "C. Encapsulation",
            "D. Abstraction",
            "B"
        ));
        questions.add(new Question(
            "Which access specifier allows access only within the same class?",
            "A. public",
            "B. protected",
            "C. private",
            "D. default",
            "C"
        ));
        questions.add(new Question(
            "Which keyword is used to call the constructor of the parent class?",
            "A. this",
            "B. parent",
            "C. super",
            "D. base",
            "C"
        ));
        questions.add(new Question(
            "Which class is used to represent a sequence of characters in Java?",
            "A. Character",
            "B. String",
            "C. Text",
            "D. Sequence",
            "B"
        
        ));
        questions.add(new Question(
            "What is Dynamic Method Dispatch related to?",
            "A. Runtime Polymorphism",
            "B. Compilation",
            "C. Constructor",
            "D. Variable",
            "A"
    ));

    return questions;
    }
}