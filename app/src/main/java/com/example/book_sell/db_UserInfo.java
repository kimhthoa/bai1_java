package com.example.book_sell;

public class db_UserInfo {
    private String mauser;
    private String gioitinh;
    private String ngaysinh;
    private String quequan;
    private String sothich;

    public db_UserInfo(String mauser, String gioitinh, String ngaysinh, String quequan, String sothich) {
        this.mauser = mauser;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.sothich = sothich;
    }

    public String getMauser() {
        return mauser;
    }

    public void setMauser(String mauser) {
        this.mauser = mauser;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }
}
