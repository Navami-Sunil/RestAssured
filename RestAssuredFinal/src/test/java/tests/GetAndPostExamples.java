package tests;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.builder.ToStringBuilder;
import  org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetAndPostExamples {

@Test	
public void testPost() {
	Map<String, Object>map=new HashMap<String,Object>();
	
	map.put("name","Neha");
	map.put("job","Engineer");
	
	System.out.println(map);
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String jsonBody = gson.toJson(map);
	System.out.println("JSON Body: ");
	System.out.println(jsonBody);
	baseURI ="https://reqres.in/api";
	
    given().
     body(jsonBody).
    when().
     post("/users").
    then().
     statusCode(201)
     .log().all();
}

@Test
public void testGet() {
	baseURI ="https://reqres.in/api";
	
    given().
    get("/users?page=2").
    then().
    statusCode(200).
    body("data[4].first_name",equalTo("George")).
    body("data.first_name",hasItems("George","Rachel"));
}
}