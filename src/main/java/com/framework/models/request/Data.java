package com.framework.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class Data {
    private int year;
    private double price;

    /**
     * @JsonProperty is mandatory for space-containing fields.
     */
    @JsonProperty("CPU Model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;

}
