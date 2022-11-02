package com.example.isaacapi;

public class Personajes {
    private String name;
    private String image;
    private String detailsUrl;


    public Personajes(String name, String image, String detailsUrl) {
        this.name = name;
        this.image = image;
        this.detailsUrl = detailsUrl;
    }

    public Personajes() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static String getDetailsUrl(String url) {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }




    @Override
    public String toString() {
        return "Personajes{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", detailsUrl='" + detailsUrl + '\'' +
                '}';
    }
}
