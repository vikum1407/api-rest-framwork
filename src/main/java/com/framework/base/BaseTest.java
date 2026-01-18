package com.framework.base;

import com.framework.config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("base.url");
    }

}
