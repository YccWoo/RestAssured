package com.infs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class TesterHomeTest {
    @BeforeClass
    public void setup(){
        useRelaxedHTTPSValidation();
    }
    @Test
    public void testHtml(){

        given()
                .queryParam("q","webview")
        .when()
                .get("https://testerhome.com/search").prettyPeek()
        .then()
                .statusCode(200)
                .body("html.head.title",equalTo("webview · 搜索结果 · TesterHome"));

    }

    @Test
    public void testTesterhomeJson(){
        given()
        .when()
                .get("https://testerhome.com/api/v3/topics.json").prettyPeek()
        .then()
                .statusCode(200)
                .body("topics.title",hasItem("优质招聘汇总"))
                .body("topics.title[1]",equalTo("优质招聘汇总"))
                .body("topics.findAll{topic->topic.id==10254}.title",hasItems("优质招聘汇总"))
                .body("topics.find{topic->topic.id==10254}.title",equalTo("优质招聘汇总"))
        ;
    }

    @Test
    public void testTesterhomeJsonSginal(){
        given()
        .when()
                .get("https://testerhome.com/api/v3/topics/10254.json").prettyPeek()
        .then()
                .statusCode(200)
                .body("topic.title",equalTo("优质招聘汇总"));
    }

    @Test
    public void testXML(){
        System.out.println("test xml ~~~~~~");
    }
}
