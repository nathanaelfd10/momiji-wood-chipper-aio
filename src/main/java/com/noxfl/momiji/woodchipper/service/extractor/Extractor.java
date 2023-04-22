package com.noxfl.momiji.woodchipper.service.extractor;

import java.util.HashMap;

public interface Extractor {

    public HashMap<String, Object> extract(String content);

}