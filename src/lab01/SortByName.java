package lab01;

import java.util.Comparator;


public class SortByName implements Comparator<SinhVien> {
    @Override
    public int compare(SinhVien student1, SinhVien student2) {
        return student1.getName().compareTo(student2.getName());
    }
}