package timhieuthrows;

import java.io.IOException;

public class ThrowsClass {
     public void m() throws IOException {
        throw new IOException("Loi thiet bi");// checked exception
    }

     void n() throws IOException {
         m();
        throw new IOException("Loi mang");
    }

    public void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("ngoai le duoc xu ly");
            System.out.println(e);
        }
    }
}
