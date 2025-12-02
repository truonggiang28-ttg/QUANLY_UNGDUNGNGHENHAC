package qlnhac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyNhac ql = new QuanLyNhac();
        Scanner sc = new Scanner(System.in);

        // 1. TỰ ĐỘNG ĐỌC DỮ LIỆU TỪ FILE KHI MỞ APP
        System.out.println("Dang khoi dong va tai du lieu...");
        ql.ReadData();

        int luachon = -1;
        do {
            System.out.println("\n========== QUAN LY NHAC ==========");
            System.out.println("1. Them bai hat moi");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim nhac");
            System.out.println("4. Xoa nhac");
            System.out.println("5. Tao playlist");
            System.out.println("6. Hien thi bang xep hang");
            System.out.println("7. Cap nhat muc luot xem");
            System.out.println("0. LUU VA THOAT");
            System.out.print("Lua chon cua ban: ");
            
            try {
                luachon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) 
                {
                    luachon = -1;
                }

            switch (luachon){
                case 1:
                    
                    ql.them(new Vpop("V01", "Chung ta khong thuoc ve nhau", "Son Tung MTP", 250, 2012, 5000000, "Pop"));
                    ql.them(new Vpop("V02", "Moi em", "DangRangTo",320, 2024, 2000000, "rap"));
                    ql.them(new Vpop("V03", "Em Cua Ngay Hom Qua", "Son Tung MTP", 232, 2013, 120000000, "Pop/R&B"));
                    ql.them(new Vpop("V04", "Mang Tien Ve Cho Me", "Den Vau", 405, 2021, 106000000, "Rap/Hip-hop"));
                    ql.them(new Kpop("K01", "Bang Bang Bang", "Big Bang", 220, 2015, 700000000, "Big Bang"));
                    ql.them(new Kpop("K02", "Dynamite", "BTS", 200, 2020, 9999999, "BTS"));
                    ql.them(new Usuk("U01", "Love Story", "Taylor Swift", 235, 2008, 700000000, "US"));
                    ql.them(new Usuk("U02", "Blinding Lights", "The Weeknd", 200, 2019, 800000000, "Canada"));
                    ql.them(new Usuk("U03", "Someone Like You", "Adele", 285, 2011, 220000000, "UK"));
                    ql.them(new Usuk("U04", "Shape of You", "Ed Sheeran", 240, 2017, 8000000, "UK"));
                    System.out.println("\n=========================DA THEM============================.");
                    break;
                    
                    /* 
                    String tiepTuc;
                    do {
                        System.out.println("\n--- THEM BAI HAT MOI ---");
                        System.out.println("Chon loai nhac: 1.VPOP | 2.KPOP | 3.USUK | 0.Quay lai");
                        System.out.print("Chon: ");
                        int loai = 0;
                        try {
                            loai = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) { loai = 0; }

                        //chọn 0 thì thoát
                        if (loai == 0)
                            break; 
                        
                        nhac baiMoi = null;
                        
                        // Tạo đối tượng
                        if (loai == 1) 
                            baiMoi = new Vpop();
                        else if(loai == 2) 
                            baiMoi = new Kpop();
                        else if (loai == 3) 
                            baiMoi = new Usuk();
                        
                        if (baiMoi != null) 
                        {
                            // Gọi hàm nhập
                            baiMoi.nhapthongtin();
                            
                            // Kiểm tra trùng mã trước khi thêm
                            if(ql.timKiem(baiMoi.getMaBai()) == null) 
                                {
                                    ql.them(baiMoi);
                                    System.out.println("Them thanh cong!");
                                } 
                            else 
                            {
                                System.out.println("Loi: Ma bai hat da ton tai (" + baiMoi.getMaBai() + ")");
                            }
                        } 
                        else 
                        {
                            System.out.println("Loai nhac khong hop le.");
                        }
                        System.out.print("\nBan co muon nhap tiep bai khac khong? (Y/N): ");
                        tiepTuc = sc.nextLine();
                    } while (tiepTuc.equalsIgnoreCase("Y")); 
                        break;
                    */
                case 2:
                    // Hiển thị danh sách
                    ql.hienThiDanhSach();
                    break;

                case 3:
                    System.out.println("\n--- TIM KIEM NHAC ---");
                    System.out.print("Nhap ma bai hat can tim: ");
                    String matim = sc.nextLine();
                    nhac tim = ql.timKiem(matim);
                    if(tim != null) 
                    {
                        System.out.println("Ket qua tim thay:");
                        tim.hienthithongtin();
                    } 
                    else 
                    {
                        System.out.println("Khong tim thay bai hat nao voi ma: " + matim);
                    }
                    break;

                case 4:
                    System.out.println("\n--- XOA NHAC ---");
                    System.out.print("Nhap ma bai hat can xoa: ");
                    String maxoa = sc.nextLine();
                    boolean kqXoa = ql.xoa(maxoa); 
                    if(kqXoa) 
                    {
                        System.out.println("Da xoa thanh cong bai hat ma: " + maxoa);
                        // Hiển thị lại danh sách sau khi xóa
                        ql.hienThiDanhSach();
                    } 
                    else 
                    {
                        System.out.println("Khong tim thay bai hat de xoa.");
                    }
                        break;

                case 5:
                    System.out.println("\n--- TAO PLAYLIST ---");
                    System.out.print("Nhap ten playlist muon tao: ");
                    String tenPl = sc.nextLine();
                    ql.taoPlaylist(tenPl);
                    String next;
                    do {
                        System.out.println("\n-----------------------------");
                        System.out.print("Nhap MA BAI HAT muon them: ");
                        String maPl = sc.nextLine();
                        //kiem tra ma co ton tai khong
                        if(!maPl.trim().isEmpty()) {
                            ql.themBaiVaoPlaylist(maPl, tenPl);

                        ql.hienThiNoiDungPlaylist(tenPl);
                        
                        System.out.print("\nBan co muon them bai KHAC vao playlist nay khong? (Y/N): ");
                        next = sc.nextLine();

                    } while (next.equalsIgnoreCase("Y"));
                     /* 
                    System.out.println("Them bai hat vao playlist [" + tenPl + "]?");
                    System.out.print("Nhap ma bai hat muon them (hoac an Enter de bo qua): ");
                    String maPl = sc.nextLine();
                    if(!maPl.trim().isEmpty()) 
                    {
                        ql.themBaiVaoPlaylist(maPl, tenPl);
                    }
                    // Hiển thị playlist vừa tạo
                    ql.hienThiNoiDungPlaylist(tenPl);*/
                    break;

                case 6:
                    System.out.println("\n--- BANG XEP HANG ---");
                    System.out.println("1. Tong hop | 2. VPOP | 3. KPOP | 4. USUK");
                    System.out.print("Chon loai BXH: ");
                    int chonBxh = 0;
                    try 
                    {
                        chonBxh = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {}

                    if (chonBxh == 1) ql.hienThiBangXepHang();
                    else 
                        if (chonBxh == 2) ql.hienThiBangXepHang("VPOP");
                        else 
                            if (chonBxh == 3) ql.hienThiBangXepHang("KPOP");
                            else 
                                if (chonBxh == 4) ql.hienThiBangXepHang("USUK");
                                else System.out.println("Lua chon khong hop le.");
                        break;

                case 7:
                    System.out.println("\nNhap ma bai hat can cap nhat: ");
                    String maupdate;
                    maupdate = sc.nextLine();
                    nhac baiupdate = ql.timKiem(maupdate);
                    if(baiupdate != null)
                    {
                        baiupdate.hienthithongtin();
                        System.out.println("\nNhap luot xem moi: ");
                        int view = Integer.parseInt(sc.nextLine());
                        ql.capnhatluotxem(maupdate, view);
                        System.out.println("=============================");
                        System.out.println("\nBai hat sau cap nhat: ");
                        baiupdate.hienthithongtin();    
                    }
                    else
                        System.out.println("Khong tim thay.");
                    break;

                case 0:
                    System.out.println("\nDang luu du lieu vao file...");
                    // 2. TỰ ĐỘNG GHI FILE KHI THOÁT
                    ql.WriteData();
                    System.out.println("Da luu thanh cong. Hen gap lai!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
            
            if(luachon != 0) {
                System.out.println("\nNhan Enter de tiep tuc...");
                sc.nextLine();
            }
            
        } while (luachon != 0);
        sc.close();
    }
}
