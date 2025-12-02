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


<<<<<<< HEAD
    // Ghi đè (Override) phương thức nhapthongtin()
=======
    /**
     * Ghi đè (Override) phương thức nhapthongtin()
     */
>>>>>>> 94234a601b62b3709ca63b1e5336d4e544e688b6
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
