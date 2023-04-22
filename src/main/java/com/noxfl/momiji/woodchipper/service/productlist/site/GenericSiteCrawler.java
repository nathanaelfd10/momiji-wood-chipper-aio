package com.noxfl.momiji.woodchipper.service.productlist.site;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageSender;
import com.noxfl.momiji.woodchipper.model.schema.message.Content;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.service.productlist.SiteCrawler;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GenericSiteCrawler implements SiteCrawler {

    private MessageSender messageSender;

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    private List<Content> jobOutputs = new ArrayList<>();

    private int paginationStart;

    private int page;

    private String pageUrl;

    private String lastJobId;

    public GenericSiteCrawler() {
        this.paginationStart = 1; // Default is 1
        this.page = this.paginationStart;
    }

    protected void nextPage() {
        this.page++;
    }

    protected void previousPage() {
        this.page--;
    }

    protected int getCurrentPage() {
        return page;
    }

    protected void setPaginationStart(int paginationStart){
        this.paginationStart = paginationStart;
    }

    protected abstract List<Content> fetch(MomijiMessage momijiMessage) throws IOException, URISyntaxException;

    @Override
    public List<Content> fetchProducts(MomijiMessage momijiMessage) throws IOException, URISyntaxException {

        // Resets if received Message is different from the last one
        if(!lastJobId.equalsIgnoreCase(momijiMessage.getJob().getJobId()))
            jobOutputs = new ArrayList<>();

        // Logic here
        List<Content> outputContents = fetch(momijiMessage);

        for(var content : outputContents) {
            momijiMessage.getJob().setContent(content);

            messageSender.send(momijiMessage);
        }

        this.lastJobId = momijiMessage.getJob().getJobId();

        this.nextPage();

        if (this.getCurrentPage() <= momijiMessage.getJob().getMaxPage())
            fetchProducts(momijiMessage);

        return jobOutputs;
    }

}
