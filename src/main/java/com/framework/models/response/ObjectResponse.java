package com.framework.models.response;

import lombok.Data;

@Data
public class ObjectResponse {
    private String id;
    private String name;
    private String createAt;
    private DataResponse data;
}
