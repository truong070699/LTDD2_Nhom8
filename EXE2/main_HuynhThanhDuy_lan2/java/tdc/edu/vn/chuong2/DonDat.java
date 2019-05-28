package tdc.edu.vn.chuong2;

public class DonDat {
    private int image;
    private String txtTieuDe;

    public DonDat() {
    }

    public DonDat(int image, String txtTieuDe) {
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
