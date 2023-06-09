package com.noxfl.momiji.woodchipper.model.schema.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Content {

    Output output;
    List<ExtraContent> extraContents;

}
