package com.framework.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataResponse {
    private int year;
    private double price;

    @JsonProperty("CPU Model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;
}
