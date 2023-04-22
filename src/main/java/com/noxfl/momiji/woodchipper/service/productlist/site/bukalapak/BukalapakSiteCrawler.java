package com.noxfl.momiji.woodchipper.service.productlist.site.bukalapak;


import com.noxfl.momiji.woodchipper.service.productlist.site.GenericSiteCrawler;

public abstract class BukalapakSiteCrawler extends GenericSiteCrawler {

    public BukalapakSiteCrawler() {
        this.setPaginationStart(1);
    }

}
