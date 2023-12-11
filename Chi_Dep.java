import java.util.LinkedList;
import java.util.TreeSet;

public class Chi_Dep  {
    private String id;
    private String hoTen;
    private TreeSet<QuaTrinhLamNghe> ngheNgiepList;
    private LinkedList<Integer> diemQuaTrinh;
    private boolean biLoai;
    private String tenVongBiLoai;

    public Chi_Dep(String id, String hoTen, TreeSet<QuaTrinhLamNghe> ngheNgiepList, LinkedList<Integer> diemQuaTrinh, boolean biLoai, String tenVongBiLoai) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngheNgiepList = ngheNgiepList;
        this.diemQuaTrinh = diemQuaTrinh;
        this.biLoai = biLoai;
        this.tenVongBiLoai = tenVongBiLoai;
    }
    public Chi_Dep(String id, String hoTen){
        this.id = id;
        this.hoTen = hoTen;
    }
    public void themDiemQT(int diem){
        diemQuaTrinh.add(diem);
    }
    public void setBiLoai(boolean biloai){
        this.biLoai = biloai;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public TreeSet<QuaTrinhLamNghe> getNgheNgiepList() {
        return ngheNgiepList;
    }

    public void setNgheNgiepList(TreeSet<QuaTrinhLamNghe> ngheNgiepList) {
        this.ngheNgiepList = ngheNgiepList;
    }
    public int getDiemVongThi(){
        int sum = 0;
        for (int a:
                diemQuaTrinh) {
            sum+=a;
        }
        return sum;
    }

    public LinkedList<Integer> getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(LinkedList<Integer> diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public boolean isBiLoai() {
        return biLoai;
    }

    public String getTenVongBiLoai() {
        return tenVongBiLoai;
    }

    public void setTenVongBiLoai(String tenVongBiLoai) {
        this.tenVongBiLoai = tenVongBiLoai;
    }
    public void themDiemQuaTrinh(int diem){
        diemQuaTrinh.add(diem);
    }

    @Override
    public String toString() {
        return "Chi_Dep{" +
                "id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngheNgiepList=" + ngheNgiepList +
                ", diemQuaTrinh=" + diemQuaTrinh +
                ", biLoai=" + biLoai +
                ", tenVongBiLoai='" + tenVongBiLoai + '\'' +
                '}';
    }


    public static void main(String[] args) {
        QuaTrinhLamNghe nghe1 = new QuaTrinhLamNghe("100","Ca Si",2019);
        QuaTrinhLamNghe nghe2 = new QuaTrinhLamNghe("101","Dien Vien",2015);
        QuaTrinhLamNghe nghe3 = new QuaTrinhLamNghe("102","Nails",2013);
        QuaTrinhLamNghe nghe4 = new QuaTrinhLamNghe("103","Coder",2011);
        Chi_Dep chidep1 = new Chi_Dep("1000","Viet1" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep chidep2 = new Chi_Dep("1001","Viet2" , new TreeSet<>(),new LinkedList<>(),false,"Vong3");
       // TreeSet Nghe 1
        TreeSet<QuaTrinhLamNghe> dachsachnghe1 = new TreeSet<>();
        dachsachnghe1.add(nghe1);
        dachsachnghe1.add(nghe2);
        // TreeSet Mghe 2
        TreeSet<QuaTrinhLamNghe> dachsachnghe2 = new TreeSet<>();
        dachsachnghe2.add(nghe3);
        dachsachnghe2.add(nghe4);
        // Diem Qua Trinh Nghe 1
        LinkedList<Integer> diemQuaTrinh1 = new LinkedList<>();
        diemQuaTrinh1.add(50);
        diemQuaTrinh1.add(100);
        // Diem Qua Trinh Nghe 2
        LinkedList<Integer> diemQuaTrinh2 = new LinkedList<>();
        diemQuaTrinh2.add(100);
        diemQuaTrinh2.add(30);
        // Chi dep 1
        chidep1.setNgheNgiepList(dachsachnghe1);
        chidep1.setDiemQuaTrinh(diemQuaTrinh1);
        // Chi dep 2
        chidep2.setNgheNgiepList(dachsachnghe2);
        chidep2.setDiemQuaTrinh(diemQuaTrinh2);
        System.out.println("Test Chi Dep 1");
        System.out.println(chidep1.toString());
        System.out.println("Test Chi Dep 2");
        System.out.println(chidep2.toString());
        // Them diem qua trinh cho chi dep 2
        chidep2.themDiemQuaTrinh(200);
        // Test lai chi dep 2 khi da them diem qua trinh
        System.out.println("Test Chi Dep 2");
        System.out.println(chidep2.toString());
    }
}
