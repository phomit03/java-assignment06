package lab01;

import java.util.Comparator;

public class SortByGpa implements Comparator<SinhVien>{
    @Override
    public int compare(SinhVien student1, SinhVien student2) {
        if (student1.getGpa() > student2.getGpa()) {
            return 1;
        }
        return -1;
    }
}

