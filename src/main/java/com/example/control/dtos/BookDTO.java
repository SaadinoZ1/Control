package com.example.control.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor@Builder
public class BookDTO {
    private String title ;
    private String publisher ;
    private Date date_Publication;
    private Float price;

}
