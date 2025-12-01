package qlnhac;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    private String tenPlaylist;
    private List<nhac> danhSachBaiHat; // Danh sach bai hat RIENG cua playlist nay

    public Playlist(String tenPlaylist) {
        this.tenPlaylist = tenPlaylist;
        this.danhSachBaiHat = new ArrayList<>(); // Khoi tao danh sach rong
    }

    public String getTenPlaylist() {
        return tenPlaylist;
    }

    /**
     * Them mot bai hat (doi tuong 'nhac') vao playlist nay
     */
    public void themBaiVaoPlaylist(nhac bai) {
        this.danhSachBaiHat.add(bai);
    }

   public void hienThiPlaylist() {
        System.out.println("\nPLAYLIST: " + this.tenPlaylist);
        int dem = 1;
        for (nhac bai : danhSachBaiHat) 
        {
            System.out.print(dem++ + ". ");
            bai.hienthithongtin();
            System.out.println();
        }
    }
}