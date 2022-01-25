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
public class Pengantaran {
    private int idPegantaran;
    private int idPemesanan;
    private String namaBarang;
    private int idDriver;
    private String penerima;

    public Pengantaran(int idPegantaran, int idPemesanan, String namaBarang, int idDriver, String penerima) {
        this.idPegantaran = idPegantaran;
        this.idPemesanan = idPemesanan;
        this.namaBarang = namaBarang;
        this.idDriver = idDriver;
        this.penerima = penerima;
    }

    public int getIdPegantaran() {
        return idPegantaran;
    }

    public void setIdPegantaran(int idPegantaran) {
        this.idPegantaran = idPegantaran;
    }

    public int getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }
    
}
