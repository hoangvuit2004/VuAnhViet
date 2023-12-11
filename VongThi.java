import java.util.*;

public class VongThi {
    private String idTV;
    private String tenVong;
    private ArrayList<NhomTrinhDien> dsNhomTrinhDien;
    private CachTinhDiem cachTinhDiemChiDep;

    public VongThi(String idTV, String tenVong, ArrayList<NhomTrinhDien> dsNhomTrinhDien, CachTinhDiem cachTinhDiemChiDep) {
        this.idTV = idTV;
        this.tenVong = tenVong;
        this.dsNhomTrinhDien = dsNhomTrinhDien;
        this.cachTinhDiemChiDep = cachTinhDiemChiDep;
    }
    public void themThanhVien(Chi_Dep cd){
       if(dsNhomTrinhDien != null){
           for (NhomTrinhDien s:
                dsNhomTrinhDien) {
               if(!s.getDsThanhVien().contains(cd)){
                   s.themThanhVien(cd);
               }else{
                   System.out.println("Thành viên đã tồn tại trong nhóm.");
               }
           }

       }else{
           System.out.println("Danh sách nhóm trình diễn không tồn tại.");
       }
    }

    public void loaiThanhVien(int slg){
        if (dsNhomTrinhDien != null) {
            for (NhomTrinhDien nhom : dsNhomTrinhDien) {
                nhom.loaiThanhVien(slg);
            }
        }
    }

    public String getIdTV() {
        return idTV;
    }

    public String getTenVong() {
        return tenVong;
    }

    public CachTinhDiem getCachTinhDiemChiDep() {
        return cachTinhDiemChiDep;
    }

    public HashMap<Chi_Dep, Integer> getDiemTVNhom(NhomTrinhDien n) {
        HashMap<Chi_Dep, Integer> diemTVNhom = new HashMap<>();

        if (dsNhomTrinhDien.contains(n)) {
            // Lấy tỉ lệ từ cách tính điểm
            double phanTramDiemBGK = cachTinhDiemChiDep.getPhamTramDiemBGK();
            double phanTramDiemPB = cachTinhDiemChiDep.getPhanTramDiemPB();


            int diemBGK = n.getDiemNhom();


            LinkedList<Chi_Dep> dsThanhVien = n.getDsThanhVien();


            int soLuongThanhVien = dsThanhVien.size();


            for (Chi_Dep thanhVien : dsThanhVien) {

                int diemPB = (int) (thanhVien.getDiemQuaTrinh().stream().mapToInt(Integer::intValue).sum() * phanTramDiemPB / 100.0);


                int diemTong = (int) (diemBGK * phanTramDiemBGK / 100.0) + diemPB;


                diemTVNhom.put(thanhVien, diemTong);
            }
        } else {
            System.out.println("Nhóm không tồn tại trong vòng thi.");
        }

        return diemTVNhom;
    }

    public ArrayList<NhomTrinhDien> getDsNhomTrinhDien() {
        return dsNhomTrinhDien;
    }

    public void setDsNhomTrinhDien(ArrayList<NhomTrinhDien> dsNhomTrinhDien) {
        this.dsNhomTrinhDien = dsNhomTrinhDien;
    }

    @Override
    public String toString() {
        return "VongThi{" +
                "\nidTV='" + idTV + '\'' +
                ", \ntenVong='" + tenVong + '\'' +
                ", \ndsNhomTrinhDien=" + dsNhomTrinhDien +
                ", \ncachTinhDiemChiDep=" + cachTinhDiemChiDep +
                '}';
    }
    public void loaiChiDep(int sigNhom, int sigTvNhom) {

        if (sigNhom <= 0 || sigNhom > dsNhomTrinhDien.size()) {
            System.out.println("Invalid number of dangerous groups.");
            return;
        }


        Collections.sort(dsNhomTrinhDien, (n1, n2) -> Integer.compare(n1.getDiemNhom(), n2.getDiemNhom()));


        for (int i = 0; i < sigNhom; i++) {
            NhomTrinhDien dangerousGroup = dsNhomTrinhDien.get(i);


            if (sigTvNhom <= 0 || sigTvNhom > dangerousGroup.sumNumber()) {
                System.out.println("Invalid number of eliminated members for dangerous group " + dangerousGroup.getTenBaiHat() + ".");
                continue;
            }


            Collections.sort(dangerousGroup.getDsThanhVien(), (cd1, cd2) -> Integer.compare(cd1.getDiemQuaTrinh().stream().mapToInt(Integer::intValue).sum(),
                    cd2.getDiemQuaTrinh().stream().mapToInt(Integer::intValue).sum()));


            for (int j = 0; j < sigTvNhom; j++) {
                Chi_Dep eliminatedMember = dangerousGroup.getDsThanhVien().pollFirst();
                System.out.println("Eliminating " + eliminatedMember.getHoTen() + " from dangerous group " + dangerousGroup.getTenBaiHat());
            }
        }
    }
    public static void main(String[] args) {
        // Test them thanh vien
       // Chi_Dep chidep1 = new Chi_Dep("1000","Viet1" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
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
        // Test them thanh vien vao dsNhomTrinhDien
    ArrayList<NhomTrinhDien> dsNhomTrinhDien = new ArrayList<>();
    dsNhomTrinhDien.add(nhom1);
    dsNhomTrinhDien.add(nhom2);
        Chi_Dep thanhVienNew = new Chi_Dep("1111","Viet9" , new TreeSet<>(),new LinkedList<>(),false,"Vong4");
        CachTinhDiem cachTinhDiem = new CachTinhDiem(0.6, 0.4);
        VongThi vongthi1 = new VongThi("200","Vong Chung Ket",dsNhomTrinhDien,cachTinhDiem);
        System.out.println("Truoc khi them thanh vien vao nhom: ");
        System.out.println(vongthi1.toString());
        System.out.println("Sau khi da them thanh vien vao nhom: ");
        vongthi1.themThanhVien(thanhVienNew);
        System.out.println(vongthi1.toString());
        // TEst loaiThanhVien
        System.out.println("Trước khi loại thành viên:");
        System.out.println(vongthi1.toString());
        int slgLoai = 1;
        vongthi1.loaiThanhVien(slgLoai);
        System.out.println("Sau khi loại thành viên:");
        System.out.println(vongthi1.toString());

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
        // Test getDiemTVNhom
       // Chi_Dep participant1 = new Chi_Dep("1001", "Participant 1", new TreeSet<>(), new LinkedList<>(), false, "Vong2");
       // Chi_Dep participant2 = new Chi_Dep("1002", "Participant 2", new TreeSet<>(), new LinkedList<>(), false, "Vong3");

        // Create NhomTrinhDien instance
        NhomTrinhDien performanceGroup = new NhomTrinhDien("Trinh Dien", "Em cua ngay hom qua", "BlackWhite");

        performanceGroup.setDiemNhom(80); // Set a hypothetical group score
       performanceGroup.setPhieuBauTV(chidep1,800);
        performanceGroup.setPhieuBauTV(chidep2,300);
        // Add participants to the performance group
        LinkedList<Chi_Dep> dsThanhVien = new LinkedList<>();
        dsThanhVien.add(chidep1);
        dsThanhVien.add(chidep2);
        performanceGroup.setDsThanhVien(dsThanhVien);
        System.out.println("Test");
       System.out.println(performanceGroup.toString());
        // Create VongThi instance
       CachTinhDiem cachTinhDiem1 = new CachTinhDiem(0.6, 0.4);
        VongThi vongThi = new VongThi("200", "Vong Chung Ket", new ArrayList<>(), cachTinhDiem);
        vongThi.getDsNhomTrinhDien().add(performanceGroup);

        // Test the getDiemTVNhom method
        HashMap<Chi_Dep, Integer> diemTVNhom = vongThi.getDiemTVNhom(performanceGroup);


        System.out.println("Diem Tong for each participant in the performance group:");
        for (Map.Entry<Chi_Dep, Integer> entry : diemTVNhom.entrySet()) {
            Chi_Dep participant = entry.getKey();
            int totalScore = entry.getValue();
            System.out.println(participant.getHoTen() + ": " + totalScore);
        }
        System.out.println("Before loaiChiDep:");
        System.out.println(vongthi1.toString());

        // Assume sigNhom is 3 and sigTvNhom is 2 for testing purposes
        int sigNhom = 3;
        int sigTvNhom = 2;

        // Call the loaiChiDep method
        vongthi1.loaiChiDep(sigNhom, sigTvNhom);

        System.out.println("After loaiChiDep:");
        System.out.println(vongthi1.toString());
    }
}
