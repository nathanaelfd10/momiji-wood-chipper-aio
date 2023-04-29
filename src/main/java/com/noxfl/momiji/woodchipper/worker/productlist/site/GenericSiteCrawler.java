package com.noxfl.momiji.woodchipper.worker.productlist.site;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageSender;
import com.noxfl.momiji.woodchipper.model.schema.message.CustomParam;
import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import com.noxfl.momiji.woodchipper.model.schema.message.Output;
import com.noxfl.momiji.woodchipper.worker.TargetUrlBuilder;
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

    TargetUrlBuilder targetUrlBuilder = new TargetUrlBuilder();

    public GenericSiteCrawler(TargetUrlBuilder targetUrlBuilder) {
        this.targetUrlBuilder = targetUrlBuilder;
    }

    private List<Output> jobOutputs = new ArrayList<>();
    protected int paginationStart = 1; // Default is 1
    protected int page = paginationStart;
    protected String targetUrl;
    protected String lastJobId;

    protected String urlPaginationParamKey = "page";

    protected void setUrlPaginationParamKey(String urlPaginationParamKey) {
        this.urlPaginationParamKey = urlPaginationParamKey;
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

    protected abstract List<Output> fetch(String targetUrl, boolean isSaveOrderOfAppearanceIndex) throws IOException, URISyntaxException;

    @Override
    public List<Output> fetchProducts(MomijiMessage momijiMessage) throws IOException, URISyntaxException {

        String currentJobId = momijiMessage.getJob().getJobId();

        // Resets if received Message is different from the last one
        if(lastJobId != null && !lastJobId.equalsIgnoreCase(currentJobId)) {
            jobOutputs = new ArrayList<>();
            this.page = momijiMessage.getJob().getMinPage();
            this.targetUrl = momijiMessage.getJob().getTargetUrl();
        }

        List<CustomParam> customParams = new ArrayList<>();
        customParams.add(new CustomParam("page", String.valueOf(page)));

        String targetUrl = targetUrlBuilder.build(this.targetUrl, momijiMessage.getJob().getFilter(), customParams);

        System.out.println("Crawling from URL: " + targetUrl);

        List<Output> outputs = fetch(targetUrl, momijiMessage.getJob().isSaveOrderOfAppearanceIndex());

        for(Output output : outputs) {
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
