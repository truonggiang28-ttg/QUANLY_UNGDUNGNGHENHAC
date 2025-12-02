package qlnhac;

public class Usuk extends nhac {

    private String quocGia;
    
    public Usuk(){}

    public Usuk(String maBai, String tenBai, String tacGia, int thoiLuong, int namPhatHanh, int luotXem, String quocGia) {
        // Gọi hàm của lớp cha
        super(maBai, tenBai, tacGia, thoiLuong, namPhatHanh, luotXem);
        this.quocGia = quocGia;
    }

    public String getQuocGia(){
        return quocGia;
    }
    public void setQuocGia(String quocGia){
        this.quocGia = quocGia;
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
        System.out.print("Nhap quoc gia: ");
        this.quocGia = sc.nextLine();
    }
    @Override
    public void hienthithongtin(){
        super.hienthithongtin();
        System.out.print("| Quoc gia: "+ quocGia);
    }
    @Override
    public String getKhuVuc() {
        return "USUK";
    }
}
