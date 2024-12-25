package com.restapi.dummy.employees;

import com.restapi.dummy.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteEmployee extends TestBase {


    @Test
    public void deleteEmployee(){

        given().log().all()
                .header("cookie", "humans_21909=1")
                .header("Content-Type","application/json")
                .pathParam("id",7)
                .when()
                .delete("/delete/{id}")
                .then()
                .statusCode(204);



    }
}
