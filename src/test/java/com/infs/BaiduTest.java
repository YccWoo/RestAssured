package com.infs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;


public class BaiduTest {
    @BeforeClass
    public void setup(){
        useRelaxedHTTPSValidation();
    }
    @DataProvider(name="searchWords")
    public Object[][] dataProvider(){
        return new Object[][]{{"sun"},{"appium"}};
    }

    @Test(dataProvider = "searchWords")
    public void testBaiduHtml(String word){

        given()
                .queryParam("wd",word)
        .when()
                .get("https://www.baidu.com/s").prettyPeek()
        .then()
                .statusCode(200);

    }
}
