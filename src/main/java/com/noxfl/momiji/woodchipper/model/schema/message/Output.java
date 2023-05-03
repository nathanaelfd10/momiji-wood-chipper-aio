package com.noxfl.momiji.woodchipper.model.schema.message;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Output {

    private String productUrl;
    private String rawContent;
    private String timestamp;

}
