package lab01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private int inputID(){
        System.out.print("Input student ID: ");
        while (true) {
            try {
                int id = sc.nextInt();
                return id;
            } catch (Exception ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }
    private String inputName() {
        System.out.print("Input student name: ");
        return sc.nextLine();
    }
    private int inputBirth() {
        System.out.print("Input student dateOfBirth: ");
        while (true) {
            try {
                int birth = sc.nextInt();
                if (birth < 0 && birth > 100) {
                    throw new NumberFormatException();
                }
                return birth;
            } catch (Exception ex) {
                System.out.print("Invalid! Input student ID again: ");
            }
        }
    }
    private String inputAddress(){
        System.out.print("Input student address: ");
        return sc.nextLine();
    }
    private float inputGpa(){
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
    public void addStudent(int id){
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
            System.out.printf("Updated success!\n", id);
        }
    }

    public void deleteStudent(int id) {
        SinhVien sv = null;
        for (int i = 0; i < svList.size(); i++) {
            if (svList.get(i).getId() == id) {
                sv = svList.get(i);
                return;
            }
        }
        if (sv != null) {
            svList.remove(sv);
        } else {
            System.out.printf("ID = %d not existed.\n", id);
        }
    }

    public class sortByGpa implements Comparator<SinhVien>{
        @Override
        public int compare(SinhVien student1, SinhVien student2) {
            if (student1.getGpa() > student2.getGpa()) {
                return 1;
            }
            return -1;
        }
    }
    public void SortByGpa(){
        Collections.sort(svList, new sortByGpa());
        System.out.println("Sort students by gpa successfully!\n");
    }

    public void sortByName(){
        Collections.sort(svList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien student1, SinhVien student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
        System.out.println("Sort students by name successfully!\n");
    }

    public void showStudent() {
        for (SinhVien student : svList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%15s | ", student.getName());
            System.out.format("%5d | ", student.getDateOfBirth());
            System.out.format("%15s | ", student.getAddress());
            System.out.format("%5.1f%n", student.getGpa());
        }
    }


}


