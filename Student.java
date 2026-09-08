public class Student {

    private static int idCounter = 1000; // Starting ID for students

    private String name;
    private int age;
    private String qualification;
    private double percentage;
    private String contactNo;
    private String registrationId;
    private String password;
    
    
    public Student(String name, int age,String qualification,
        double percentage, String contactNo, 
        String registrationId, String password)
    {

        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.percentage = percentage;
        this.contactNo = contactNo;
        this.registrationId = "STU" + (++idCounter);
        this.password = password;
    }

    public String getName() 
    {
    return name;
    }
    public int getAge() 
    {
    return age;
    }
    public String getQualification() 
    {   
    return qualification;
    }
    public double getPercentage() 
    {
    return percentage;
    }
    public String getContactNo() 
    {
    return contactNo;
    }
    public String getRegistrationId() 
    {
    return registrationId;
    }
    public String getPassword() 
    {
    return password;
    }
}