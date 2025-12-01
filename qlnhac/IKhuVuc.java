package qlnhac;

/**
 * Interface định nghĩa "hợp đồng" cho các lớp có khả năng
 * phân loại theo khu vực.
 */
public interface IKhuVuc {
    /**
     * Trả về tên khu vực của bài hát (ví dụ: "VPOP", "KPOP", "USUK")
     */
    public String getKhuVuc();
}