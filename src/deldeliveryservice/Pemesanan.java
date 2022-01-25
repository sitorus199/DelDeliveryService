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
public class Pemesanan extends Transaksi{
    private  int idPemesanan;     
    private  Kota kotaTujuan;     
    private  String statusPemesanan;
    

    public Pemesanan(int idPemesanan,int idPelanggan, String namaPelanggan, int idBarang, String namaBarang,int hargaBarang, int jumlahPesanan,Kota kotaTujuan, int biayaPengiriman, int totalPembayaran, String statusPemesanan) {
        this.idPemesanan = idPemesanan;
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahPesanan = jumlahPesanan;
        this.kotaTujuan = kotaTujuan;
        this.biayaPengiriman = biayaPengiriman;
        this.totalPembayaran = totalPembayaran;
        this.statusPemesanan = statusPemesanan;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
    
    public int getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public Kota getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(Kota kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }
    
    public int getBiayaPengiriman() {
        return biayaPengiriman;
    }

    public void setBiayaPengiriman(int biayaPengiriman) {
        this.biayaPengiriman = biayaPengiriman;
    }

    public int getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(int totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
    
    
}
