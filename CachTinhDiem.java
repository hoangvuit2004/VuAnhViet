public class CachTinhDiem {
    public double phamTramDiemBGK;
    public double phanTramDiemPB;

    public CachTinhDiem(double phamTramDiemBGK, double phanTramDiemPB) {
        this.phamTramDiemBGK = phamTramDiemBGK;
        this.phanTramDiemPB = phanTramDiemPB;
    }

    @Override
    public String toString() {
        return "CachTinhDiem{" +
                "phamTramDiemBGK=" + phamTramDiemBGK +
                ", phanTramDiemPB=" + phanTramDiemPB +
                '}';
    }

    public double getPhamTramDiemBGK() {
        return phamTramDiemBGK;
    }

    public void setPhamTramDiemBGK(double phamTramDiemBGK) {
        this.phamTramDiemBGK = phamTramDiemBGK;
    }

    public double getPhanTramDiemPB() {
        return phanTramDiemPB;
    }

    public void setPhanTramDiemPB(double phanTramDiemPB) {
        this.phanTramDiemPB = phanTramDiemPB;
    }

    public static void main(String[] args) {
        CachTinhDiem s1 = new CachTinhDiem(0.5,0.7);
        System.out.println("Phần trăm điểm BGK: " + s1.phamTramDiemBGK);
        System.out.println("Phần trăm điểm PB: " + s1.phanTramDiemPB);
    }
}
