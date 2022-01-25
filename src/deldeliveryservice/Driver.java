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
public class Driver {
    
    private int driverID;
    private int userID;
    private String namaDriver;
    private String alamatDriver;  

    public Driver(int driverID, int userID, String namaDriver, String alamatDriver) {
        this.driverID = driverID;
        this.userID = userID;
        this.namaDriver = namaDriver;
        this.alamatDriver = alamatDriver;
    }
    
    
   

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }

    public String getAlamatDriver() {
        return alamatDriver;
    }

    public void setAlamatDriver(String alamatDriver) {
        this.alamatDriver = alamatDriver;
    }
    
    
}
