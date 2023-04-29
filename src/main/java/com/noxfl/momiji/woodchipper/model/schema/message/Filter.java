package com.noxfl.momiji.woodchipper.model.schema.message;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Filter {

    private double minRating;
    private double maxRating;
    private List<CustomParam> customFilters;

}
