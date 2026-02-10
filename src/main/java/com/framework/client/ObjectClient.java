package com.framework.client;

import com.framework.constants.Endpoints;
import com.framework.models.request.ObjectRequest;
import com.framework.models.response.ObjectResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ObjectClient extends BaseClient{

    /**
     * POST Method
     */
    public Response createObject(ObjectRequest request){
        return doPost(Endpoints.OBJECT, request);
    }

    /**
     * GET Method
     * @return
     */
    public Response getObject(int id){
        return doGet(Endpoints.OBJECT_BY_ID + "/" + id);
    }

    /**
     * PUT Method
     * @param request
     * @return
     */
    public Response putObject(int id, ObjectRequest request){
        return doPut(Endpoints.OBJECT_BY_ID + "/" + id , request);
    }

    /**
     * DELETE Method
     * @return
     */
    public Response getDelete(int id){
        return doDelete(Endpoints.OBJECT_BY_ID + "/" + id);
    }

    public ObjectResponse createResponseObject(ObjectRequest request){
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .post(Endpoints.OBJECT)
                    .then()
                    .statusCode(200)
                    .extract().as(ObjectResponse.class);
        }catch (Exception e){
            throw new RuntimeException("Found an error", e);
        }
    }
}
