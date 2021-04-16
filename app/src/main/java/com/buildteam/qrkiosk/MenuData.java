package com.buildteam.qrkiosk;

public class MenuData {

    private int ib_profile;
    private String et_name;
    private String et_price;

    public MenuData(int ib_profile, String et_name, String et_price) {
        this.ib_profile = ib_profile;
        this.et_name = et_name;
        this.et_price = et_price;
    }

    public int getIb_profile() {
        return ib_profile;
    }

    public void setIb_profile(int ib_profile) {
        this.ib_profile = ib_profile;
    }

    public String getEt_name() {
        return et_name;
    }

    public void setEt_name(String et_name) {
        this.et_name = et_name;
    }

    public String getEt_price() {
        return et_price;
    }

    public void setEt_price(String et_price) {
        this.et_price = et_price;
    }
}
