/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.mywallet.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

/**
 *
 * @author wilson
 */

@Configuration
public class ModelMapperConfig {
 
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
