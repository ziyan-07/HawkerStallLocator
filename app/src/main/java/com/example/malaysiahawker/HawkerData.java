package com.example.malaysiahawker;

public class HawkerData {
    private String name,address;
    private String description,displayphoneno,isopen,phone,review,openinghours;
    private int favourites,recommends;
    private byte[] photo,photo1,photo2,photo3,photo4;

    public HawkerData(String name, String address, String description, String displayphoneno, String isopen, int favourites, String phone, int recommends, String review, String openinghours,byte[] photo,byte[] photo1,byte[] photo2, byte[] photo3, byte[] photo4) {

        this.name = name;
        this.address = address;
        this.description = description;
        this.displayphoneno = displayphoneno;
        this.isopen = isopen;
        this.favourites = favourites;
        this.phone = phone;
        this.recommends = recommends;
        this.review = review;
        this.openinghours = openinghours;
        this.photo = photo;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayphoneno() {
        return displayphoneno;
    }

    public void setDisplayphoneno(String displayphoneno) {
        this.displayphoneno = displayphoneno;
    }

    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
        this.favourites = favourites;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRecommends() {
        return recommends;
    }

    public void setRecommends(int recommends) {
        this.recommends = recommends;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

    public byte[] getPhoto4() {
        return photo4;
    }

    public void setPhoto4(byte[] photo4) {
        this.photo4 = photo4;
    }
}
