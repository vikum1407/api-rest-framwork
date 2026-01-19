package com.framework.client;

import com.framework.constants.Endpoints;
import com.framework.models.request.ObjectRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ObjectClient {

    public Response createObject(ObjectRequest request){
        return given()
                .contentType("application/json")
                .body(request)
                .post(Endpoints.OBJECT);
    }
}
