import java.util.ArrayList;
import java.util.Scanner;

class Student {

  
    private String studentName;
    private double studentMarks;


    public Student(String studentName, double studentMarks) {
        this.studentName  = studentName;
        this.studentMarks = studentMarks;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public double getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }
}



public class StudentGradeTracker {

    private static ArrayList<Student> studentList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│      STUDENT GRADE TRACKER           │");
        System.out.println("└──────────────────────────────────────┘");

        int choice;
        do {
            displayMenu();
            choice = readMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    displayReport();
                    break;
                case 4:
                    System.out.println("\n  Goodbye! Thank you for using Student Grade Tracker.");
                    System.out.println("  Program exited successfully.\n");
                    break;
                default:
                    System.out.println("\n  [!] Invalid choice. Please enter 1 – 4.\n");
            }

        } while (choice != 4);   // Repeat until user selects 'Exit'

        scanner.close();   // Release the Scanner resource before exit
    }


    private static void displayMenu() {
        System.out.println();
        System.out.println("  ┌─────────────────────────────┐");
        System.out.println("  │          MAIN MENU          │");
        System.out.println("  ├─────────────────────────────┤");
        System.out.println("  │  1. Add Student             │");
        System.out.println("  │  2. View Students           │");
        System.out.println("  │  3. Show Report             │");
        System.out.println("  │  4. Exit                    │");
        System.out.println("  └─────────────────────────────┘");
        System.out.print("  Enter your choice (1-4) : ");
    }


    // ============================================================
    //  METHOD : readMenuChoice()
    //  Reads an integer menu choice; handles non-numeric input
    //  gracefully so the program never crashes on bad input.
    //  @return  integer choice entered by the user
    // ============================================================
    private static int readMenuChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            // If the user types letters, return -1 (falls to default case)
        }
        return choice;
    }

    private static void addStudent() {

        System.out.println("\n  ── Add New Student ─────────────────");

        // ── Validate Name ────────────────────────────────────
        String name = "";
        while (name.isEmpty()) {
            System.out.print("  Enter Student Name  : ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("  [!] Name cannot be empty. Please try again.");
            }
        }

        // ── Validate Marks ───────────────────────────────────
        double marks = -1;
        boolean validMarks = false;

        while (!validMarks) {
            System.out.print("  Enter Marks (0-100) : ");
            String marksInput = scanner.nextLine().trim();

            try {
                marks = Double.parseDouble(marksInput);

                // Check the numeric range constraint
                if (marks < 0 || marks > 100) {
                    System.out.println("  [!] Marks must be between 0 and 100. Please try again.");
                } else {
                    validMarks = true;   // Input is valid; exit the loop
                }
            } catch (NumberFormatException e) {
                // User entered non-numeric text
                System.out.println("  [!] Invalid input. Please enter a numeric value.");
            }
        }

        // ── Create the Student object and add to ArrayList ───
        Student newStudent = new Student(name, marks);
        studentList.add(newStudent);

        System.out.println("    Student \"" + name + "\" added successfully!");
        System.out.println("  ────────────────────────────────────");
    }


    // ============================================================
    //  METHOD : displayStudents()
    //  Displays all students currently stored in the ArrayList
    //  in a neat tabular format.
    //  If no students exist, a helpful message is shown instead.
    // ============================================================
    private static void displayStudents() {

        System.out.println("\n  ── All Students ────────────────────");

        // Guard clause – nothing to show if the list is empty
        if (studentList.isEmpty()) {
            System.out.println("  No student records found.");
            System.out.println("  Please add students first (Option 1).");
            System.out.println("  ────────────────────────────────────");
            return;
        }

        System.out.println("  --------------------------------");
        System.out.printf("  %-5s  %-20s  %6s%n", "S.No", "Student Name", "Marks");
        System.out.println("  --------------------------------");

        // Loop through the ArrayList and print each student record
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);


            System.out.printf("  %-5d  %-20s  %6.2f%n",
                    (i + 1),
                    s.getStudentName(),
                    s.getStudentMarks());
        }

        System.out.println("  --------------------------------");
        System.out.println("  Total Students : " + studentList.size());
        System.out.println("  ────────────────────────────────────");
    }

    private static double calculateAverage() {

        if (studentList.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Student s : studentList) {
            total += s.getStudentMarks();
        }

        return total / studentList.size();
    }


    private static double findHighestMarks() {

        if (studentList.isEmpty()) {
            return 0.0;
        }

        double highest = studentList.get(0).getStudentMarks();

        for (int i = 1; i < studentList.size(); i++) {
            double currentMarks = studentList.get(i).getStudentMarks();

            if (currentMarks > highest) {
                highest = currentMarks;
            }
        }

        return highest;
    }



    private static double findLowestMarks() {

        if (studentList.isEmpty()) {
            return 0.0;
        }

        double lowest = studentList.get(0).getStudentMarks();

        for (int i = 1; i < studentList.size(); i++) {
            double currentMarks = studentList.get(i).getStudentMarks();

            if (currentMarks < lowest) {
                lowest = currentMarks;
            }
        }

        return lowest;
    }


    private static void displayReport() {

        System.out.println("\n  ── Summary Report ──────────────────");

        if (studentList.isEmpty()) {
            System.out.println("  No data available. Please add students first.");
            System.out.println("  ────────────────────────────────────");
            return;
        }


        System.out.println();
        System.out.println("  ================================");
        System.out.printf("  %-22s  %s%n","Student Name", "Marks");
        System.out.println("  ================================");


        for (Student s : studentList) {
            System.out.printf("  %-22s  %.2f%n",
                    s.getStudentName(),
                    s.getStudentMarks());
        }

        System.out.println("  ================================");

        double average = calculateAverage();
        double highest = findHighestMarks();
        double lowest  = findLowestMarks();

        System.out.printf("  Highest Marks : %.2f%n", highest);
        System.out.printf("  Average Marks : %.2f%n", average);
        System.out.printf("  Lowest  Marks : %.2f%n", lowest);

        System.out.println("  ================================");


        System.out.print("  Class Performance : ");
        if (average >= 90) {
            System.out.println("Outstanding  ");
        } else if (average >= 75) {
            System.out.println("Excellent    ");
        } else if (average >= 60) {
            System.out.println("Good         ");
        } else if (average >= 40) {
            System.out.println("Average      ");
        } else {
            System.out.println("Needs Improvement ");
        }

        System.out.println("  ────────────────────────────────────");
    }

}