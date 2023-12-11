import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class NhomTrinhDien {
    private String loaiNhom;
    private String tenBaiHat;
    private String tenBienDao;
    private int diemNhom;
    private Chi_Dep nhomTruong;
    private LinkedList<Chi_Dep> dsThanhVien;
    private HashMap<Chi_Dep,Integer> phieuBauThanhVien;
    private String trangThaiNhom;
    public NhomTrinhDien(String loaiNhom, String tenBaiHat, String tenBienDao){
        this.loaiNhom = loaiNhom;
        this.tenBaiHat = tenBaiHat;
        this.tenBienDao = tenBienDao;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public int getDiemNhom() {
        return diemNhom;
    }

    public void setDiemNhom(int diemNhom) {
        this.diemNhom = diemNhom;
    }

    public Chi_Dep getNhomTruong() {
        return nhomTruong;
    }

    public void setNhomTruong(Chi_Dep nhomTruong) {
        this.nhomTruong = nhomTruong;
        themThanhVien(nhomTruong);
    }

    public LinkedList<Chi_Dep> getDsThanhVien() {
        return dsThanhVien;
    }

    public void setDsThanhVien(LinkedList<Chi_Dep> dsThanhVien) {
        this.dsThanhVien = dsThanhVien;
    }

    public HashMap<Chi_Dep, Integer> getPhieuBauThanhVien() {
        return phieuBauThanhVien;
    }

    public void setPhieuBauThanhVien(HashMap<Chi_Dep, Integer> phieuBauThanhVien) {
        this.phieuBauThanhVien = phieuBauThanhVien;
    }

    public String getTrangThaiNhom() {
        return trangThaiNhom;
    }

    public void setTrangThaiNhom(String trangThaiNhom) {
        this.trangThaiNhom = trangThaiNhom;
    }
    public void themThanhVien(Chi_Dep thanhvien){
        dsThanhVien.add(thanhvien);
    }
     public void loaiThanhVien(int slg){
         if (dsThanhVien != null && dsThanhVien.size() > slg) {
             for (int i = 0; i < slg; i++) {
                 dsThanhVien.removeFirst();
             }
         } else {
             System.out.println("Không đủ thành viên để loại bỏ.");
         }
     }
public int sumNumber(){
        int count = 0;
    for (Chi_Dep s:
         dsThanhVien) {
        count++;
    }
    return count;
}

    public void setPhieuBauTV(Chi_Dep cd, int soLuongPhieu) {
        if (phieuBauThanhVien == null) {
            phieuBauThanhVien = new HashMap<>();
        }
        phieuBauThanhVien.put(cd, soLuongPhieu);
    }


    @Override
    public String toString() {
        return "NhomTrinhDien{" +
                "\nloaiNhom='" + loaiNhom + '\'' +
                ", \ntenBaiHat='" + tenBaiHat + '\'' +
                ", \ntenBienDao='" + tenBienDao + '\'' +
                ", \ndiemNhom=" + diemNhom +
                ", \nnhomTruong=" + nhomTruong +
                ",\ndsThanhVien=" + dsThanhVien +
                ", \nphieuBauThanhVien=" + phieuBauThanhVien +
                ", \ntrangThaiNhom='" + trangThaiNhom + '\'' +
                '}';
    }
    public void getPhieuBau(Chi_Dep thanhVien){
        if (phieuBauThanhVien != null && phieuBauThanhVien.containsKey(thanhVien)) {
            int soLuongPhieu = phieuBauThanhVien.get(thanhVien);
            System.out.println("Phiếu bầu của thành viên " + thanhVien.getHoTen() + ": " + soLuongPhieu);
        } else {
            System.out.println("Không có phiếu bầu cho thành viên " + thanhVien.getHoTen());
        }
    }


    public static void main(String[] args) {
// NhomTrinhDien
        NhomTrinhDien nhom1 = new NhomTrinhDien("Trinh Dien","Em cua ngay hom qua","BlackWhite");
        NhomTrinhDien nhom2 = new NhomTrinhDien("Vu Dao","Con mua ngang qua","BlackBlue");
        NhomTrinhDien nhom3 = new NhomTrinhDien("Dancer","Am tham ben em","BlackRed");
// Danh sach thanh vien
        Chi_Dep thanhVien1 = new Chi_Dep("1000","Viet1" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep thanhVien2 = new Chi_Dep("1001","Viet2" , new TreeSet<>(),new LinkedList<>(),false,"Vong3");
        Chi_Dep thanhVien3 = new Chi_Dep("1002","Viet3" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep thanhVien4 = new Chi_Dep("1003","Viet4" , new TreeSet<>(),new LinkedList<>(),false,"Vong3");
        Chi_Dep thanhVien5 = new Chi_Dep("1004","Viet5" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep thanhVien6 = new Chi_Dep("1005","Viet6" , new TreeSet<>(),new LinkedList<>(),false,"Vong1");
        Chi_Dep thanhVien7 = new Chi_Dep("1006","Viet7" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep thanhVien8 = new Chi_Dep("1007","Viet8" , new TreeSet<>(),new LinkedList<>(),false,"Vong3");
        // Them Thanh vien
        LinkedList<Chi_Dep> dsThanhVien1 = new LinkedList<>();
        dsThanhVien1.add(thanhVien1);
        dsThanhVien1.add(thanhVien2);
        dsThanhVien1.add(thanhVien3);

        nhom1.setDsThanhVien(dsThanhVien1);
        nhom1.setNhomTruong(thanhVien1);
        System.out.println(nhom1.toString());
        // Test nhom 2
        LinkedList<Chi_Dep> dsThanhVien2 = new LinkedList<>();
        dsThanhVien2.add(thanhVien4);
        dsThanhVien2.add(thanhVien5);
        dsThanhVien2.add(thanhVien6);
        nhom2.setDsThanhVien(dsThanhVien2);
        nhom2.setNhomTruong(thanhVien4);
        System.out.println(nhom2.toString());
    // Test method them thanh vien
        nhom1.themThanhVien(thanhVien5);
        System.out.println("Khi da them mot thanh vien: ");
        System.out.println(nhom1.toString());
        // Test method loaiThanhVien
        int slg = 2;
        System.out.println("So luong thanh vien ban dau: " + nhom1.sumNumber());
      nhom1.loaiThanhVien(slg);
        System.out.println("So luong thanh vien khi da loai: " + nhom1.sumNumber());
        // Test setPhieuBauTV
        nhom1.setPhieuBauTV(thanhVien1,60);
        nhom1.getPhieuBau(thanhVien1);
        // Test getPhieuBau
        HashMap<Chi_Dep,Integer> phieubau1 = new HashMap<>();
        phieubau1.put(thanhVien1,50);
        nhom1.setPhieuBauThanhVien(phieubau1);
        System.out.println("Danh sách Phiếu Bầu Thành Viên:");
        nhom1.getPhieuBau(thanhVien1);
    }
}
