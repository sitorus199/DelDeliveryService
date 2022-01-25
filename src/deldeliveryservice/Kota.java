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
public enum Kota {
    balige,laguboti,medan,siantar,porsea,jakarta;

    @Override
    public String toString() {
        switch(this){
            case balige:
                return "Balige";
            case laguboti:
                return "Laguboti";
            case medan:
                return "Medan";
            case siantar:
                return "Siantar";
            case porsea:
                return "Porsea";
            case jakarta:
                return "Jakarta";
            default:
                return "null";
        }
    }
}
