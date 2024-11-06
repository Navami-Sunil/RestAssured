package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils; // Import correct IOUtils

import static io.restassured.RestAssured.baseURI;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;;
public class SoapXMLRequest {
	
	@Test
	public void validatesoapxml() throws IOException {
		File file = new File("./SoapRequest/Addd.xml");
		if (file.exists())
			System.out.println("File exists");

		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8"); // Correct usage of IOUtils

		baseURI = "http://www.dneonline.com";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).
			log().all().
			and().
			  body("//*:AddResult.text()",equalTo("5"));
			 
	}
}
