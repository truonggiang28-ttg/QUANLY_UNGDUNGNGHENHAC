package qlnhac;

public class Kpop extends nhac {

    private String tenNhom;
    
    public Kpop(){}

    public Kpop(String maBai, String tenBai, String tacGia, int thoiLuong, int namPhatHanh, int luotXem, String tenNhom) {
        // Gọi hàm của lớp cha
        super(maBai, tenBai, tacGia, thoiLuong, namPhatHanh, luotXem);
        this.tenNhom = tenNhom;
    }

    public String getTenNhom(){
        return tenNhom;
    }
    public void setTenNhom(String tenNhom){
        this.tenNhom = tenNhom;
    }

<<<<<<< HEAD
    // Ghi đè (Override) phương thức nhapthongtin()
=======
    /**
     * Ghi đè (Override) phương thức nhapthongtin
     */
>>>>>>> 94234a601b62b3709ca63b1e5336d4e544e688b6
    @Override
    public void nhapthongtin() {
        super.nhapthongtin();
        System.out.print("Nhap ten nhom: ");
        this.tenNhom = sc.nextLine();
    }
    @Override
    public void hienthithongtin(){
        super.hienthithongtin();
        System.out.print("| Ten nhom: "+ tenNhom);
    }
    @Override
    public String getKhuVuc() {
        return "KPOP";
    }
}
