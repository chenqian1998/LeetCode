package JVM.OOM;

import java.util.ArrayList;
import java.util.List;

public class BasicDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 100000; i++) {
                list.add(String.valueOf(i).intern());
                i+=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
