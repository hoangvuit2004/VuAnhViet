import java.util.*;

public class QuaTrinhLamNghe implements Comparable<QuaTrinhLamNghe> {
    private String maNN;
    private String tenNN;
    private int namBD;

    public QuaTrinhLamNghe(String maNN, String tenNN, int namBD) {
        this.maNN = maNN;
        this.tenNN = tenNN;
        this.namBD = namBD;
    }
    public int getNamLamNghe(){
        return namBD;
    }

    public String getMaNN() {
        return maNN;
    }

    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public int getNamBD() {
        return namBD;
    }

    public void setNamBD(int namBD) {
        this.namBD = namBD;
    }
    public void print(){
        System.out.println("Mã ngành nghề: " + this.maNN + "\nTên ngành nghề: " + this.tenNN + "\nNăm bắt đầu: " + this.namBD);
    }

    @Override
    public String toString() {
        return "QuaTrinhLamNghe{" +
                "maNN='" + maNN + '\'' +
                ", tenNN='" + tenNN + '\'' +
                ", namBD=" + namBD +
                '}';
    }
    @Override
    public int compareTo(QuaTrinhLamNghe o) {
        return Integer.compare( this.namBD, o.namBD);
    }
    public static void main(String[] args) {

        QuaTrinhLamNghe nghe1 = new QuaTrinhLamNghe("100","Ca Si",2019);
        QuaTrinhLamNghe nghe2 = new QuaTrinhLamNghe("101","Dien Vien",2015);
        // Test sap xep
        ArrayList<QuaTrinhLamNghe> a1 = new ArrayList<>();
        a1.add(nghe1);
        a1.add(nghe2);
        Collections.sort(a1);
        System.out.println(a1);
        // Test constructor
        nghe1.print();
        // Test get
        System.out.println("Test phuong thuc get: \n" +  nghe1.getMaNN() + "\n" + nghe1.getTenNN() + "\n" + nghe1.getNamBD());
        // Test set
        nghe1.setMaNN("1000");
        nghe1.setTenNN("Dien Vien Hai");
        nghe1.setNamBD(2004);
        System.out.println("Test phuong thuc set: \n" +  nghe1.getMaNN() + "\n" + nghe1.getTenNN() + "\n" + nghe1.getNamBD());

    }
}
