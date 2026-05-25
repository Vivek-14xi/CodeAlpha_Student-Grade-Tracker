package StudentGradeTracker;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        UseStudent us = new UseStudent();

        System.out.println("   ┌────────────────────────────────┐");
        System.out.println("   │     STUDENT GRADE TRACKER      │");
        System.out.println("   └────────────────────────────────┘");
        int select=0;
        int choice=0;
        String name="";
        do {
            do {
               us.displayOption();
                boolean validChoice = false;

                while (!validChoice) {
                System.out.print("Select the Option (1-4) :- ");

                    try {
                        choice = kb.nextInt();
                        kb.nextLine();
                        validChoice = true;

                    } catch (InputMismatchException e) {

                        System.out.println("[!] Invalid input. Please enter a numeric value.");
                        kb.nextLine();
                    }
                }


//                System.out.println();
                switch (choice) {
                    case 1:
                        System.out.println("    ┌─────────────────────────────┐");
                        System.out.println("    |----Add New Student Data-----|");
                        System.out.println("    └─────────────────────────────┘");
                        int rollno = 0;
                        boolean validRollno = false;

                        while (!validRollno) {

                            System.out.print("Enter Roll No :- ");

                            try {

                                rollno = kb.nextInt();
                                kb.nextLine();
                                if(us.isRollNoExists(rollno)){

                                    System.out.println("[!] Roll Number already exists.");
                                }
                                else{

                                    validRollno = true;
                                }



                            } catch (InputMismatchException e) {

                                System.out.println("[!] Invalid input. Please enter a numeric value.");
                                kb.nextLine();
                            }
                        }

                        boolean validName=false;
                        while(!validName) {
                            System.out.print("Enter Name    :- ");
                            name = kb.nextLine();
                            if(name.matches("[a-zA-Z]+")){


                                validName=true;
                            }
                            else System.out.println("[!] Invalid input.");
                        }

                        double grade = 0;
                        boolean validGrade = false;

                        while (!validGrade) {

                            System.out.print("Enter Grade :- ");

                            try {

                                grade = kb.nextDouble();
                                kb.nextLine();

                                if (grade >= 0 && grade <= 100) {

                                    validGrade = true;

                                } else {

                                    System.out.println("[!] Grade must be between 0 and 100.");
                                }

                            } catch (InputMismatchException e) {

                                System.out.println("[!] Invalid input. Enter numeric value only.");
                                kb.nextLine();
                            }
                        }

                        us.addStudent(rollno, name, grade);


                        break;

                    case 2:
                        us.showStudent();
                        break;
                    case 3:

                      us.viewReport();

                        break;

                    case 4:
                        System.out.println("\nThank you for using Student Grade Tracker.");
                        break;
                    default:
                       us.invalidOption();

                }


            } while (choice != 4);
        }while (select==4);

kb.close();

    }


    }

