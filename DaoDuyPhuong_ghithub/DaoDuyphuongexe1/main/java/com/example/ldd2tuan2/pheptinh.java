package com.example.ldd2tuan2;

public class pheptinh {

    private int img;
    private String ma;
    private String ten;

    public pheptinh() {
    }
    public pheptinh(int img, String ma, String ten) {
        this.setImg(img);
        this.setMa(ma);
        this.setTen(ten);
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String toString()
    {
        return this.ma + "-" +this.ten;
    }
}
