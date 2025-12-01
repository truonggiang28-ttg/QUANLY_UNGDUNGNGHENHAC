package qlnhac;

public interface IManager<ql> {
    void them(ql doituong);
    boolean xoa(String id);
    ql timKiem(String id);
    void hienThiDanhSach();
    boolean capnhatluotxem(String id, int view);
}
