package com.noxfl.momiji.woodchipper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class WoodchipperRunner implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        int timeout = 1000 * 3600; // 1 second * 3600 seconds (1 hour)
        System.out.printf("Running for: %s hour\n", timeout / 3600000);
        Thread.sleep(timeout);
        context.close();
    }
}
