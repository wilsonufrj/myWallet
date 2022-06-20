/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 *
 * @author wilson
 */
//
//@Entity
//@Table(name="wallet")
//public class Wallet {
//    
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//    private Double allMoney;
//
//    @OneToMany(
//            mappedBy = "wallet",
//            targetEntity = Transaction.class,
//            cascade = CascadeType.ALL
//    )
//    private List<Transaction> transactions;
//
//    
//}
