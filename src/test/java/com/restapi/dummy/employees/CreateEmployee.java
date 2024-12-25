package com.restapi.dummy.employees;

import com.restapi.dummy.model.EmployeePojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateEmployee {

    @Test
    public void createEmployee(){

        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("shaveta");
        employeePojo.setEmployee_age(42);
        employeePojo.setEmployee_salary(8600);

        Response response = given()
                .header("cookie", "humans_21909=1")
                .header("Content-Type","application/json")
                .when()
                .body(employeePojo)
                .post("/create");
        response.prettyPrint();
        response.then().statusCode(201);

    }

}
