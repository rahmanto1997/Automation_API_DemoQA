package starter.account;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.UsernamePWGenerator;
import starter.utils.Endpoint;
import starter.TestSuite;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class login  {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;
    String token;
    String userId;


    @Step
    public void setBodyReq(){
        requestParams = new JSONObject();
        requestParams.put("userName","paradigma29");
        requestParams.put("password","Paradigma29@");
    }

    @Step
    public void hitEndpointLogin(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestParams.toString())
                .when()
                .post(endpoint.LOGIN)
                .then()
                .statusCode(200);
        token = SerenityRest
                .then()
                .extract()
                .path("token");
        userId = SerenityRest
                .then()
                .extract()
                .path("userId");
    }
    @Step
    public void hitEndpointGetUser(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer "+ token)
                .when()
                .get(endpoint.GETUSERID+userId)
                .then()
                .statusCode(200);
    }

    @Step
    public void valdateEndpointLogin(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/login.json"));

    }
}
