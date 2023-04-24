package com.noxfl.momiji.woodchipper.worker.extractor;

import java.util.HashMap;

public interface Extractor {

    public HashMap<String, Object> extract(String content);

}