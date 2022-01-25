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
public class Penjualan extends Transaksi{
    private  int idPenjualan;
    private  int idDriver;
    private  String namaDriver;
    private  int idPemesanan;
    

    public Penjualan(int idPenjualan, int idDriver, String namaDriver, int idPelanggan, String namaPelanggan, int idPemesanan, String namaBarang,int hargaBarang, int jumlahPesanan, int biayaPengiriman, int totalPembayaran) {
        
        this.idPenjualan = idPenjualan;
        this.idDriver = idDriver;
        this.namaDriver = namaDriver;
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.idPemesanan = idPemesanan;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahPesanan = jumlahPesanan;
        this.biayaPengiriman = biayaPengiriman;
        this.totalPembayaran = totalPembayaran;
    }

    public int getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }
    
    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
    

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
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
