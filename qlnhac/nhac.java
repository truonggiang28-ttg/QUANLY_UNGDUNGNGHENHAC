package qlnhac;
import java.util.Scanner;

public abstract class nhac implements IKhuVuc {
    private String maBai; // 4 tính chất: đa hình, trừu tượng, kế thừa, đóng gói
    private String tenBai;
    private String tacGia;
    private int thoiLuong; 
    private int namPhatHanh;
    private int luotXem;

    public nhac(){}

    public nhac(String maBai, String tenBai, String tacGia, int thoiLuong, int namPhatHanh, int luotXem){
        this.maBai = maBai;
        this.tenBai = tenBai;
        this.tacGia = tacGia;
        this.thoiLuong = thoiLuong;
        this.namPhatHanh = namPhatHanh;
        this.luotXem = luotXem;
    }

    // (Các getter/setter của bạn)
    public String getMaBai() {
        return maBai;
    }

    public String getTenBai() {
        return tenBai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public int getNamPhatHanh() {
        return namPhatHanh;
    }

    public int getLuotXem() {
        return luotXem;
    }
    

    public void setMaBai(String maBai) {
        this.maBai = maBai;
    }

    public void setTenBai(String tenBai) {
        this.tenBai = tenBai;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public void setLuotXem(int luotXem) {
        this.luotXem = luotXem;
    }

    Scanner sc = new Scanner(System.in);
  
    public void nhapthongtin()
    {
        System.out.print("Nhap ma bai hat: ");
        maBai = sc.nextLine();
        System.out.print("Nhap ten bai hat: ");
        tenBai = sc.nextLine();
        System.out.print("Nhap ten tac gia: ");
        tacGia = sc.nextLine();
        System.out.print("Nhap thoi luong (s): ");
        thoiLuong = Integer.parseInt( sc.nextLine());
        System.out.print("Nhap nam phat hanh: ");
        namPhatHanh = Integer.parseInt( sc.nextLine());
        System.out.print("Nhap luot xem: ");
        luotXem = Integer.parseInt( sc.nextLine());
    }
    public void hienthithongtin()
    {
        System.out.println("Ma bai hat: " + maBai + " | Ten bai hat: " + tenBai + " | Ten tac gia: " + tacGia + " | Thoi luong (s): " + thoiLuong 
        + " | Nam phat hanh: " + namPhatHanh + " | Luot xem: " + luotXem);
    }
    @Override
    public abstract String getKhuVuc();
}
