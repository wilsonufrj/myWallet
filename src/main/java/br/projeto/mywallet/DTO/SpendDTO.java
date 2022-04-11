package br.projeto.mywallet.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpendDTO {
    private Long id;
    private Double value;
    private String day;
    private String location;
    private String description;
    private boolean itMonthly;
}
