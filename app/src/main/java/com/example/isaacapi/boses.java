package com.example.isaacapi;

public class boses {
    private String nameB;
    private String imagenB;
    private String detailUrlB;

    public boses(String nameB, String imagenB, String detailUrlB) {
        this.nameB = nameB;
        this.imagenB = imagenB;
        this.detailUrlB = detailUrlB;
    }

    @Override
    public String toString() {
        return "boses{" +
                "nameB='" + nameB + '\'' +
                ", imagenB='" + imagenB + '\'' +
                ", detailUrlB='" + detailUrlB + '\'' +
                '}';
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getImagenB() {
        return imagenB;
    }

    public void setImagenB(String imagenB) {
        this.imagenB = imagenB;
    }

    public String getDetailUrlB() {
        return detailUrlB;
    }

    public void setDetailUrlB(String detailUrlB) {
        this.detailUrlB = detailUrlB;
    }

}
