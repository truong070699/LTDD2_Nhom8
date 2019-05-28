package com.example.exe4;

public class Comment {
    private int image;
    private String txtTieuDe;

    public Comment() {
    }

    public Comment(int image, String txtTieuDe) {
        this.image = image;
        this.txtTieuDe = txtTieuDe;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getTxtTieuDe() {
        return txtTieuDe;
    }
    public void setTxtTieuDe(String txtTieuDe) {
        this.txtTieuDe = txtTieuDe;
    }
}
