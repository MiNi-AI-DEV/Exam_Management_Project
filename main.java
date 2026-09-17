import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store all registered students
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


    // =====================================================
    // STUDENT REGISTRATION
    // =====================================================

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

        // Add student to ArrayList
        students.add(student);

        System.out.println("\n=================================");
        System.out.println("    REGISTRATION SUCCESSFUL");
        System.out.println("=================================");

        System.out.println("Name            : " + student.getName());
        System.out.println("Registration ID : " + student.getRegistrationId());
        System.out.println("Password        : " + student.getPassword());

        System.out.println("\nPlease keep your Registration ID and Password safe.");
    }


    // =====================================================
    // STUDENT LOGIN
    // =====================================================

    public static void loginStudent(
            Scanner sc,
            ArrayList<Student> students) {

        System.out.println("\n---------- STUDENT LOGIN ----------");

        System.out.print("Enter Registration ID: ");
        String registrationId = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        sc.nextLine();

        boolean loginSuccessful = false;

        // Search registered students
        for (Student student : students) {

            if (student.getRegistrationId().equals(registrationId)
                    && student.getPassword().equals(password)) {

                loginSuccessful = true;

                System.out.println("\n=================================");
                System.out.println("       LOGIN SUCCESSFUL");
                System.out.println("=================================");

                System.out.println("Welcome, " + student.getName() + "!");

                // Start exam
                startExam(sc, student);

                break;
            }
        }

        if (!loginSuccessful) {

            System.out.println("\nInvalid Registration ID or Password.");
            System.out.println("Please try again.");
        }
    }


    // =====================================================
    // CREATE 10 QUESTIONS
    // =====================================================

    public static ArrayList<Question> createQuestions() {

        ArrayList<Question> questions = new ArrayList<>();


        // Question 1
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                "A. implements",
                "B. extends",
                "C. inherits",
                "D. super",
                "B"
        ));


        // Question 2
        questions.add(new Question(
                "Which method is the starting point of a Java program?",
                "A. start()",
                "B. run()",
                "C. main()",
                "D. execute()",
                "C"
        ));


        // Question 3
        questions.add(new Question(
                "Which keyword is used to create an object in Java?",
                "A. class",
                "B. object",
                "C. new",
                "D. create",
                "C"
        ));


        // Question 4
        questions.add(new Question(
                "Which of the following is used to achieve multiple inheritance in Java?",
                "A. Class",
                "B. Interface",
                "C. Constructor",
                "D. Variable",
                "B"
        ));


        // Question 5
        questions.add(new Question(
                "Which keyword is used to define an interface?",
                "A. interface",
                "B. Interface",
                "C. implements",
                "D. extends",
                "A"
        ));


        // Question 6
        questions.add(new Question(
                "Which concept allows a method to have the same name with different parameters?",
                "A. Inheritance",
                "B. Method Overloading",
                "C. Encapsulation",
                "D. Abstraction",
                "B"
        ));


        // Question 7
        questions.add(new Question(
                "Which access specifier allows access only within the same class?",
                "A. public",
                "B. protected",
                "C. private",
                "D. default",
                "C"
        ));


        // Question 8
        questions.add(new Question(
                "Which keyword is used to call the constructor of the parent class?",
                "A. this",
                "B. parent",
                "C. super",
                "D. base",
                "C"
        ));


        // Question 9
        questions.add(new Question(
                "Which class is used to represent a sequence of characters in Java?",
                "A. Character",
                "B. String",
                "C. Text",
                "D. Sequence",
                "B"
        ));


        // Question 10
        questions.add(new Question(
                "What is Dynamic Method Dispatch related to?",
                "A. Runtime Polymorphism",
                "B. Compilation",
                "C. Constructor",
                "D. Variable",
                "A"
        ));


        // Return all questions
        return questions;
    }


    // =====================================================
    // START EXAM
    // =====================================================

    public static void startExam(
            Scanner sc,
            Student student) {

        // Get all 10 questions
        ArrayList<Question> questions = createQuestions();

        //Variable to store the score
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        //Exam Information

        System.out.println("\n========================================");
        System.out.println("          JAVA ONLINE EXAM");
        System.out.println("========================================");

        System.out.println("Student Name     : " + student.getName());
        System.out.println("Registration ID  : " + student.getRegistrationId());

        System.out.println("\nTotal Questions  : " + questions.size());

        System.out.println("\nPlease Press Enter To Start The Exam...");

        sc.nextLine();


        // Display questions one by one
        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("\n----------------------------------------");

            System.out.println(
                    "Question " + (i + 1)
                    + " of "
                    + questions.size()
            );

            System.out.println("----------------------------------------");

            System.out.println(q.getQuestionText());

            System.out.println(q.getOptionA());
            System.out.println(q.getOptionB());
            System.out.println(q.getOptionC());
            System.out.println(q.getOptionD());

            //Take valid student answer

            String answer;
            while (true) {
                System.out.print("\nEnter your answer (A/B/C/D): ");
                answer = sc.nextLine().trim().toUpperCase();

                //Check wheather the answer is A, B, C or D

                if (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("D")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }

            // Check whether answer is A, B, C or D

            if(answer.equals(q.getCorrectAnswer())) {

                correctAnswers++;

                System.out.println("Correct Answer!");
                
            } else {

                incorrectAnswers++;

                System.out.println("Incorrect Answer! ");
                System.out.println("The correct answer is: " + q.getCorrectAnswer());
                
            }

        }

        // Exam completed
        System.out.println("\n========================================");
        System.out.println("          EXAM COMPLETED");
        System.out.println("========================================");
    


        //Calculate Percentage
        int totalQuestions = questions.size();

        double percentage = (correctAnswers * 100.0)/ totalQuestions;

        //Calculate Grade
        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        //Calculate Pass Fail

        String status;

        if (percentage >= 40) {
            status = "PASS";
        } else {
            status = "FAIL";
        }
        //Final Exam Report

        System.out.println("\n\n========================================");
        System.out.println("                    EXAM REPORT");
        System.out.println("========================================");

        System.out.println("Student Name : " + student.getName());
        System.out.println("Registration ID : " + student.getRegistrationId());

        System.out.println("----------------------------------------");

        System.out.println("Total Questions : " + totalQuestions);
        System.out.println("Correct Answers : " + correctAnswers);
        System.out.println("Incorrect Answers : " + incorrectAnswers);


        System.out.println("----------------------------------------");

        System.out.printf( "Percentage : %.2f%%\n", percentage );

        System.out.println("Grade : " + grade);
        System.out.println("Result : " + status);

        System.out.println("========================================");

        System.out.println("\nThank you for attending the Java exam.");

    }

}









