package StudentGradeTracker;

import java.util.ArrayList;

public class UseStudent {
    ArrayList<Student> student = new ArrayList<>();

    public void showOption() {
        System.out.println("    ┌─────────────────────────────┐");
        System.out.println("    │          MAIN MENU          │");
        System.out.println("    ├─────────────────────────────┤");
        System.out.println("    │  1. Add Student Data        │");
        System.out.println("    │  2. View Students           │");
        System.out.println("    │  3. Show Report             │");
        System.out.println("    │  4. Exit                    │");
        System.out.println("    └─────────────────────────────┘");
//        System.out.println();
    }

    public boolean isRollNoExists(int rollno) {
        for (Student s : student) {
            if (s.getRollNo() == rollno) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(int rollno, String name, double grade) {
        Student st = new Student(rollno, grade, name);
        student.add(st);
        System.out.println("    ┌─────────────────────────────┐");
        System.out.println("    |" + "\"" + st.getName() + "\" " + "added successfully  ");
        System.out.println("    └─────────────────────────────┘");
    }

    public String showStudent() {
        if (student.isEmpty()) {

            System.out.println("No student data available.");
            return String.valueOf(true);
        }
        System.out.println("    ┌─────────────────────────────┐");
        System.out.println("    |   View  ALL Students        |");
        System.out.println("    └─────────────────────────────┘");
        String stname = "";
        System.out.println("   =================================");
        System.out.print("    Name");
        System.out.println("                       RollNo ");
        System.out.println("   =================================");
        for (Student s : student) {
            stname = s.getName();
            System.out.print("    " + stname);
            System.out.println("                      " + s.getRollNo());
        }
        System.out.println("   =================================");
        System.out.println("   ┌────────────────────────────────┐");
        System.out.println("   │  Total Students  :-  " + student.size() + "         │");
        System.out.println("   └────────────────────────────────┘");
        return stname;
    }

    public double findHighest() {
        System.out.println("    ┌─────────────────────────────┐");
        System.out.println("    |      Students Report        |");
        System.out.println("    └─────────────────────────────┘");
        String stname;
        System.out.println("    ───────────────────────────────");
        System.out.print("    Name");
        System.out.println("                     Grade ");
        System.out.println("    ───────────────────────────────");
        for (Student s : student) {
            stname = s.getName();
            System.out.print("    " + stname);
            System.out.println("                      " + s.getGrade());
        }
        System.out.println("    ───────────────────────────────");
        double highest = student.get(0).getGrade();

        for (Student s : student) {

            if (highest < s.getGrade()) {
                highest = s.getGrade();
            }
        }
        System.out.println("Highest Marks : " + highest);
        return highest;
    }

    public double calculateAverage() {
        double sum = 0;
        for (Student s : student) {
            sum += s.getGrade();
        }
        double average = sum / student.size();
        System.out.printf("Average Marks : %.2f%n", average);
        return average;
    }

    public double findLowest() {
        double lowest = student.get(0).getGrade();
        for (Student s : student) {
            if (lowest > s.getGrade()) {
                lowest = s.getGrade();
            }
        }
        System.out.println("Lowest  Marks : " + lowest);
        return lowest;
    }

    public void performance() {
        double average = calculateAverage();
        if (average < 40) {
            System.out.println("┌─────────────────────────────────────────────┐");
            System.out.println("│  Class Performance :- Need Improvement      │");
            System.out.println("└─────────────────────────────────────────────┘");
            System.out.println();
        } else if (average < 60) {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│  Class Performance :- Good             │");
            System.out.println("└────────────────────────────────────────┘");
        } else if (average < 75) {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│  Class Performance :- Excellent        │");
            System.out.println("└────────────────────────────────────────┘");
        } else {
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│  Class Performance :- Outstanding      │");
            System.out.println("└────────────────────────────────────────┘");
        }

    }

    public int viewReport() {
        if (student.isEmpty()) {

            System.out.println("No student data available.");
            return 0;
        }
        findHighest();
        findLowest();
        performance();
        return 0;
    }

    public void invalidOption() {
        System.out.println("    ┌─────────────────────────────┐");
        System.out.println("    |  !!  Enter Valid Option !!  |");
        System.out.println("    └─────────────────────────────┘");
    }
}
