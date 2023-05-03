package com.noxfl.momiji.woodchipper.worker.productlist.site;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageSender;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.util.DateTimeUtils;
import com.noxfl.momiji.woodchipper.worker.productlist.SiteCrawler;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericSiteCrawler implements SiteCrawler {

    private MessageSender messageSender;

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    private List<Output> jobOutputs = new ArrayList<>();

    protected int paginationStart;

    protected int page;

    protected String pageUrl;

    protected String lastJobId;

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

    protected abstract List<Output> fetch(MomijiMessage momijiMessage) throws IOException, URISyntaxException;

    @Override
    public List<Output> fetchProducts(MomijiMessage momijiMessage) throws IOException, URISyntaxException {

        String currentJobId = momijiMessage.getJob().getJobId();

        // Resets if received Message is different from the last one
        if(lastJobId != null && !lastJobId.equalsIgnoreCase(currentJobId)) {
            jobOutputs = new ArrayList<>();
            this.page = momijiMessage.getJob().getMinPage();
            this.pageUrl = momijiMessage.getJob().getTargetUrl();
        }

        List<Output> outputContents = fetch(momijiMessage);

        for(Output output : outputContents) {
            if(output.getTimestamp() == null || output.getTimestamp().isBlank())
                output.setTimestamp(DateTimeUtils.getCurrentUtcDateTime());
            momijiMessage.getJob().getContent().setOutput(output);
            messageSender.send(momijiMessage);
        }

        this.lastJobId = currentJobId;

        this.nextPage();

        if (this.getCurrentPage() <= momijiMessage.getJob().getMaxPage())
            fetchProducts(momijiMessage);

        return jobOutputs;
    }

}
