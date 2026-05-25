package StudentGradeTracker;

public class Student {
    String name;
    double grade;
    int rollNo;

    public Student(int rollNo, double grade, String name) {
        this.rollNo = rollNo;
        this.grade = grade;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getRollNo() {
        return rollNo;
    }
}
