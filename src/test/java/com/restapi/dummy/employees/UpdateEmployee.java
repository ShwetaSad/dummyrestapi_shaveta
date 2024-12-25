package com.restapi.dummy.employees;

import com.restapi.dummy.model.EmployeePojo;
import com.restapi.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateEmployee extends TestBase {

    @Test
    public void updateEmployee(){

        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("shaveta");
        employeePojo.setEmployee_age(32);
        employeePojo.setEmployee_salary(345678);

        Response response = given()
                .header("cookie", "humans_21909=1")
                .header("Content-Type","application/json")
                .pathParam("id",21)
                .when()
                .body(employeePojo)
                .put("/update/{id}");
          response.prettyPrint();
          response.then().statusCode(200);



    }
}
