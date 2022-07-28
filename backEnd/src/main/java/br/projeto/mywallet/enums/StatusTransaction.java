package br.projeto.mywallet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author wilson
 */
public enum StatusTransaction {
   
    PAID("PAID"),
    
    NOPAID("NOPAID");
    
    private String statusTransaction;
    private StatusTransaction(String statusTransaction){
        this.statusTransaction = statusTransaction;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    
    
    
   
    
    
}
