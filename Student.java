import java.util.Random;

public class Student {

    private static int idCounter = 1000;

    private String name;
    private int age;
    private String qualification;
    private double percentage;
    private String contactNo;
    private String registrationId;
    private String password;

    // Constructor
    public Student(String name, int age, String qualification,
                   double percentage, String contactNo) {

        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.percentage = percentage;
        this.contactNo = contactNo;

        // Automatically generate Registration ID
        this.registrationId = "STU" + (++idCounter);

        // Automatically generate Password
        this.password = generatePassword();
    }

    // Password generation method
    private static String generatePassword() {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                          + "abcdefghijklmnopqrstuvwxyz"
                          + "0123456789";

        String password = "";

        Random random = new Random();

        for (int i = 0; i < 8; i++) {

            int index = random.nextInt(characters.length());

            password = password + characters.charAt(index);
        }

        return password;
    }

    // Getter methods

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getPassword() {
        return password;
    }
}   