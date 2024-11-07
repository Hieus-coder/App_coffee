package model;

/**
 * Model class for representing an employee (nhân sự).
 */
public class quanlymodel {
    
    private int ID_NHAN_SU; // Đổi tên biến từ 'id' thành 'id' để khớp với tên cột SQL
    private String HO_VA_TEN; // Đổi tên biến
    private String GIOI_TINH; // Đổi tên biến
    private int NAM_SINH; // Đổi tên biến
    private String CHUC_VU; // Đổi tên biến
    private String QUE_QUAN; // Đổi tên biến
    private String SO_DIEN_THOAI; // Đổi tên biến

    // Constructor
    public quanlymodel(){}
    public quanlymodel(int id, String HO_VA_TEN, String GIOI_TINH, int NAM_SINH, String CHUC_VU, String QUE_QUAN, String SO_DIEN_THOAI) {
        this.ID_NHAN_SU = id;
        this.HO_VA_TEN = HO_VA_TEN;
        this.GIOI_TINH = GIOI_TINH;
        this.NAM_SINH = NAM_SINH;
        this.CHUC_VU = CHUC_VU;
        this.QUE_QUAN = QUE_QUAN;
        this.SO_DIEN_THOAI = SO_DIEN_THOAI;
    }

    // Getters and Setters
    public int getid() {
        return ID_NHAN_SU;
    }

    public void setid(int id) {
        this.ID_NHAN_SU = id;
    }

    public String getHO_VA_TEN() {
        return HO_VA_TEN;
    }

    public void setHO_VA_TEN(String HO_VA_TEN) {
        this.HO_VA_TEN = HO_VA_TEN;
    }

    public String getGIOI_TINH() {
        return GIOI_TINH;
    }

    public void setGIOI_TINH(String GIOI_TINH) {
        this.GIOI_TINH = GIOI_TINH;
    }

    public int getNAM_SINH() {
        return NAM_SINH;
    }

    public void setNAM_SINH(int NAM_SINH) {
        this.NAM_SINH = NAM_SINH;
    }

    public String getCHUC_VU() {
        return CHUC_VU;
    }

    public void setCHUC_VU(String CHUC_VU) {
        this.CHUC_VU = CHUC_VU;
    }

    public String getQUE_QUAN() {
        return QUE_QUAN;
    }

    public void setQUE_QUAN(String QUE_QUAN) {
        this.QUE_QUAN = QUE_QUAN;
    }

    public String getSO_DIEN_THOAI() {
        return SO_DIEN_THOAI;
    }

    public void setSO_DIEN_THOAI(String SO_DIEN_THOAI) {
        this.SO_DIEN_THOAI = SO_DIEN_THOAI;
    }

    @Override
    public String toString() {
        return "QuanLyModel{" +
                "id=" + ID_NHAN_SU +
                ", HO_VA_TEN='" + HO_VA_TEN + '\'' +
                ", GIOI_TINH='" + GIOI_TINH + '\'' +
                ", NAM_SINH=" + NAM_SINH +
                ", CHUC_VU='" + CHUC_VU + '\'' +
                ", QUE_QUAN='" + QUE_QUAN + '\'' +
                ", SO_DIEN_THOAI='" + SO_DIEN_THOAI + '\'' +
                '}';
    }
}
