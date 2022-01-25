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
public enum JenisBarang {
    Elektronik,Pakaian,Makanan,Minuman;

    @Override
    public String toString() {
        switch(this){
            case Elektronik:
                return "Elektronik";
            case Pakaian:
                return "Pakaian";
            case Makanan:
                return "Makanan";
            case Minuman:
                return "Minuman";
            default:
                return "JenisBarang";
        }
    }
    
    
}
