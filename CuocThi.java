import java.util.*;

public class CuocThi {
    public ArrayList<Chi_Dep> dsChiDep;
    public ArrayList<VongThi> VongThi;
    public String tenCuocThi;
    public int namToChuc;

    public CuocThi(ArrayList<Chi_Dep> dsChiDep, ArrayList<VongThi> vongThi, String tenCuocThi, int namToChuc) {
        this.dsChiDep = dsChiDep;
        VongThi = vongThi;
        this.tenCuocThi = tenCuocThi;
        this.namToChuc = namToChuc;
    }

    public ArrayList<Chi_Dep> getDsChiDep() {
        return dsChiDep;
    }

    public void setDsChiDep(ArrayList<Chi_Dep> dsChiDep) {
        this.dsChiDep = dsChiDep;
    }

    public ArrayList<VongThi> getVongThi() {
        return VongThi;
    }

    public void setVongThi(ArrayList<VongThi> vongThi) {
        VongThi = vongThi;
    }

    public String getTenCuocThi() {
        return tenCuocThi;
    }

    public void setTenCuocThi(String tenCuocThi) {
        this.tenCuocThi = tenCuocThi;
    }

    public int getNamToChuc() {
        return namToChuc;
    }

    public void setNamToChuc(int namToChuc) {
        this.namToChuc = namToChuc;
    }
    public HashMap<Chi_Dep, LinkedList<Integer>> thongKeChiDep_danhSachDiemSo() {
        HashMap<Chi_Dep, LinkedList<Integer>> result = new HashMap<>();

        for (VongThi vongThi : VongThi) {
            for (NhomTrinhDien nhomTrinhDien : vongThi.getDsNhomTrinhDien()) {
                for (Chi_Dep chiDep : nhomTrinhDien.getDsThanhVien()) {
                    // Assuming getDiemTVNhom method exists in VongThi class
                    int diem = vongThi.getDiemTVNhom(nhomTrinhDien).get(chiDep);

                    // If the Chi_Dep is not in the result map, add it
                    result.putIfAbsent(chiDep, new LinkedList<>());

                    // Add the diem to the list for the Chi_Dep
                    result.get(chiDep).add(diem);
                }
            }
        }

        return result;
    }
    private int layDiemVongThi(Chi_Dep chiDep,VongThi vongThi) {

        return chiDep.getDiemVongThi();
    }
    public TreeSet<Chi_Dep> getSetChiDepVongThi(VongThi v) {
        TreeSet<Chi_Dep> setChiDep = new TreeSet<>(new Comparator<Chi_Dep>() {
            @Override
            public int compare(Chi_Dep chiDep1, Chi_Dep chiDep2) {

                int diem1 = layDiemVongThi(chiDep1, v);

                int diem2 = layDiemVongThi(chiDep2, v);


                return Integer.compare(diem2, diem1);
            }
        });

        setChiDep.addAll(dsChiDep);

        return setChiDep;
    }
    public HashMap<VongThi, Integer> thongKeChiDepBiLoai() {
        HashMap<VongThi, Integer> result = new HashMap<>();

        for (VongThi vongThi : VongThi) {
            int countBiLoai = 0;

            for (NhomTrinhDien nhomTrinhDien : vongThi.getDsNhomTrinhDien()) {
                for (Chi_Dep chiDep : nhomTrinhDien.getDsThanhVien()) {
                    if (chiDep.isBiLoai()) {
                        countBiLoai++;
                    }
                }
            }

            result.put(vongThi, countBiLoai);
        }

        return result;
    }
    public TreeSet<Chi_Dep> getSetTongDiemChiDep() {
        TreeSet<Chi_Dep> chiDepTreeSet = new TreeSet<>((cd1, cd2) -> Integer.compare(
                cd2.getDiemQuaTrinh().stream().mapToInt(Integer::intValue).sum(),
                cd1.getDiemQuaTrinh().stream().mapToInt(Integer::intValue).sum()));

        chiDepTreeSet.addAll(dsChiDep);
        return chiDepTreeSet;
    }
    public List<Chi_Dep> loaiChiDep(VongThi vongThi, int sig) {
        List<Chi_Dep> eliminatedChiDepList = new ArrayList<>();
        if (sig <= 0) {
            System.out.println("Invalid number of eliminated Chi_Dep.");
            return eliminatedChiDepList;
        }
        TreeSet<Chi_Dep> chiDepTreeSet = getSetChiDepVongThi(vongThi);
        for (int i = 0; i < sig && !chiDepTreeSet.isEmpty(); i++) {
            Chi_Dep eliminatedChiDep = chiDepTreeSet.pollLast();
            eliminatedChiDep.setBiLoai(true);
            eliminatedChiDep.setTenVongBiLoai(vongThi.getTenVong());
            eliminatedChiDepList.add(eliminatedChiDep);
        }
        return eliminatedChiDepList;
    }
    public TreeSet<NhomTrinhDien> sortNhomDiemSo0() {
        TreeSet<NhomTrinhDien> nhomDiemSo0TreeSet = new TreeSet<>(new NhomDiemSo0Comparator());

        nhomDiemSo0TreeSet.addAll(getVongThi().get(0).getDsNhomTrinhDien());

        return nhomDiemSo0TreeSet;
    }


    private static class NhomDiemSo0Comparator implements Comparator<NhomTrinhDien> {
        @Override
        public int compare(NhomTrinhDien nhom1, NhomTrinhDien nhom2) {
            return Integer.compare(nhom2.getDiemNhom(), nhom1.getDiemNhom());
        }
    }

    public static void main(String[] args) {
        Chi_Dep chiDep1 = new Chi_Dep("1000","Viet1" , new TreeSet<>(),new LinkedList<>(),false,"Vong2");
        Chi_Dep chiDep2 = new Chi_Dep("1001","Viet2" , new TreeSet<>(),new LinkedList<>(),false,"Vong3");
        QuaTrinhLamNghe quaTrinh1 = new QuaTrinhLamNghe("NN1", "NgheNgiep1", 2010);
        QuaTrinhLamNghe quaTrinh2 = new QuaTrinhLamNghe("NN2", "NgheNgiep2", 2015);


        chiDep1.getNgheNgiepList().add(quaTrinh1);
        chiDep2.getNgheNgiepList().add(quaTrinh2);

        LinkedList<Integer> diemQuaTrinh1 = new LinkedList<>();
        diemQuaTrinh1.add(80);
        diemQuaTrinh1.add(85);
        chiDep1.setDiemQuaTrinh(diemQuaTrinh1);

        LinkedList<Integer> diemQuaTrinh2 = new LinkedList<>();
        diemQuaTrinh2.add(75);
        diemQuaTrinh2.add(90);
        chiDep2.setDiemQuaTrinh(diemQuaTrinh2);

        NhomTrinhDien nhom1 = new NhomTrinhDien("NhacTre", "BaiHat1", "BienDao1");
        nhom1.setNhomTruong(chiDep1);
        nhom1.themThanhVien(chiDep2);

        ArrayList<Chi_Dep> dsChiDep = new ArrayList<>();
        dsChiDep.add(chiDep1);
        dsChiDep.add(chiDep2);

        ArrayList<NhomTrinhDien> dsNhomTrinhDien = new ArrayList<>();
        dsNhomTrinhDien.add(nhom1);

        VongThi vongThi = new VongThi("VT1", "VongThi1", dsNhomTrinhDien, new CachTinhDiem(50, 50));

        ArrayList<VongThi> dsVongThi = new ArrayList<>();
        dsVongThi.add(vongThi);
        CuocThi cuocThi = new CuocThi(dsChiDep, dsVongThi, "CuocThi1", 2023);

        List<Chi_Dep> eliminatedChiDepList = cuocThi.loaiChiDep(vongThi, 1);

        System.out.println("Eliminated Chi_Dep:");
        for (Chi_Dep eliminatedChiDep : eliminatedChiDepList) {
            System.out.println(eliminatedChiDep);
        }


        TreeSet<NhomTrinhDien> sortedNhomTreeSet = cuocThi.sortNhomDiemSo0();

        System.out.println("Sorted NhomTrinhDien by DiemNhom for the first round:");
        for (NhomTrinhDien nhom : sortedNhomTreeSet) {
            System.out.println(nhom);
        }
    }

}
