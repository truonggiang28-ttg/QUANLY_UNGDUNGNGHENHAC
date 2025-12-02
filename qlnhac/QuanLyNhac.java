package qlnhac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyNhac implements IReadWrite, IManager<nhac> {
    
    private List<nhac> danhSachBaiHat;
    private List<Playlist> danhSachPlaylist;

    public QuanLyNhac() {
        this.danhSachBaiHat = new ArrayList<>();
        this.danhSachPlaylist = new ArrayList<>();
    }

    // --- 1.TRIỂN KHAI IMANAGER---

    @Override
    public void them(nhac baiHat) {
        this.danhSachBaiHat.add(baiHat);
    }

    @Override
    public nhac timKiem(String matim) {
        for (nhac i : danhSachBaiHat) {
            if (i.getMaBai().equalsIgnoreCase(matim)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean xoa(String maxoa) {
        nhac bai = timKiem(maxoa);
        if (bai != null) {
            danhSachBaiHat.remove(bai);
            return true;
        }
        return false;
    }

    @Override
    public boolean capnhatluotxem(String mabai, int view){
        nhac bai = timKiem(mabai);
        if(bai != null)
        {
            bai.setLuotXem(view);
            return true;
        }
        return false;

    }

    @Override
    public void hienThiDanhSach() {
        System.out.println("\n=============================");
        System.out.println("-- DANH SACH BAI HAT --");
        if (danhSachBaiHat.isEmpty()) {
            System.out.println("Danh sach dang trong!");
        } 
        else {
            for (nhac i : danhSachBaiHat) {
                System.out.println("-----------------");
                i.hienthithongtin(); 
                System.out.println("\n");
            }
        }
    }

    // --- 2.TRIỂN KHAI IREADWRITE ---

    @Override
    public void WriteData() {
        try {
            FileWriter fw = new FileWriter(Filename); // Filename lấy từ Interface
            BufferedWriter bw = new BufferedWriter(fw);

            for (nhac bai : danhSachBaiHat) {
                String line = "";
                // Format: LOAI,Ma,Ten,TacGia,ThoiLuong,Nam,View,ThuocTinhRieng
                if (bai instanceof Vpop) {
                    Vpop v = (Vpop) bai;
                    line = String.format("VPOP,%s,%s,%s,%d,%d,%d,%s", 
                            v.getMaBai(), v.getTenBai(), v.getTacGia(), v.getThoiLuong(), 
                            v.getNamPhatHanh(), v.getLuotXem(), v.getDongNhac());
                } 
                else 
                    if (bai instanceof Kpop) {
                        Kpop k = (Kpop) bai;
                        line = String.format("KPOP,%s,%s,%s,%d,%d,%d,%s", 
                                k.getMaBai(), k.getTenBai(), k.getTacGia(), k.getThoiLuong(), 
                                k.getNamPhatHanh(), k.getLuotXem(), k.getTenNhom());
                } 
                else 
                    if (bai instanceof Usuk) {
                        Usuk u = (Usuk) bai;
                        line = String.format("USUK,%s,%s,%s,%d,%d,%d,%s", 
                                u.getMaBai(), u.getTenBai(), u.getTacGia(), u.getThoiLuong(), 
                                u.getNamPhatHanh(), u.getLuotXem(), u.getQuocGia());
                    }
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void ReadData() {
        this.danhSachBaiHat.clear();
        File f = new File(Filename);
        if (!f.exists()) return;

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length >= 8) {
                    // Trim để xóa khoảng trắng thừa
                    String loai = arr[0].trim();
                    String ma = arr[1].trim();
                    String ten = arr[2].trim();
                    String tacGia = arr[3].trim();
                    int tl = Integer.parseInt(arr[4].trim());
                    int nam = Integer.parseInt(arr[5].trim());
                    int view = Integer.parseInt(arr[6].trim());
                    String rieng = arr[7].trim();

                    nhac b = null;
                    switch (loai) {
                        case "VPOP": b = new Vpop(ma, ten, tacGia, tl, nam, view, rieng); break;
                        case "KPOP": b = new Kpop(ma, ten, tacGia, tl, nam, view, rieng); break;
                        case "USUK": b = new Usuk(ma, ten, tacGia, tl, nam, view, rieng); break;
                    }
                    if (b != null) this.danhSachBaiHat.add(b);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // --- 3. CÁC CHỨC NĂNG (PLAYLIST, BXH) ---

    public void hienThiBangXepHang() {
        System.out.println("\n---BANG XEP HANG TONG HOP---");
        List<nhac> bxh = new ArrayList<>(this.danhSachBaiHat);
        
        Collections.sort(bxh, new Comparator<nhac>() {
            @Override
            public int compare(nhac b1, nhac b2) {
                return Integer.compare(b2.getLuotXem(), b1.getLuotXem());
            }
        });

        int hang = 1;
        for (nhac bai : bxh) {
            System.out.print("HANG " + (hang++) + ": "); 
            bai.hienthithongtin();
            System.out.println("\n");
        }
    }

    /*
     * Hiển thị BXH theo KHU VỰC
     * - Tham số: String tenKhuVuc (ví dụ: "VPOP", "KPOP", "USUK")
    */
    public void hienThiBangXepHang(String tenKhuVuc) {
        
        System.out.println(String.format("\n---BANG XEP HANG KHU VUC %s ---", tenKhuVuc));

        //Tạo danh sách
        List<nhac> bxhKhuVuc = new ArrayList<>();
        
        //Lọc danh sách
        for (nhac bai : this.danhSachBaiHat) {
            if (bai.getKhuVuc().equals(tenKhuVuc)) //kiểm tra khu vực
            {
                bxhKhuVuc.add(bai);
            }
        }
        
        Collections.sort(bxhKhuVuc, new Comparator<nhac>() {
            @Override
            public int compare(nhac b1, nhac b2) {
                return Integer.compare(b2.getLuotXem(), b1.getLuotXem()); //Sắp xếp danh sách đã lọc
            }
        });
        
        //In kết quả
        int hang = 1;
        if (bxhKhuVuc.isEmpty()) {
            System.out.println("KHONG CO BAI HAT NAO TRONG BANG XEP HANG NAY CA.");
            return;
        }
        for (nhac bai : bxhKhuVuc) {
            System.out.print("HANG " + (hang++) + ": ");
            bai.hienthithongtin();
            System.out.println("\n");
        }
    }

    // Playlist Management
    public Playlist taoPlaylist(String tenPlaylist){
        Playlist pl = new Playlist(tenPlaylist);
        this.danhSachPlaylist.add(pl);
        return pl;
    }
    
    public Playlist timPlaylist(String tenPlaylist){
        for(Playlist i : danhSachPlaylist)
            if(i.getTenPlaylist().equalsIgnoreCase(tenPlaylist)) 
                return i;
        return null;
    }

    public void themBaiVaoPlaylist(String maBai, String tenPlaylist){
        Playlist pl = timPlaylist(tenPlaylist);
        nhac bai = timKiem(maBai);

        if(pl != null && bai != null){
            pl.themBaiVaoPlaylist(bai);
            System.out.println("Da them bai " + bai.getTenBai() + " vao playlist " + tenPlaylist);
        } else {
            System.out.println("Loi: Khong tim thay playlist hoac bai hat.");
        }
    }

    public void hienThiNoiDungPlaylist(String tenPlaylist) {
        Playlist pl = timPlaylist(tenPlaylist);
        if (pl != null) {
            pl.hienThiPlaylist();
        } else {
            System.out.println("Khong tim thay playlist: " + tenPlaylist);
        }
    }
}
