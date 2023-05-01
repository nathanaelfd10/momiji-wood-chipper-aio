package com.noxfl.momiji.woodchipper.model.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SelectorMap {

    private final String productsSelector;
    private final String productUrlSelector;
    private final String productUrlSelectorAttribute;

}
