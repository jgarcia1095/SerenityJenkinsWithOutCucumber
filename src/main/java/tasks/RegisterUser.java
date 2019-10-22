package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

private final String userInfo;

public RegisterUser(String userInfo){
    this.userInfo=userInfo;
}

public static Performable withInfo(String userInfo){
    return instrumented(RegisterUser.class,userInfo);
}
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Post.to("/register")
                .with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
