package lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        Scanner sc = new Scanner(System.in);
        int x;
        int studentID;

        while (true) {
            System.out.println("\n-----------Menu------------");
            System.out.println("Choose the function you want:");
            System.out.println("1. Add student");
            System.out.println("2. Edit student by ID");
            System.out.println("3. Delete student by ID");
            System.out.println("4. Sort students by gpa");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show student list");
            System.out.println("0. Exit");
            System.out.println("---------------------------");
            do {
                System.out.print("Please choose: ");
                x = sc.nextInt();
            } while (x < 0 || x > 6); {
                switch (x) {
                    case 1: {
                        try {
                            qlsv.addStudent();
                        } catch (Exception e) {
                            System.out.println("Date of birth input error");
                        }
                        break;
                    }
                    case 2: {
                        studentID = qlsv.inputID();
                        qlsv.editStudent(studentID);
                        break;
                    }
                    case 3: {
                        studentID = qlsv.inputID();
                        qlsv.deleteStudent(studentID);
                        break;
                    }
                    case 4: {
                        qlsv.sortByGpa();
                        break;
                    }
                    case 5: {
                        qlsv.sortByName();
                        break;
                    }
                    case 6: {
                        qlsv.showStudent();
                        break;
                    }
                    case 0: {
                        System.out.println("Progress stopped");
                        return;
                    }

                }
            }
        }



    }
}

