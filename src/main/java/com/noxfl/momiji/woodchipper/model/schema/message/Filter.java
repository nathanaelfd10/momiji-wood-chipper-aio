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
    private String minRatingParameterKey;

    private double maxRating;
    private String maxRatingParameterKey;

    private String byKeyword;
    private String byKeywordParameterKey;

    private List<CustomParam> customFilters;

}
