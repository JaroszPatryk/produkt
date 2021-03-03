package com.pjarosz.zadanierekrutacyjne.domain.credit;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Product {

    @Setter
    private Long id;
    @NotBlank
    private String nameProduct;
    @NotBlank
    private String valueProduct;

}
