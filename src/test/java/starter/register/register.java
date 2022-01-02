package starter.register;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.UsernamePWGenerator;
import starter.utils.Endpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class register extends UsernamePWGenerator {
    Endpoint endpoint = new Endpoint();
    JSONObject requestParams;

    @Step
    public void setBodyReq(){
        requestParams = new JSONObject();
        requestParams.put("userName", UsernamePWGenerator.getString(10));
        requestParams.put("password", UsernamePWGenerator.getString(10));
    }

    @Step
    public void setBodyReqExisted(){
        requestParams = new JSONObject();
        requestParams.put("userName","paradigma29");
        requestParams.put("password","Paradigma29@");
    }

    @Step
    public void hitEndpointRegister(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestParams.toString())
                .when()
                .post(endpoint.REGISTER)
                .then()
                .statusCode(201);

    }
    @Step
    public void hitEndpointRegisterFailed(){
        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .body(requestParams.toString())
                .when()
                .post(endpoint.REGISTER)
                .then()
                .statusCode(406);
    }
    @Step
    public void valdateEndpointRegister(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/register.json"));

    }
    @Step
    public void valdateEndpointRegisterFailed(){
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/registerfailed.json"));
    }
}
