package com.framework.tests.user;

import com.framework.client.ObjectClient;
import com.framework.models.request.Data;
import com.framework.models.request.ObjectRequest;
import com.framework.models.response.ObjectResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateObjectTest {

    @Test
    public void createObjectTest() {
        Data data = new Data();
        data.setYear(2019);
        data.setPrice(1849.99);
        data.setCpuModel("Intel Core i9");
        data.setHardDiskSize("500GB SSD");

        ObjectRequest request = new ObjectRequest();
        request.setData(data);
        request.setName("Apple MacBook Pro 16");

        ObjectClient client = new ObjectClient();

        ObjectResponse response =
                client.createObject(request)
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ObjectResponse.class);

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getName(), request.getName());
        Assert.assertEquals(response.getData().getYear(), 2019);
    }


}
