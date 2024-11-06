package tests;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.restassured.http.ContentType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static io.restassured.RestAssured.*;
public class TestsOnLocalAPI {
    @Test
	public void get() {
		 baseURI ="http://localhost:3000"; 
    	given().
    	get("/users").
    	then().
    	statusCode(200).
    	log().all();
	}
    @Test
    public void post() {
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("firstName","Vis");
        map.put("lastName","S");
        map.put("subjectId","1");
        map.put("id","7");
        String jsonBody = gson.toJson(map);
       
        
        baseURI ="http://localhost:3000"; 
        given().
    	contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    	.body(jsonBody)
    	.when()
    	.post("/users")
    	.then()
    	.statusCode(201).
    	log().all();
	}
    
    @Test
    public void put() {
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("firstName","Mallika");
        map.put("lastName","Menon");
        map.put("subjectId","1");
        String jsonBody = gson.toJson(map);
       
        
        baseURI ="http://localhost:3000"; 
        given().
    	contentType(ContentType.JSON)
    	.accept(ContentType.JSON)
    	.body(jsonBody)
    	.when()
    	.put("/users/2")
    	.then()
    	.statusCode(200).
    	log().all();
	}
    
    
    
}

