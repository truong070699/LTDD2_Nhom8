package tdc.edu.vn.test;

public class pheptinh {

    private String soA;
    private String soB;
    private int icon;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSoA() {
        return soA;
    }

    public void setSoA(String soA) {
        this.soA = soA;
    }

    public String getSoB() {
        return soB;
    }

    public void setSoB(String soB) {
        this.soB = soB;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }



    private String ketqua;


    public pheptinh() {
    }

    public pheptinh(String soA, String soB, String ketqua, int icon) {
        this.soA = soA;
        this.soB = soB;
        this.ketqua = ketqua;
        this.icon = icon;
    }


}

