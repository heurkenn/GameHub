package fr.gamehub.gamehub.model;

public class Classement {
    private User premier;
    private User deuxi;
    private User troisi;

    public User getDeuxi() {
        return deuxi;
    }
    public User getPremier() {
        return premier;
    }

    public User getTroisi() {
        return troisi;
    }

    public void setDeuxi(User deuxi) {
        this.deuxi = deuxi;
    }

    public void setPremier(User premier) {
        this.premier = premier;
    }
    public void setTroisi(User troisi) {
        this.troisi = troisi;
    }
}
