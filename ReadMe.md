Exam Management System

A Java console-based Exam Management System developed using Core Java and Object-Oriented Programming concepts.

The application allows students to register, receive a unique registration ID and generated password, log in using their credentials, attend a 10-question Java MCQ examination, and receive an automatically calculated exam report.

Student registration details and exam reports are saved in CSV files for record keeping.

1. Project Objective

The main objective of this project is to develop a simple console-based examination system using Java.

The application demonstrates practical usage of:

Java Classes and Objects
Encapsulation
Constructors
Access Specifiers
Methods
Static Members
String handling
ArrayList
Scanner
Conditional Statements
Loops
Switch Statement
Method calling
Exception Handling
File Handling
CSV data storage
Object-Oriented Programming

2. Main Features
Student Registration

The student enters:

Student Name
Age
Maximum Qualification
Percentage
Contact Number

The system automatically generates:

Registration ID
Password

The student information is stored in an ArrayList.

The registration information is also saved into:

students.csv
Student Login

The student provides:

Registration ID
Password

The system searches the registered students stored in the ArrayList.

If both values match, login is successful and the student can start the examination.

Java Online Examination:

The system contains 10 Java MCQ questions.

Each question contains:

Question
Option A
Option B
Option C
Option D
Correct Answer

The student must enter:

A
B
C
D

Invalid answers are rejected until the student enters a valid option.

Automatic Result Calculation:

After completing all questions, the application calculates:

Total Questions
Correct Answers
Incorrect Answers
Percentage
Grade
Pass/Fail Result

Exam Report Storage:

After the examination, the student-wise result is saved in:

exam_reports.csv

The report stores:

Registration ID
Student Name
Total Questions
Correct Answers
Incorrect Answers
Percentage
Grade
Result

3. Project Structure
Exam_Management_Project
│
├── Main.java
│
├── Student.java
│
├── Question.java
│
├── students.csv
│
├── exam_reports.csv
│
└── README.md

4. Class Responsibilities
Main.java

Main.java controls the application flow.

It contains methods for:

Displaying the main menu
Registering students
Student login
Creating examination questions
Starting the examination
Calculating results
Saving student information
Saving exam reports

Student.java

Student.java represents a student.

It stores:

Name
Age
Qualification
Percentage
Contact Number
Registration ID
Password

The class uses private variables to implement encapsulation.

It also contains the logic for generating the student's password.

Question.java

Question.java represents one examination question.

It stores:

Question Text
Option A
Option B
Option C
Option D
Correct Answer

Each question is represented as a Question object.

5. Java Concepts Used
Class

A class is a blueprint for creating objects.

Example:

public class Student

The Student class defines the properties and behavior of a student.

Object

An object is an instance of a class.

Example:

Student student = new Student(
    name,
    age,
    qualification,
    percentage,
    contactNo
);

This creates a Student object.

Encapsulation

Student variables are declared as:

private

They are accessed using public getter methods.

Example:

public String getName()

This protects the internal data of the object.

Constructor

The constructor initializes a Student object.

Example:

public Student(
    String name,
    int age,
    String qualification,
    double percentage,
    String contactNo
)

It receives student information and initializes the object's variables.

Static Member

The student registration ID counter uses a static variable.

A static variable belongs to the class rather than an individual object.

ArrayList

The application uses:

ArrayList<Student> students = new ArrayList<>();

This stores multiple Student objects dynamically.

Scanner

The application uses:

Scanner sc = new Scanner(System.in);

Scanner is used to accept input from the keyboard.

Examples:

sc.nextLine();
sc.nextInt();
sc.nextDouble();
sc.next();
Switch Statement

The main menu uses a switch statement to select the operation.

Example:

1 → Student Registration
2 → Student Login
3 → Exit
Loop

The main application uses:

while (true)

so that the menu continues to appear until the user selects Exit.

The examination uses a for loop to display the 10 questions.

Exception Handling

File operations use:

try
catch

to handle IOException.

This prevents the application from terminating unexpectedly when a file operation fails.

6. Application Flow
                    START
                      |
                      v
              Main Menu Display
                      |
          +-----------+-----------+
          |           |           |
          v           v           v
     Registration    Login       Exit
          |           |
          v           v
    Create Student   Verify ID
          |           |
          v           v
   Generate ID     Login Success
   Generate Password    |
          |              v
          v         Start Exam
    Save to CSV           |
          |               v
          |        Answer 10 MCQs
          |               |
          |               v
          |       Calculate Result
          |               |
          |               v
          |         Exam Report
          |               |
          |               v
          |       Save to CSV
          |
          v
       Main Menu
7. Student Registration Flow

The registration method receives:

Scanner sc
ArrayList<Student> students

The method accepts student details from the user.

A Student object is then created:

Student student = new Student(
    name,
    age,
    qualification,
    percentage,
    contactNo
);

The object is added to the ArrayList:

students.add(student);

The registration details are then saved:

saveStudent(student);

Finally, the application displays:

Name
Registration ID
Password
8. Student Login Flow

The login method receives:

Scanner sc
ArrayList<Student> students

The student enters:

Registration ID
Password

The application loops through the ArrayList:

for (Student student : students)

It compares:

student.getRegistrationId().equals(registrationId)

and:

student.getPassword().equals(password)

If both match:

Login Successful

The examination starts.

If they do not match:

Invalid Registration ID or Password

is displayed.

9. Question Creation

The method:

createQuestions()

creates an:

ArrayList<Question>

Each question is created using the Question constructor.

Example:

questions.add(new Question(
    "Which keyword is used to inherit a class in Java?",
    "A. implements",
    "B. extends",
    "C. inherits",
    "D. super",
    "B"
));

The method finally returns the complete list:

return questions;
10. Examination Process

The startExam() method receives:

Scanner sc
Student student

It calls:

ArrayList<Question> questions = createQuestions();

Two variables store the result:

int correctAnswers = 0;
int incorrectAnswers = 0;

The application displays each question using a for loop.

The student enters an answer.

The input is converted to uppercase:

.toUpperCase()

and spaces are removed using:

.trim()

The application validates whether the answer is:

A
B
C
D

If the answer is correct:

correctAnswers++;

Otherwise:

incorrectAnswers++;
11. Percentage Calculation

The percentage is calculated using:

double percentage =
    (correctAnswers * 100.0) / totalQuestions;

100.0 is used so that Java performs floating-point division.

For example:

8 correct answers
10 total questions

Percentage = 8 × 100 / 10
           = 80%
12. Grade Calculation

The application uses an if-else if-else ladder.

>= 90 → A+
>= 80 → A
>= 70 → B
>= 60 → C
>= 50 → D
< 50  → F

The conditions are checked from the highest range to the lowest.

13. Pass/Fail Calculation

The application uses:

if (percentage >= 40) {
    status = "PASS";
} else {
    status = "FAIL";
}

Therefore:

40% or above → PASS
Below 40%    → FAIL
14. CSV File Handling

The application uses:

FileWriter

to save data.

Student registration information is saved in:

students.csv

Exam reports are saved in:

exam_reports.csv

The application uses append mode so that new records can be added without deleting existing records.

15. Why CSV Was Used

CSV was selected because it is:

Simple
Lightweight
Easy to read
Easy to open in Excel
Easy to generate using Java
Suitable for a beginner-level console project

For a larger production system, a database such as MySQL would be more appropriate.

16. How to Compile

Open PowerShell and navigate to the project:

cd C:\Users\User\Github\Exam_Management_Project

Compile:

javac *.java

Run:

java Main
17. Example Application Menu
========================================
       EXAM MANAGEMENT SYSTEM
========================================

1. Student Registration
2. Student Login
3. Exit

Enter your choice:
18. Example Registration
---------- STUDENT REGISTRATION ----------

Enter Student Name: Sumana Dey
Enter Age: 30
Enter Maximum Qualification: MSc
Enter Percentage: 85.5
Enter Contact Number: 7439847906

The system generates:

Registration ID : STU1001
Password        : generated password
19. Example Exam Report
========================================
                    EXAM REPORT
========================================

Student Name : Sumana Dey
Registration ID : STU1001

----------------------------------------
Total Questions : 10
Correct Answers : 8
Incorrect Answers : 2
----------------------------------------

Percentage : 80.00%
Grade : A
Result : PASS

========================================
20. Current Limitations

The current version is a Core Java console application.

The current implementation does not yet include:

Database connectivity
User interface/web interface
Password encryption
Persistent student loading after application restart
Admin module
Timer for examination
Randomized questions
Question-wise permanent result storage

These can be considered future enhancements.

21. Possible Future Enhancements

The project can later be extended with:

MySQL database
Spring Boot REST API
Web interface
Admin login
Question management
Random question selection
Exam timer
Password encryption/hashing
Student result history
PDF/Excel reports
Email notification
Role-based authentication
22. Interview Topics From This Project

During an interview, I should be prepared to explain:

Core Java
Class
Object
Constructor
Method
Static keyword
Access specifiers
Encapsulation
String
ArrayList
Scanner
Loops
Conditional statements
Switch
Exception handling
File handling
OOP
Encapsulation
Inheritance
Polymorphism
Abstraction
Interface
Constructor
Collections
ArrayList
Adding objects
Iterating through ArrayList
File Handling
FileWriter
CSV
IOException
try-with-resources
Programming Logic
Input validation
Searching
Counting
Percentage calculation
Grade calculation
Pass/fail calculation
23. Important Interview Explanation

If the interviewer asks:

"Explain your project."

I can answer:

"I developed a Java console-based Exam Management System using Core Java and OOP concepts. The system allows students to register by entering their personal and academic information. During registration, the application generates a unique registration ID and password. The student can then log in using these credentials and attend a 10-question Java MCQ examination. The application validates the answers, calculates correct and incorrect answers, percentage, grade, and pass/fail status. I used ArrayList to manage student objects and FileWriter with CSV files to store registration details and exam reports. The project helped me implement concepts such as classes, objects, constructors, encapsulation, static members, collections, loops, conditional statements, exception handling, and file handling."

24. Project Learning Outcome

Through this project, I learned how to convert individual Java concepts into a working application.

Instead of writing isolated programs, I used multiple Java concepts together to build an end-to-end workflow:

Input
 ↓
Object Creation
 ↓
Collection
 ↓
Login
 ↓
Exam
 ↓
Calculation
 ↓
Report
 ↓
File Storage
Author

Sumana

Java Learner / Developer

Project: Exam Management System

Technology: Core Java

Storage: CSV