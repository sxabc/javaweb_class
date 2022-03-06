package com.example.test2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class brand {
    private Integer id;
    private String BrandName;
    private String CompanyName;
    private Integer ordered;
    private String description;
    private Integer status;
}
