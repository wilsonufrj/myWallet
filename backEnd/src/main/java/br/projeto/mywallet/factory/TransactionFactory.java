/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.factory;

import br.projeto.mywallet.Model.Gain;
import br.projeto.mywallet.Model.Spend;
import br.projeto.mywallet.coreInterfaces.Transaction;

/**
 *
 * @author wilson
 */
public class TransactionFactory {

    public static Transaction transaction(String typeTransaction) {
        switch (typeTransaction) {
            case ("gain"):
                return new Gain();
            case ("spend"):
                return new Spend();
            default:
                throw new IllegalArgumentException();

        }
    }
}
