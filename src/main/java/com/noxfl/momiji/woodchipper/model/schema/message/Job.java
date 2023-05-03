package com.noxfl.momiji.woodchipper.model.schema.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {

    private String jobId;
    private String name;
    private Site site;
    private Category category;
    private String targetUrl;
    private PageType pageType;
    private int minPage;
    private int maxPage;
    private ContentType contentType;
    private boolean isScrapeDetail;
    private boolean isSaveOrderOfAppearanceIndex;
    private Content content;

}
