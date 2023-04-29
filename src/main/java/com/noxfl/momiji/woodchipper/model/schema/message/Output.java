package com.noxfl.momiji.woodchipper.model.schema.message;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Output {

    String productUrl;
    String rawContent;
    String timestamp;
    int foundAtPage;
    int orderOfAppearanceIndex;

}
