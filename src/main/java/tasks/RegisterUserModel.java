package tasks;

import io.restassured.http.ContentType;
import models.users.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUserModel implements Task {

    private final Object userInfo;

    public RegisterUserModel(Object userInfo){
        this.userInfo=userInfo;
    }

    public static Performable withInfo(Object userInfo){
        return instrumented(RegisterUserModel.class,userInfo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
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
