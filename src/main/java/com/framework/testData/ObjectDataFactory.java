package com.framework.testData;

import com.framework.models.request.Data;
import com.framework.models.request.ObjectRequest;
import lombok.Builder;

@Builder
public class ObjectDataFactory {

    public static ObjectRequest validateObject(){

        Data data = Data.builder()
                .year(2019)
                .price(1849.99)
                .cpuModel("Intel Core i9")
                .hardDiskSize("1 TB") .build();

        return ObjectRequest.builder()
                .name("Apple MacBook Pro 16")
                .data(data) .build();
    }

    public static ObjectRequest nullName(){
        return validateObject().toBuilder()
                .name(null)
                .build();
    }

    public static ObjectRequest emptyName(){
        return validateObject().toBuilder()
                .name("")
                .build();
    }

    public static ObjectRequest missingName(){
        return ObjectRequest.builder()
                .data(validateObject().getData())
                .build();
    }

    public static ObjectRequest nullCpuModel(){
        return validateObject().toBuilder()
                .data(
                        validateObject().getData().toBuilder()
                                .cpuModel(null)
                                .build()
                ).build();
    }

    public static ObjectRequest emptyCpuModel(){
        return validateObject().toBuilder()
                .data(
                        validateObject().getData().toBuilder()
                                .cpuModel("")
                                .build()
                ).build();
    }

    public static ObjectRequest missingCpuModel(){
        Data data = Data.builder()
                .year(2019)
                .price(1300.99)
                .hardDiskSize("1 TB")
                .build();
        return validateObject().toBuilder()
                .data(data)
                .build();

    }

    public static ObjectRequest nullHardDiskSize(){
        return validateObject().toBuilder()
                .data(
                        validateObject().getData().toBuilder()
                                .hardDiskSize(null)
                                .build()
                ).build();
    }

    public static ObjectRequest emptyHardDiskSize(){
        return validateObject().toBuilder()
                .data(
                        validateObject().getData().toBuilder()
                                .hardDiskSize("")
                                .build()
                ).build();
    }

    public static ObjectRequest missingHardDiskSize(){
        Data data = Data.builder()
                .year(2019)
                .price(1300.99)
                .cpuModel("Intel Core i8")
                .build();
        return validateObject().toBuilder()
                .data(data)
                .build();

    }

    public static ObjectRequest nullYear(){
        return validateObject().toBuilder()
                .data(
                    validateObject().getData().toBuilder()
                            .year(null)
                            .build()
                ).build();
    }

    public static ObjectRequest missingYear(){
        Data data = Data.builder()
                .price(1300.99)
                .cpuModel("Intel Core i9")
                .hardDiskSize("1 TB")
                .build();
        return validateObject().toBuilder()
                .data(data)
                .build();
    }

    public static ObjectRequest nullPrice(){
        return validateObject().toBuilder()
                .data(
                        validateObject().getData().toBuilder()
                                .price(null)
                                .build()
                ).build();
    }

    public static ObjectRequest missingPrice(){
        Data data = Data.builder()
                .year(2020)
                .cpuModel("Intel Core i9")
                .hardDiskSize("1 TB")
                .build();
        return validateObject().toBuilder()
                .data(data)
                .build();
    }
}
