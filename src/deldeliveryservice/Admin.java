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
public class Admin implements Akun{
    private final String username = "admin";
    private final String password = "admin";

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return username;
    }
    
    
    
    
    
    
}
