package com.app.databku.modal;

public class ModalKu {

    private String name;
    private String alamat;
    private String pekerjaan;

    public ModalKu() {
    }

    public ModalKu(String name, String alamat, String pekerjaan) {
        this.name = name;
        this.alamat = alamat;
        this.pekerjaan = pekerjaan;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
}
