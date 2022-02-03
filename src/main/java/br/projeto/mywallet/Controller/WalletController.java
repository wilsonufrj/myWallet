/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Controller;

import br.projeto.mywallet.Model.Gain;
import br.projeto.mywallet.Model.Spend;
import java.util.List;

import br.projeto.mywallet.repository.GainRepository;
import br.projeto.mywallet.repository.SpendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilson
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private SpendRepository spendRepository;

    @Autowired
    private GainRepository gainRepository;

    @GetMapping
    public double allMoney(){
        List<Gain> gains= gainRepository.findAll();
        double totalGains = 0;

        for(Gain gain:gains) {
            totalGains+=gain.getValue();
        }

        List<Spend> spends = spendRepository.findAll();
        double totalSpends = 0;

        for(Spend spend:spends){
            totalSpends+=spend.getValue();
        }

        double total = totalGains - totalSpends;
        return total;
    }
    
    
}
