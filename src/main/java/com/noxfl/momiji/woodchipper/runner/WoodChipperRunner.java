package com.noxfl.momiji.woodchipper.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class WoodChipperRunner implements CommandLineRunner {

    private ConfigurableApplicationContext context;

    @Autowired
    public void setContext(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {


        context.close();

    }
}
