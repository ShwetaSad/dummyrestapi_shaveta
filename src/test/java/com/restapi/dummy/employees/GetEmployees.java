package com.restapi.dummy.employees;

import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetEmployees extends TestBase {

    @Test
    public void getEmployees(){
            Response response = given()
                    .header("cookie", "humans_21909=1")
                    .when()
                    .get("/employees");
            response.prettyPrint();
            response.then().statusCode(200);
        }

        @Test
        public void getSingleEmployee(){
        Response response = given()
             .header("cookie", "humans_21909=1")
                .pathParam("id",1)
                .when()
                .get("/employee/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
        }
    }

