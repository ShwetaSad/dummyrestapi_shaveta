package com.restapi.dummy.employees;

import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

import static io.restassured.RestAssured.given;

public class VerifyData extends TestBase {

    @Test
    public void VerifyData(){

        Response response = given()
                .header("cookie", "humans_21909=1")
                .when()
                .get("/employees");
        //Verify Total records are 24
        Assert.assertEquals(response.jsonPath().getList("data").size(), 24);

        //Verify data[23].id = 24
        Assert.assertEquals(response.jsonPath().getInt("data[23].id"), 24);

        //Verify data[23].employee_name = 'Doris Wilder
        Assert.assertEquals(response.jsonPath().getString("data[23].employee_name"), "Doris Wilder");

        //Verify message = 'Successfully! All records has been fetched.
        Assert.assertEquals(response.jsonPath().getString("message"), "Successfully! All records has been fetched.");

        //Verify status = success
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        //Verify id = 3 has employee_salary = 86000
        Assert.assertEquals(response.jsonPath().getInt("data[2].employee_salary"), 86000);

    }
}
