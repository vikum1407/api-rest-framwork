package com.framework.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * This is for nested JSON body
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Data {
    private Integer year;
    private Double price;

    /**
     * @JsonProperty is mandatory for space-containing fields.
     */
    @JsonProperty("CPU Model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;

}
