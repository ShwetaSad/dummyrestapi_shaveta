package com.restapi.dummy.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void inIt(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        RestAssured.basePath = "/api/v1";
    }


}