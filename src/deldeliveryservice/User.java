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
public class User implements Akun{
    
    
    private int userID;
    private int userSesion;
    private String username;
    private String password;

    public User(int userID, int userSesion, String username, String password) {
        this.userID = userID;
        this.userSesion = userSesion;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserSesion() {
        return userSesion;
    }

    public void setUserSesion(int userSesion) {
        this.userSesion = userSesion;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;    
    }
    
    
    
    
}
