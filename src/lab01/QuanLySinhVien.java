package lab01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien extends SinhVien{
    private ArrayList<SinhVien> svList = new ArrayList<SinhVien>();
    Scanner sc = new Scanner(System.in);

    //getter & setter
    public ArrayList<SinhVien> getSvList() {
        return svList;
    }

    public void setSvList(ArrayList<SinhVien> svList) {
        this.svList = svList;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }


    //input
    public int inputID(){
        System.out.print("Input student ID: ");
        while (true) {
            try {
                int id = sc.nextInt();
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }
    public String inputName() {
        System.out.print("Input student name: ");
        return sc.nextLine();
    }
    public int inputBirth() {
        System.out.print("Input student dateOfBirth: ");
        while (true) {
            try {
                int birth = sc.nextInt();
                if (birth < 0 && birth > 150) {  //ít hơn 150 tuổi cho đỡ tài nguyên :v
                    throw new NumberFormatException();
                }
                return birth;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }
    public String inputAddress(){
        System.out.print("Input student address: ");
        sc.nextLine();
        return sc.nextLine();
    }
    public float inputGpa(){
        System.out.print("Input student medium score: ");
        while (true) {
            try {
                float gpa = sc.nextFloat();
                if (gpa < 0.0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (Exception ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }


    //phương thức
    public void addStudent(){
        int id;
        if(svList.size() > 0){
            id = svList.size() + 1;
        } else{
            id = 1;
        }
        System.out.println("Studen ID: " + id);
        String name = inputName();
        int birth = inputBirth();
        String address = inputAddress();
        float gpa = inputGpa();

        SinhVien sv = new SinhVien(id, name, birth, address, gpa);
        svList.add(sv);
    }

    public void editStudent(int id){
        boolean isExisted = false;
        for (int i = 0; i < svList.size(); i++) {
            if (svList.get(i).getId() == id) {
                isExisted = true;
                svList.get(i).setName(inputName());
                svList.get(i).setDateOfBirth(inputBirth());
                svList.get(i).setAddress(inputAddress());
                svList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("ID = %d not existed.\n", id);
        } else {
            System.out.printf("\nUpdated success ID = %d!\n", id);
        }
    }

    public void deleteStudent(int id) {
        SinhVien sv = null;
        for (int i = 0; i < svList.size(); i++) {
            if (svList.get(i).getId() == id) {
                sv = svList.get(i);
                break;
            }
        }
        if (sv != null) {
            svList.remove(sv);
            System.out.printf("\nDeleted success ID = %d!\n", id);
        } else {
            System.out.printf("ID = %d not existed.\n", id);
        }
    }

    public void sortByGpa(){
        Collections.sort(svList, new SortByGpa());
        System.out.println("Sort students by gpa successfully!\n");
    }

    public void sortByName(){
        Collections.sort(svList, new SortByName());
        System.out.println("Sort students by name successfully!\n");
    }

    public void showStudent() {
        if (svList.size()==0) System.out.println("List is empty");
        else{
            System.out.println("|   ID |    Student's name    |  Date of birth  |      Address      |  GPA  |");
            for (SinhVien student : svList) {
                System.out.format("| %4d | %20s | %15d | %17s | %5.2f |\n",student.getId(),student.getName(),student.getDateOfBirth(),student.getAddress(),student.getGpa());
            }
        }
    }


}


