package model;

public class Student {
    private int id;
    private String admissionNo;
    private String name;
    private String email;
    private String course;
    private String feeStatus;
    private String grades;
    private String result;

    // Constructors
    public Student() {}

    public Student(String admissionNo, String name, String email, String course) {
        this.admissionNo = admissionNo;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAdmissionNo() { return admissionNo; }
    public void setAdmissionNo(String admissionNo) { this.admissionNo = admissionNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getFeeStatus() { return feeStatus; }
    public void setFeeStatus(String feeStatus) { this.feeStatus = feeStatus; }

    public String getGrades() { return grades; }
    public void setGrades(String grades) { this.grades = grades; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
