package com.vansuzy.model;

/**
 * Created by keeps on 6/2/2017.
 */

public class Music {
    private String ma;
    private String ten;
    private String caSi;
    private boolean thich;

    public Music() {
    }

    public Music(String ma, String ten, String caSi, boolean thich) {
        this.ma = ma;
        this.ten = ten;
        this.caSi = caSi;
        this.thich = thich;
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

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public boolean isThich() {
        return thich;
    }

    public void setThich(boolean thich) {
        this.thich = thich;
    }
}
