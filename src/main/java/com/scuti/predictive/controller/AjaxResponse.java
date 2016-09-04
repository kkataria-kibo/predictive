package com.scuti.predictive.controller;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class AjaxResponse implements Serializable {

    private static final long serialVersionUID = 43046535757506875L;

    @Setter(AccessLevel.NONE)
    private HashMap<String, Object> properties = new HashMap<>();

    private Boolean success;
    private String message;
    private String html;

    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

}