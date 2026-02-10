package com.framework.client;

import com.framework.config.ConfigReader;
import com.framework.constants.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.rmi.server.ExportException;

import static io.restassured.RestAssured.given;

public class BaseClient {
    protected RequestSpecification spec;

    public BaseClient(){
        this.spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base.url"))
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    protected Response doPost(String endpoint, Object body){
        try {
            return given()
                    .spec(spec)
                    .body(body)
                    .post(endpoint);
        }catch (Exception e){
            throw new RuntimeException("POST " + endpoint + " failed", e);
        }
    }

    protected Response doGet(String endpoint){
        try {
            return given()
                    .spec(spec)
                    .get(endpoint);
        }catch (Exception e){
            throw new RuntimeException("GET " + endpoint + " failed", e);
        }
    }

    protected Response doPut(String endpoint, Object body){
        try {
            return given()
                    .spec(spec)
                    .body(body)
                    .put(endpoint);
        }catch (Exception e){
            throw new RuntimeException("PUT " + endpoint + " failed", e);
        }
    }

    protected Response doDelete(String endpoint){
        try {
            return given()
                    .spec(spec)
                    .delete(endpoint);
        }catch (Exception e){
            throw new RuntimeException("DELETE " + endpoint + " failed", e);
        }
    }
}
