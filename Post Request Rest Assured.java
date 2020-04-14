package EnnymaxQA.EnnymaxQA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostRequestRestaasuredAPI 
{
@SuppressWarnings("unchecked")
@Test
void GetDatafromAPI()
{
//Specify API URL
	
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

// RestAssured.baseURI = "http://restapi.demoqa.com/customer";

	
//Send Request to URL
RequestSpecification httprequest = RestAssured.given();

//Response From URL
JSONObject requestParameter = new JSONObject();

requestParameter.put("FirstName","atony1112");
requestParameter.put("LastName","Oala1112");
requestParameter.put("UserName","Oluad1112e2");
requestParameter.put("Password","adwsdksdn11s2d11");
requestParameter.put("Email","Eniola228128911j12k21@gmail.com");


httprequest.header("Content-Type", "application/json");
httprequest.body(requestParameter.toJSONString());
//Response object
Response response = httprequest.request(Method.POST, "/Lagos");

//Store Response in String
String responsebody= response.getBody().asString();
System.out.println("\n The response body is  \n\n"+responsebody+"\n\n");

//Statusline Validation
int statuscode = response.getStatusCode();
System.out.println("The Status code is  "+statuscode+"\n\n");
Assert.assertEquals(statuscode, 201);

//StatusLine validation
String statusline = response.getStatusLine();
System.out.println("The Status line is  "+statusline+"\n\n");
Assert.assertEquals(statusline, "HTTP/1.1 201 Created");

// Success Code Valdation
String successcode= response.jsonPath().get("SuccessCode"); 
System.out.println("The SuccessCode line is  "+successcode+"\n\n");
Assert.assertEquals(successcode, "OPERATION_SUCCESS");

/*
//Response From URL
Response response1 = httprequest.request(Method.GET, "/register/3");

//Store Response in String
String responsebody1= response1.getBody().asString();
System.out.println("\n The response body is  \n\n"+responsebody1+"\n\n");

*/
}

}
