/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deldeliveryservice;

/**
 *
 * @author Hengki Hutahaean
 */
public class Pelanggan {
    private int idPelanggan;
    private int userID;
    private String namaPelanggan;
    private String alamatPelanggan;

    public Pelanggan(int idPelanggan, int userID, String namaPelanggan, String alamatPelanggan) {
        this.idPelanggan = idPelanggan;
        this.userID = userID;
        this.namaPelanggan = namaPelanggan;
        this.alamatPelanggan = alamatPelanggan;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public void setAlamatPelanggan(String alamatPelanggan) {
        this.alamatPelanggan = alamatPelanggan;
    }
    
}
