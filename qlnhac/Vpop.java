package qlnhac;

public class Vpop extends nhac {

    private String dongNhac;

    public Vpop(){}

    public Vpop(String maBai, String tenBai, String tacGia, int thoiLuong, int namPhatHanh, int luotXem, String dongNhac) {
        // super(...) gọi đến constructor của lớp cha (lớp nhac)
        super(maBai, tenBai, tacGia, thoiLuong, namPhatHanh, luotXem);
        this.dongNhac = dongNhac;
    }

    public String getDongNhac(){
        return dongNhac;
    }
    public void setDongNhac(String dongNhac){
        this.dongNhac = dongNhac;
    }


    // Ghi đè (Override) phương thức nhapthongtin()
    @Override
    public void nhapthongtin() {
        super.nhapthongtin();
        System.out.print("Nhap dong nhac: ");
        this.dongNhac = sc.nextLine();
    }
    @Override
    public void hienthithongtin(){
        super.hienthithongtin();
        System.out.print("| Dong nhac: "+ dongNhac);
    }
    @Override
    public String getKhuVuc() {
        return "VPOP";
    }
}