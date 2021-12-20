/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.Model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author wilson
 */

@Data
public class Spend {
    private Double value;
    private Date dia;
    private String location;
    private String description;
    
}
