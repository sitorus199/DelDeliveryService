/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deldeliveryservice;

import java.util.*;

/**
 *
 * @author Hengki Hutahaean
 */
public class DelDeliveryService {

    /**
     * @param args the command line arguments
     */
    static Scanner masukan = new Scanner(System.in);
        
    int opsi ;
    
    Akun admin = new Admin();
    static List<User> user = new LinkedList<>();
    static List<Driver> driver = new LinkedList<>();
    static List<Pelanggan> pelanggan = new LinkedList<>();
    static List<Barang> barang = new LinkedList<>();
    static List<Pemesanan> pemesanan = new LinkedList<>();
    static List<Penjualan> penjualan = new LinkedList<>();
    static List<Pengantaran> pengantaran = new LinkedList<>();
    
    
    
    public static void main(String[] args) {
        DelDeliveryService aplikasi = new DelDeliveryService();
        barang.add(new Barang(1,"Kemeja",JenisBarang.Pakaian,  100000,100));
        aplikasi.menuUtama();  
        
        
        
    }
    
    void menuUtama(){
        System.out.println("==========  Menu Utama ==========");
        System.out.println("+ 1. Login Admin                +");
        System.out.println("+ 2. Login User                 +");
        System.out.println("+ 3. Registrasi                 +");
        System.out.println("+ 4. Keluar                     +");
        System.out.println("=================================");
           
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                loginAdmin();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                menuRegistrasi();
                break;
            case 4: 
                System.exit(0);
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                menuUtama();
                break;
                
        }
        
    }
    
    void loginAdmin(){
        
        System.out.print("\nUsername : ");
        String username = masukan.next();
        System.out.print("Password : ");
        String password = masukan.next();
        
        if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
            menuAdmin();
        }else{
            System.out.println("Password atau username salah!");
            menuUtama();
        }
        
    }
    
    void loginUser(){        
        
        System.out.print("\nUsername : ");
        String username = masukan.next();
        System.out.print("Password : ");
        String password = masukan.next();
        
        int indexUser = getAkun(username,password)-1;
                
        
        if(indexUser>=0){
            if(username.equals(user.get(indexUser).getUsername())&&password.equals(user.get(indexUser).getPassword())){
                if(user.get(indexUser).getUserSesion()==1){
                    for(int j=0;j<driver.size();j++){
                        if(driver.get(j).getUserID()==user.get(indexUser).getUserID()){
                            System.out.println("login sebagai driver");
                            menuDriver(driver.get(j).getDriverID(),driver.get(j).getNamaDriver());
                        }
                    }
                }else if(user.get(indexUser).getUserSesion()==2){
                    for(int j=0;j<pelanggan.size();j++){
                        if(pelanggan.get(j).getUserID()==user.get(indexUser).getUserID()){
                            System.out.println("login sebagai pelanggan");
                            menuPelanggan(pelanggan.get(j).getIdPelanggan(),pelanggan.get(j).getNamaPelanggan());
                        }
                    }
                }
            }
        }else{
            System.out.println("Usrname/password salah");
            menuUtama();
        }
        
        

    }
    int getAkun(String username,String password){
        int userID=0;
        for(int i=0;i<user.size();i++){
            if(user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)){
                userID = user.get(i).getUserID();
                
            }
        }
        
        
        return userID;
        
    }
    
    void menuRegistrasi(){
        System.out.println("======== Menu Registrasi ========");
        System.out.println("+ 1. Registrasi Driver          +");
        System.out.println("+ 2. Registrasi Pelanggan       +");
        System.out.println("+ 3. Keluar                     +");
        System.out.println("=================================");
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                registrasiDriver();
                break;
            case 2:
                registrasiPelanggan();
                break;
            case 3:
                opsi=0;
                menuUtama();
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                menuRegistrasi();
                break;
        }
        
    }
    
    void registrasiDriver(){
        int idDriver = driver.size()+1;
        System.out.print("\nNama : ");
        String namaDriver = masukan.next();
        System.out.print("Alamat : ");
        String alamat = masukan.next();
        
        
        int userSesion = 1;
        System.out.print("Username : ");
        String username = masukan.next();
        System.out.print("Password : ");
        String password = masukan.next();
        
        
        if(user.isEmpty()){
            int newId= 1;
            driver.add(new Driver(idDriver,newId,namaDriver, alamat));
            user.add(new User(newId,userSesion,username,password));
        }else{
            int newId= user.get(user.size()-1).getUserID()+1;
            driver.add(new Driver(idDriver,newId,namaDriver, alamat));
            user.add(new User(newId,userSesion,username,password));
        }
        
        
        
        System.out.println("Berhasil Mendaftar");
        menuRegistrasi();
    }
    
    void registrasiPelanggan(){
       int idPelanggan = pelanggan.size()+1;
        System.out.print("\nNama : ");
        String namaPelanggan = masukan.next();
        System.out.print("Alamat : ");
        String alamatPelanggan = masukan.next();        
        
        int userSesion = 2;
        System.out.print("Username : ");
        String username = masukan.next();
        System.out.print("Password : ");
        String password = masukan.next();
        
        if(user.isEmpty()){
            int newId= 1;
            pelanggan.add(new Pelanggan(idPelanggan, newId,namaPelanggan,alamatPelanggan));
            user.add(new User(newId,userSesion,username,password));
        }else{
            int newId= user.get(user.size()-1).getUserID()+1;
            pelanggan.add(new Pelanggan(idPelanggan, newId,namaPelanggan,alamatPelanggan));
            user.add(new User(newId,userSesion,username,password));
        }
       
        
        
        
        
        
        System.out.println("Berhasil Mendaftar");
        menuRegistrasi();
    }
    
    void menuAdmin(){
        System.out.println("==========  Menu Admin ==========");
        System.out.println("+ 1. Kelola Barang              +");
        System.out.println("+ 2. Lihat Penjualan            +");
        System.out.println("+ 3. Lihat Data Pelanggan       +");
        System.out.println("+ 4. Lihat Data Driver          +");
        System.out.println("+ 5. Keluar                     +");
        System.out.println("=================================");
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                menuKelolaDataBarang();
                break;
            case 2:
                lihatDataPenjualan();
                menuAdmin();
                break;
            case 3:                
                lihatDataPelanggan();
                menuAdmin();
                break;
            case 4:                
                lihatDataDriver();
                menuAdmin();
                break;
            case 5:
                opsi = 0;
                menuUtama();
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                menuAdmin();
                break;
        }
    }
        
    void menuKelolaDataBarang(){
        
        System.out.println("======  Menu Kelola Barang ======");
        System.out.println("+ 1. Tambah Data Barang         +");
        System.out.println("+ 2. Hapus Data Barang          +");
        System.out.println("+ 3. Ubah Data Barang           +");
        System.out.println("+ 4. Lihat Data Barang          +");
        System.out.println("+ 5. Tambah Stok Barang         +");
        System.out.println("+ 6. Keluar                     +");
        System.out.println("=================================");
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                tambahDataBarang();
                break;
            case 2:
                hapusDataBarang();
                break;
            case 3:                
                ubahDataBarang();
                break;
            case 4:                
                lihatDaftarBarang();
                menuKelolaDataBarang();
                break;
            case 5:                
                tambahStokBarang();
                break;
            case 6:
                opsi = 0;
                menuAdmin();
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                menuKelolaDataBarang();
                break;
        }
    }
    
    void tambahDataBarang(){
        
        int idBarang = barang.get(barang.size()-1).getIdBarang()+1;
        System.out.print("Nama Barang  : ");
        String namaBarang = masukan.next();
        System.out.println(" Jenis yang tersedia : ");
        System.out.println(" Elektronik, Pakaian, Makanan, Minuman;");
        System.out.print("Jenis Barang : ");
        String jenisBarang = masukan.next();
        System.out.print("Harga Barang : ");
        int hargaBarang = inputAngka();
        System.out.print("Stok Barang  : ");
        int stokBarang = inputAngka();
        
        try{            
            if (barang.add(new Barang(idBarang,namaBarang,JenisBarang.valueOf(jenisBarang),  hargaBarang, stokBarang))) {
                System.out.println("Berhasil Menambah data");
                menuKelolaDataBarang();
            }
            
            
        }catch(IllegalArgumentException a){            
            
            System.out.println("------------------------ Enum Fault ------------------------");
            System.out.println(" Jenis yang tersedia : ");
            System.out.println(" Elektronik, Pakaian, Makanan, Minuman;");
            System.out.println("------------------------------------------------------------");
            menuKelolaDataBarang();
                         
        }
        
        
    }
    
    void hapusDataBarang(){
        lihatDaftarBarang();
        System.out.print("Id Barang : ");
        int id = inputAngka();
        
        for(int i=0;i<barang.size();i++){
            if(id == barang.get(i).getIdBarang()){
                barang.remove(i);
            }
        }
        System.out.println("Berhasil Menghapus !");
        menuKelolaDataBarang();
    }
    
    void ubahDataBarang(){
        lihatDaftarBarang();
        System.out.print("Id Barang : ");
        int id = inputAngka();
        
        System.out.print("Nama Barang  : ");
        String namaBarang = masukan.next();
        System.out.println(" Jenis yang tersedia : ");
        System.out.println(" Elektronik, Pakaian, Makanan, Minuman;");
        System.out.print("Jenis Barang : ");
        String jenisBarang = masukan.next();
        System.out.print("Harga Barang : ");
        int hargaBarang = inputAngka();
        System.out.print("Stok Barang  : ");
        int stokBarang = inputAngka();
        
        /* Implementasi Exception */
        try{
            for(int i=0;i<barang.size();i++){
                if(id==barang.get(i).getIdBarang()){
                    barang.get(i).setJenisBarang(JenisBarang.valueOf(jenisBarang));
                    barang.get(i).setNamaBarang(namaBarang);
                    barang.get(i).setStokBarang(stokBarang);
                    barang.get(i).setHargaBarang(hargaBarang);
                    System.out.println("Berhasil Mengubah !");
                    menuKelolaDataBarang();
                }
            }
                    
        }catch(IllegalArgumentException a){   
            System.out.println("Gagal Mengubah");
            System.out.println("------------------------ Enum Fault ------------------------");
            System.out.println(" Jenis yang tersedia : ");
            System.out.println(" Elektronik, Pakaian, Makanan, Minuman;");
            System.out.println("------------------------------------------------------------");
            menuKelolaDataBarang();
            
        } 
    }
    
    void tambahStokBarang(){
        lihatDaftarBarang();
        System.out.print("ID : ");
        int id = inputAngka();
        System.out.print("Stok yanng ingin ditambahkan : ");
        int stok = inputAngka();
        for(int i=0;i<barang.size();i++){
            if(id == barang.get(i).getIdBarang()){
                int stokBaru = stok + barang.get(i).getStokBarang();
                barang.get(i).setStokBarang(stokBaru);
            }
        }
        System.out.println("Berhasil menambahkan stok !");
        menuKelolaDataBarang();
    }
    
    void lihatDaftarBarang(){
        System.out.println("================================== List Barang ================================");
        for(int i=0; i<barang.size();i++){
            
            System.out.println(
                "|| Id : "+barang.get(i).getIdBarang()+
                " | Nama : "+barang.get(i).getNamaBarang()+
                " | Jenis : "+barang.get(i).getJenisBarang()+
                " | Harga : "+barang.get(i).getHargaBarang()+
                " | Stok : "+barang.get(i).getStokBarang()+" ||"
            );
            
        }
        System.out.println("===============================================================================");
        
    }
    
    void lihatDataPenjualan(){
        System.out.println("============================================================== Penjualan ==============================================================");
        for(int i=0;i<penjualan.size();i++){
            
            System.out.println(
                "|| Id : "+penjualan.get(i).getIdPenjualan()+
                " | Pelanggan : "+penjualan.get(i).getNamaPelanggan()+
                " | Driver : "+penjualan.get(i).getNamaDriver()+
                " | Nama Barang : "+penjualan.get(i).getNamaBarang()+
                " | Harga : "+penjualan.get(i).getHargaBarang()+
                " | Jumlah : "+penjualan.get(i).getJumlahPesanan()+
                " | Total : "+penjualan.get(i).getTotalPembayaran()+" ||"
                
                
            );
            
        }
        System.out.println("=======================================================================================================================================");
        
    }
    
    void lihatDataDriver(){
        System.out.println("======================= Data Driver =======================");
        for(int i=0; i<driver.size();i++){
            
            
            System.out.println(
                "|| ID : "+driver.get(i).getDriverID()+
                " | Nama : "+driver.get(i).getNamaDriver()+
                " | Alamat : "+driver.get(i).getAlamatDriver()+" ||"
            );
        }
        System.out.println("===========================================================");
        
    }
    
    void lihatDataPelanggan(){
        System.out.println("====================== Data Pelanggan =====================");
        for(int i=0; i<pelanggan.size();i++){           
            System.out.println(
                "|| ID : "+pelanggan.get(i).getIdPelanggan()+
                " | Nama : "+pelanggan.get(i).getNamaPelanggan()+
                " | Alamat : "+pelanggan.get(i).getAlamatPelanggan()+" ||"
            );
        }
        System.out.println("===========================================================");
        
    }
    
    void menuDriver(int idDriver,String namaDriver){
        System.out.println("==========  Menu Driver =========");
        System.out.println("+ 1. Antar Barang               +");
        System.out.println("+ 2. Lihat Bukti Pengantaran    +");
        System.out.println("+ 3. Lihat Daftar Pesanan       +");
        System.out.println("+ 4. Keluar                     +");
        System.out.println("=================================");
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                antarBarang(idDriver,namaDriver);
                break;
            case 2:
                lihatBuktiPengantaran(idDriver,namaDriver);
                menuDriver(idDriver,namaDriver);
                break;
            case 3:                
                lihatPemesanan();
                menuDriver(idDriver,namaDriver);
                break;
            case 4:
                opsi = 0;
                menuUtama();
                break;
            default:   
                System.out.println("Menu tidak tersedia!");
                menuAdmin();
                break;
        }
    }
    void addPenjualan(int idDriver,int idPemesanan){
        int idPenjualan = penjualan.size()+1;
        int indexDriver = indexDriver(idDriver);
        int indexPemesanan = indexPemesanan(idPemesanan);
        penjualan.add(new Penjualan(idPenjualan,driver.get(indexDriver).getDriverID(),  driver.get(indexDriver).getNamaDriver(),pemesanan.get(indexPemesanan).getIdPelanggan(),  pemesanan.get(indexPemesanan).getNamaPelanggan(), idPemesanan,  pemesanan.get(indexPemesanan).getNamaBarang(),pemesanan.get(indexPemesanan).getHargaBarang(), pemesanan.get(indexPemesanan).getJumlahPesanan(), pemesanan.get(indexPemesanan).getBiayaPengiriman(),pemesanan.get(opsi).getTotalPembayaran()));
    }
    
    void antarBarang(int idDriver,String namaDriver){
        if(!pemesanan.isEmpty()){
            lihatPemesanan();
        }else{
            System.out.println("Tidak ada Pemesanan");
            menuDriver(idDriver,namaDriver);
        }
        
        
        int idPengantaran = pengantaran.size()+1;
        System.out.print("Id Pesanan : ");        
        int idPemesanan = inputAngka();
       
        int indexPemesanan = indexPemesanan(idPemesanan);
        String namaBarang = pemesanan.get(indexPemesanan).getNamaBarang();
        System.out.print("Penerima   : ");
        String penerima = masukan.next();
        
        pengantaran.add(new Pengantaran(idPengantaran, idPemesanan, namaBarang, idDriver, penerima));
        
        addPenjualan(idDriver,idPemesanan);
        pemesanan.get(indexPemesanan).setStatusPemesanan("diantar");
        System.out.println("Berhasil mengantar barang");
        menuDriver(idDriver,namaDriver);
    }
        
    void lihatBuktiPengantaran(int idDriver,String namaDriver){
        
        System.out.println("================================ Bukti Pengantaran ================================");
        for(int i=0; i<pengantaran.size();i++){
            
            System.out.println(
                "|| Id : "+pengantaran.get(i).getIdPegantaran()+
                " | Pengantar : "+namaDriver+
                " | Barang : "+pengantaran.get(i).getNamaBarang()+
                " | Penerima : "+pengantaran.get(i).getPenerima()+" ||"
            );
           
        }
        System.out.println("===================================================================================");
        
    }
    
    void menuPelanggan(int idPelanggan,String namaPelanggan){
        System.out.println("========  Menu pelanggan ========");
        System.out.println("+ 1. Buat Pemesanan             +");
        System.out.println("+ 2. Batalkan Pemesanan         +");
        System.out.println("+ 3. Ubah Pemesanan             +");
        System.out.println("+ 4. Lihat Pemesanan            +");
        System.out.println("+ 5. Cari Barang                +");
        System.out.println("+ 6. Keluar                     +");
        System.out.println("=================================");
        System.out.print("\nPilihan : ");
        opsi = inputAngka();
        
        switch(opsi){
            case 1:
                buatPemesanan(idPelanggan,namaPelanggan);
                break;
            case 2:
                batalkanPemesanan(idPelanggan,namaPelanggan);
                menuPelanggan(idPelanggan,namaPelanggan);
                break;
            case 3:                
                ubahPemesanan(idPelanggan,namaPelanggan);
                break;
            case 4:                
                lihatPemesanan(idPelanggan,namaPelanggan);
                menuPelanggan(idPelanggan,namaPelanggan);
                break;
            case 5:                
                cariBarang();
                menuPelanggan(idPelanggan,namaPelanggan);
                break;
            case 6:
                opsi = 0;
                menuUtama();
                break;
            default:  
                System.out.println("Menu tidak tersedia!");
                menuPelanggan(idPelanggan,namaPelanggan);
                break;
        }
    }
    
    void buatPemesanan(int idPelanggan, String namaPelanggan){
        lihatDaftarBarang();
        
        System.out.print("Id Barang : ");
        int idBarang = inputAngka();
        System.out.print("Jumlah Barang : ");
        int jumlahBarang = inputAngka();
        System.out.println("Kota tujuan ");
        System.out.println("balige,laguboti,medan,siantar,porsea,jakarta");
        System.out.print("Kota Tujuan : ");
        String kotaTujuan = masukan.next();
        int idPemesanan = pemesanan.size()+1;
        int biayaPengiriman = biayaPengiriman(kotaTujuan);
        
        int indexBarang = indexBarang(idBarang);
        
        if(indexBarang>=0){
            if(idBarang == barang.get(indexBarang).getIdBarang()){            

                int total = (barang.get(indexBarang).getHargaBarang()*jumlahBarang)+biayaPengiriman;
                String statusPemesanan = "Dikemas";
                    
                if(idBarang == barang.get(indexBarang).getIdBarang()){                    
                    pemesanan.add(new Pemesanan(idPemesanan,idPelanggan, namaPelanggan, idBarang,barang.get(indexBarang).getNamaBarang(),barang.get(indexBarang).getHargaBarang(), jumlahBarang,Kota.valueOf(kotaTujuan), biayaPengiriman, total,statusPemesanan));
                    menuPelanggan(idPelanggan,namaPelanggan);
                }


            }else{
                System.out.println("Stok tidak tersedia");
                buatPemesanan(idPelanggan,namaPelanggan);
            }
        }else{
            System.out.println("barang tidak tersedia!");
        }
        
        
    }
    
    int biayaPengiriman(String kotaTujuan){
        
        switch(kotaTujuan){
            case "balige":
                return 40000;
            case "laguboti":
                return 12000;
            case "medan":
                return 100000;
            case "siantar":
                return 90000;
            case "porsea":
                return 24000;
            case "jakarta":
                return 29000;
            default:
                return 0;    
            
                
        }
    }
    
    void batalkanPemesanan(int idPelanggan,String namaPelanggan){
        
        lihatPemesanan(idPelanggan,namaPelanggan);
        System.out.print("ID : ");
        int id = inputAngka();
        for(int i=0;i<pemesanan.size();i++){
            if(id == pemesanan.get(i).getIdPemesanan()){
                pemesanan.get(i).setStatusPemesanan("Dibatalkan");
                
            }
        }
        
        
    }
    
    void ubahPemesanan(int idPelanggan,String namaPelanggan){
        lihatPemesanan(idPelanggan,namaPelanggan);
        System.out.print("ID : ");
        int id = inputAngka();
        System.out.print("Jumlah Barang : ");
        int jumlahBarang = inputAngka();
        
        for(int i=0;i<pemesanan.size();i++){
            if(id == pemesanan.get(i).getIdPemesanan()){
                pemesanan.get(i).setJumlahPesanan(jumlahBarang);
                menuPelanggan(idPelanggan,namaPelanggan);
            }
        }
        
    }
    
    void lihatPemesanan(int idPelanggan,String namaPelanggan){
        System.out.println("================================================================== Daftar  Pemesanan ==================================================================");        
        for(int i=0; i<pemesanan.size();i++){
            
            if(pemesanan.get(i).getIdPelanggan()==idPelanggan){
                System.out.println(
                    "|| Id : "+pemesanan.get(i).getIdPemesanan()+
                    " | Nama Barang : "+pemesanan.get(i).getNamaBarang()+
                    " | Harga Barang : "+pemesanan.get(i).getHargaBarang()+
                    " | Jumlah Barang : "+pemesanan.get(i).getJumlahPesanan()+
                    " | Ongkir : "+pemesanan.get(i).getBiayaPengiriman()+
                    " | Status Pemesanan : "+pemesanan.get(i).getStatusPemesanan()+                
                    " | Total Pembayaran : "+pemesanan.get(i).getTotalPembayaran()+" ||"
                );
            }
        }
        System.out.println("=======================================================================================================================================================");
        
    }
    void lihatPemesanan(){
        System.out.println("================================================================== Daftar  Pemesanan ==================================================================");
        for(int i=0; i<pemesanan.size();i++){
            
            
            System.out.println(
                "|| Id : "+pemesanan.get(i).getIdPemesanan()+
                " | Nama Barang : "+pemesanan.get(i).getNamaBarang()+
                " | Harga Barang : "+pemesanan.get(i).getHargaBarang()+
                " | Jumlah Barang : "+pemesanan.get(i).getJumlahPesanan()+
                " | Tujuan : "+pemesanan.get(i).getKotaTujuan()+
                " | Ongkir : "+pemesanan.get(i).getBiayaPengiriman()+
                " | Status : "+pemesanan.get(i).getStatusPemesanan()+
                " | Total Pembayaran : "+pemesanan.get(i).getTotalPembayaran()+" ||"
            );
           
        }
        System.out.println("=======================================================================================================================================================");
        
    }
    
    void cariBarang(){
        System.out.print("Nama barang : ");
        String namaBarang =masukan.next();
        System.out.println("Hasil Pencarian : ");
        System.out.println("================================ Hasil Pencarian ==============================");
        for(int i=0;i<barang.size();i++){
            if(barang.get(i).getNamaBarang().equals(namaBarang)){
                System.out.println(
                    "|| Id : "+barang.get(i).getIdBarang()+
                    " | Nama : "+barang.get(i).getNamaBarang()+
                    " | Jenis : "+barang.get(i).getJenisBarang()+
                    " | Harga : "+barang.get(i).getHargaBarang()+
                    " | Stok : "+barang.get(i).getStokBarang()+" ||"
                );
            }
        }
        System.out.println("===============================================================================");        
        
        
    }
    /* Implementasi Exception */
    public static int inputAngka(){
        while (true){
            try{
                return masukan.nextInt();
            }catch (InputMismatchException e){
                masukan.next();
                System.out.println("Masukkan hanya angka!");
                System.out.print("=> ");
            }
        }
    }

    private int indexBarang(int idBarang) {
        int index=0;
        for(int i=0;i<barang.size();i++){
            if(idBarang == barang.get(i).getIdBarang()){
                index=i;
            }
        }
        return index;
    }
        
    int indexPemesanan(int idPemesanan){
        int index=0;
        for(int i=0;i<pemesanan.size();i++){
            if(idPemesanan==pemesanan.get(i).getIdPemesanan()){
                index=i;
            }
        }
        return index;
    }

     int indexDriver(int idDriver) {
        int index=0;
        for(int i=0;i<driver.size();i++){
            if(idDriver == driver.get(i).getDriverID()){
                index=i;
            }
        }
        return index;
    }
}
