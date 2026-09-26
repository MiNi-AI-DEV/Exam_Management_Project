PART 1 — Import Statements

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// I used ArrayList because the number of students is dynamic. Unlike a fixed-size array, ArrayList can grow automatically when new students are registered.

PART 2 — Scanner

Scanner is a Java class used to take input from the user.

Scanner sc = new Scanner(System.in); //I used Scanner to accept user input from the console, such as student name, age, qualification, percentage, contact number, registration ID, password and exam answers.

PART 3 — FileWriter

import java.io.FileWriter; //I used append mode so that new student or exam records are added to the existing CSV file instead of overwriting previous records.

PART 4 — IOException // File operations can fail.

For example:

File may not be accessible
Permission problem
Disk problem
Other I/O error

PART 5 — Main Class

For a public class, the Java filename must match the class name:


Because Main is a public class, Java requires the source file to be named Main.java.

PART 6 — main() Method

public static void main(String[] args) 

public
public

The JVM needs access to this method from outside the class.

static
static

The JVM can call the method without creating a Main object.

For example, we don't need:

Main obj = new Main();

before starting the application.

void
void

The method does not return a value.

main
main

This is the standard entry point of a Java application.

String[] args
String[] args

This allows command-line arguments to be passed to the program.

 Why is main() static?

The JVM calls the main method to start the application. Making it static allows the JVM to invoke it without creating an object of the Main class.

PART 7 — Scanner Object


Scanner sc = new Scanner(System.in);

There are three things happening.

1. Scanner

The data type/class.

2. sc

The reference variable.

3. new Scanner(System.in)

Creates a Scanner object.


Scanner
   ↓
Class/type

sc
   ↓
Reference

new Scanner(System.in)
   ↓
Object
PART 8 — ArrayList of Students

ArrayList<Student> students = new ArrayList<>();

ArrayList

Collection type.

<Student>

Generic type.

It means:

This ArrayList is intended to contain Student objects.

students

Variable/reference name.

new ArrayList<>()

Creates the actual ArrayList object.

So:

students
   ↓
ArrayList
   ↓
Student objects

For example:

students
 ├── Student object 1
 ├── Student object 2
 └── Student object 3
PART 9 — Infinite Menu Loop

while (true) 

This creates a loop that continues indefinitely.

Why?

Because the Exam Management System should keep showing the menu:

1. Student Registration
2. Student Login
3. Exit

until the user chooses Exit.

The loop is stopped here:

return;

inside case 3.

Interview question

Why did you use while(true)?

Answer:

I used while(true) because the application menu should continue running until the user explicitly selects the Exit option. The return statement terminates the main method and therefore the application.

PART 10 — Menu Display

Your code contains:

System.out.println("1. Student Registration");
System.out.println("2. Student Login");
System.out.println("3. Exit");

These are simply displaying the available operations.

Then:

System.out.print("\nEnter your choice: ");

asks the user for input.

PART 11 — Reading Menu Choice
int choice = sc.nextInt();

The user enters something like:

1

nextInt() reads the integer.

The value is stored in:

choice

For example:

choice = 1
PART 12 — Why sc.nextLine()?

Immediately after:

int choice = sc.nextInt();

you have:

sc.nextLine();

This is an important interview concept.

nextInt() reads the integer but leaves the newline character in the input buffer.

Then nextLine() consumes that leftover newline.

Without it, when you later use:

sc.nextLine()

for a name, Java could read the leftover newline instead of waiting for the user's name.

Interview question

Why did you use nextLine() after nextInt()?

Answer:

nextInt() reads only the integer and leaves the newline character in the input buffer. I use nextLine() to consume that newline before reading the next line-based String input.

This is a very common Java interview question.

PART 13 — switch

Your code:

switch (choice) {

The program checks the value of choice.

Then:

case 1:

means registration.

case 2:

means login.

case 3:

means exit.

PART 14 — Method Calling

Case 1:

registerStudent(sc, students);

This calls your registration method.

Notice that you are passing two arguments:

sc
students

The method receives them here:

public static void registerStudent(
        Scanner sc,
        ArrayList<Student> students)

This demonstrates parameter passing and method reuse.

PART 15 — break

After:

registerStudent(sc, students);

you have:

break;

This exits the current switch case.

It does not exit the entire while loop.

The menu therefore appears again.

PART 16 — Exit

Your case 3 is:

case 3:
    System.out.println("\nThank you for using Exam Management System.");
    sc.close();
    return;
sc.close()

Closes the Scanner.

return

Ends the main() method.

Since main() is the application's entry point, the program terminates.

PART 17 — Default
default:
    System.out.println("\nInvalid choice. Please try again.");

If the user enters:

4

or:

10

the program reaches default.

This is input handling for invalid menu choices.

PART 18 — registerStudent()

Now we enter your first major method:

public static void registerStudent(
        Scanner sc,
        ArrayList<Student> students) {

This method is responsible for:

Input student information
       ↓
Create Student object
       ↓
Store Student in ArrayList
       ↓
Save Student to CSV
       ↓
Display Registration ID & Password
PART 19 — Student Name
System.out.print("Enter Student Name: ");
String name = sc.nextLine();

First the program asks for the name.

Then:

String name

stores it.

nextLine() is used because a person's name may contain spaces.

For example:

Sumana Dey
PART 20 — Age
System.out.print("Enter Age: ");
int age = sc.nextInt();

Age is stored as an int.

Example:

30
PART 21 — Qualification

You use:

sc.nextLine();

again because nextInt() was previously used.

Then:

String qualification = sc.nextLine();

This allows input such as:

MSc Mathematics
PART 22 — Percentage
double percentage = sc.nextDouble();

You use double because percentage may contain decimal values:

85.5

rather than only whole numbers.

PART 23 — Contact Number
String contactNo = sc.next();
 the contact number as a String.

A phone number is not something that perform mathematical calculations on.

Also, phone numbers can potentially begin with zero.

So storing it as String is appropriate.

PART 24 — Creating Student Object

Student student = new Student(
        name,
        age,
        qualification,
        percentage,
        contactNo
);

This creates a Student object.

You pass five values to the constructor:

name
age
qualification
percentage
contactNo

The constructor then initializes the Student object's fields and generates its registration ID and password.

This is object creation using a constructor.

PART 25 — ArrayList add()
students.add(student);

This adds the Student object to your ArrayList.

Before:

students
 ├── Student 1
 └── Student 2

After:

students
 ├── Student 1
 ├── Student 2
 └── New Student
PART 26 — Save Student
saveStudent(student);

This calls your own method.

The method receives the newly created Student object and writes its information to:

students.csv

This is an example of modular programming.

Instead of putting file-writing code directly inside registration, you separated it into another method.

That makes the program easier to maintain.

PART 27 — Getter Methods

You then have:

student.getName()
student.getRegistrationId()
student.getPassword()

These are getter methods from Student.java.

Why not directly access:

student.name

?

Because your Student fields are private.

This demonstrates encapsulation.

PART 28 — loginStudent()

The method:

public static void loginStudent(
        Scanner sc,
        ArrayList<Student> students)

receives the same two things:

Scanner
ArrayList<Student>

It needs the Scanner to receive login credentials and the ArrayList to search registered students.

PART 29 — Login Input
String registrationId = sc.next();
String password = sc.next();

The student enters:

Registration ID
Password

Both are stored as Strings.

PART 30 — Boolean Flag
boolean loginSuccessful = false;

This variable keeps track of whether authentication succeeded.

Initially:

false

If matching credentials are found:

loginSuccessful = true;
PART 31 — Enhanced For Loop

This is very important:

for (Student student : students) {

This is an enhanced for loop, also called a for-each loop.

It means:

Take each Student object from the students ArrayList, one at a time, and temporarily refer to it as student.

Example:

students
 ├── Sumana
 ├── Rahul
 └── Priya

The loop checks:

Sumana
Rahul
Priya

one by one.

PART 32 — Login Verification

Your condition is:

if (student.getRegistrationId().equals(registrationId)
        && student.getPassword().equals(password))

Two conditions must be true.

First:
student.getRegistrationId().equals(registrationId)

checks the Registration ID.

Second:
student.getPassword().equals(password)

checks the password.

&&

means logical AND.

Therefore:

Correct ID + Correct Password
           ↓
        Login
      Successful

If either one is wrong:

Login unsuccessful
PART 33 — Why .equals()?

This is another important interview question.

You use:

.equals()

instead of:

==

for String content comparison.

Interview answer:

In Java, equals() is used to compare the actual content of String objects, whereas == compares references.

PART 34 — Start Exam

After successful login:

startExam(sc, student);

The current Student object is passed into the exam method.

This is important because the exam report needs to know:

Which student is taking the exam?

The method therefore receives:

Scanner sc
Student student
PART 35 — break

After the exam:

break;

This exits the student-search loop.

Without it, the program could continue checking unnecessary Student objects.

PART 36 — Login Failure

After the loop:

if (!loginSuccessful)

The ! means NOT.

So:

loginSuccessful = false

becomes:

!false = true

and the failure message is displayed.

PART 37 — createQuestions()

Now your question creation method:

public static ArrayList<Question> createQuestions()

Notice something important:

Unlike registerStudent(), it does not receive parameters.

And it returns:

ArrayList<Question>

That means:

This method creates and returns a list of Question objects.

PART 38 — Question ArrayList
ArrayList<Question> questions = new ArrayList<>();

This is similar to:

ArrayList<Student> students = new ArrayList<>();

But now the collection contains:

Question objects

instead of:

Student objects
PART 39 — Adding Questions

For example:

questions.add(new Question(
        "Which keyword is used to inherit a class in Java?",
        "A. implements",
        "B. extends",
        "C. inherits",
        "D. super",
        "B"
));

This does two things:

Creates a Question object.
Adds it to the ArrayList.

The last value:

"B"

is the correct answer.

Your actual project has 10 such Question objects.

PART 40 — Return Questions

At the end:

return questions;

This sends the complete ArrayList back to whoever called:

createQuestions()

For example:

ArrayList<Question> questions = createQuestions();
PART 41 — startExam()

Now we reach the most important method of the project:

public static void startExam(
        Scanner sc,
        Student student)

Its job is to conduct the entire examination.

PART 42 — Get Questions
ArrayList<Question> questions = createQuestions();

The method calls createQuestions().

The returned list is stored in:

questions
PART 43 — Score Variables
int correctAnswers = 0;
int incorrectAnswers = 0;

These counters start at zero.

Every correct answer:

correctAnswers++;

Every incorrect answer:

incorrectAnswers++;
PART 44 — Display Student Information
student.getName()
student.getRegistrationId()

Again, getter methods are being used because Student fields are private.

PART 45 — Number of Questions
questions.size()

size() returns the number of elements in the ArrayList.

Since your list has 10 Question objects:

questions.size()
= 10

This is better than hardcoding:

10

because the program can determine the actual number of questions dynamically.

PART 46 — Press Enter
sc.nextLine();

The program waits for the student to press Enter before beginning.

PART 47 — Exam Loop
for (int i = 0; i < questions.size(); i++)

This loop goes through each Question.

If there are 10 questions:

i = 0
i = 1
i = 2
...
i = 9

Notice that Java ArrayList indexing starts at zero.

PART 48 — Get Current Question
Question q = questions.get(i);

get(i) retrieves the question at the current index.

For example:

i = 0 → Question 1
i = 1 → Question 2
...
PART 49 — Display Question
System.out.println(q.getQuestionText());

The program calls the Question object's getter method.

Similarly:

q.getOptionA()
q.getOptionB()
q.getOptionC()
q.getOptionD()

display the four choices.

PART 50 — Answer Validation

You have:

while (true)

inside the question loop.

This means the program keeps asking for an answer until the student enters:

A
B
C
D

Then:

answer = sc.nextLine().trim().toUpperCase();

Three operations happen:

nextLine()

Reads the answer.

trim()

Removes extra spaces.

Example:

" A "

becomes:

"A"
toUpperCase()

Converts lowercase to uppercase.

So:

a

becomes:

A
PART 51 — Validating A/B/C/D

Your condition:

if (answer.equals("A")
        || answer.equals("B")
        || answer.equals("C")
        || answer.equals("D"))

uses logical OR:

||

Only one of these conditions needs to be true.

If valid:

break;

exits the validation loop.

Otherwise:

Invalid input.

is displayed.

PART 52 — Checking Correct Answer

Your code:

if (answer.equals(q.getCorrectAnswer()))

compares:

Student answer
       vs
Correct answer

If they match:

correctAnswers++;

Otherwise:

incorrectAnswers++;
PART 53 — Percentage

After all questions:

int totalQuestions = questions.size();

Then:

double percentage =
        (correctAnswers * 100.0) / totalQuestions;

For example:

Correct = 8
Total = 10

8 × 100 / 10
= 80%
Why 100.0?

Because 100.0 is a double, so the calculation uses floating-point arithmetic.

This helps produce decimal percentages when necessary.

PART 54 — Grade Calculation

Your code:

if (percentage >= 90) {
    grade = "A+";
}

Then:

else if (percentage >= 80)

and so on.

The ordering matters.

It checks the highest range first.

PART 55 — Pass/Fail
if (percentage >= 40) {
    status = "PASS";
} else {
    status = "FAIL";
}

So your project has a separate grading system and pass/fail rule.

For example:

Percentage = 80
Grade = A
Result = PASS
PART 56 — printf

You use:

System.out.printf("Percentage : %.2f%%\n", percentage);

This is worth understanding.

%.2f

means:

Display a floating-point number with 2 digits after the decimal point.

For example:

80.00
%%

prints a literal %.

So the output becomes:

Percentage : 80.00%
PART 57 — Saving Exam Report

At the end you have:

saveExamReport(student,
        totalQuestions,
        correctAnswers,
        incorrectAnswers,
        percentage,
        grade,
        status);

This sends all final result information to:

saveExamReport()

That method writes the result into:

exam_reports.csv
⚠️ Important: Your Current Syntax Error

Your current file also contains:

saveExamReport()

immediately before the correct call.

That line should be deleted.

It is not needed.

The correct code should end with:

System.out.println("\nThank you for attending the Java exam.");

saveExamReport(
        student,
        totalQuestions,
        correctAnswers,
        incorrectAnswers,
        percentage,
        grade,
        status
);

Your current uploaded file contains the incomplete call, so do not submit the project in this exact state.

PART 58 — saveStudent()

Your method:

public static void saveStudent(Student student)

takes one Student object.

Then:

try (FileWriter writer =
        new FileWriter("students.csv", true))

opens students.csv in append mode.

Then:

writer.write(...)

writes the student information.

The fields are separated using:

,

because CSV means:

Comma-Separated Values.

PART 59 — try-with-resources

This:

try (FileWriter writer = ...)

is called try-with-resources.

One advantage is that Java automatically closes the FileWriter when the try block finishes.

This is better than manually writing:

writer.close();

in normal circumstances.

PART 60 — catch
catch (IOException e)

handles file-writing errors.

The error message:

e.getMessage()

is displayed to the user.

PART 61 — saveExamReport()

Your method receives seven values:

Student
Total Questions
Correct Answers
Incorrect Answers
Percentage
Grade
Status

This is a good example of a method receiving multiple parameters.

It then writes:

Registration ID
Student Name
Total Questions
Correct Answers
Incorrect Answers
Percentage
Grade
Status

to:

exam_reports.csv
Your Complete Main.java Mental Model

You don't need to memorize 479 lines.

Remember this:

                         Main.java
                             |
                             v
                         main()
                             |
                     Display Main Menu
                             |
              +--------------+--------------+
              |              |              |
              v              v              v
         Registration       Login          Exit
              |              |
              v              v
      registerStudent()  loginStudent()
              |              |
              v              v
        Create Student   Verify ID +
              |           Password
              v              |
       ArrayList.add()       v
              |          startExam()
              v              |
       saveStudent()         v
              |         createQuestions()
              |              |
              |              v
              |         Display 10 MCQs
              |              |
              |              v
              |        Check Answers
              |              |
              |              v
              |       Calculate Percentage
              |              |
              |              v
              |         Calculate Grade
              |              |
              |              v
              |         PASS / FAIL
              |              |
              |              v
              |       saveExamReport()
              |              |
              v              v
         students.csv   exam_reports.csv