import facts.EmployeeList;
import models.users.Datum;
import models.users.RegisterUserInfo;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetUsers;
import tasks.RegisterUser;
import tasks.RegisterUserModel;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityInitialTest {

    private final String restApiUrl = "https://reqres.in/api";

//    @Test
//    public void factTest() {
//        Actor asesor = Actor.named("Asesor")
//                .whoCan(CallAnApi.at(restApiUrl));
//        SerenityRest.useRelaxedHTTPSValidation();
//
//        asesor.has(EmployeeList.toPerfomLogin());
//    }
//    @Test
//    public void registerUserTestModel() {
//        Actor asesor = Actor.named("Asesor")
//                .whoCan(CallAnApi.at(restApiUrl));
//
//        RegisterUserInfo registerUserInfo=new RegisterUserInfo();
//        registerUserInfo.setEmail("eve.holt@reqres.in");
//        registerUserInfo.setPassword("pistol");
//        SerenityRest.useRelaxedHTTPSValidation();
//
//
//        asesor.attemptsTo(
//                RegisterUserModel.withInfo(registerUserInfo)
//        );
//        asesor.should(
//                seeThat("El codigo de respuesta", ResponseCode.was(),equalTo(200))
//       );
//    }
    @Test
    public void registerUserTest() {
        Actor asesor = Actor.named("Asesor")
                .whoCan(CallAnApi.at(restApiUrl));
        SerenityRest.useRelaxedHTTPSValidation();

        String registerUserInfo="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        asesor.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)
        );
        asesor.should(
                seeThat("El codigo de respuesta", ResponseCode.was(),equalTo(200))
       );
    }

//    @Test
//    public void getUsers() {
//        Actor asesor = Actor.named("Asesor")
//                .whoCan(CallAnApi.at(restApiUrl));
//        SerenityRest.useRelaxedHTTPSValidation();
//
//        asesor.attemptsTo(
//                GetUsers.fromPage(1)
//        );
//
//        asesor.should(
//                seeThat("El codigo de respuesta", ResponseCode.was(),equalTo(200))
//        );
//
//        Datum user= new GetUsersQuestion().answeredBy(asesor)
//                .getData()
//                .stream()
//                .filter(e->e.getId()==1).findFirst().orElse(null);
//
//        asesor.should(
//                seeThat("Usuario no es nulo. ",act->user,notNullValue())
//        );
//
//        asesor.should(
//                seeThat("El email del usuario . ",act->user.getEmail(),equalTo("yygeorge.bluth@reqres.in"))
//        );
//    }
//
//    @Test
//    public void getUsersFailed() {
//        Actor asesor = Actor.named("Asesor")
//                .whoCan(CallAnApi.at(restApiUrl));
//        SerenityRest.useRelaxedHTTPSValidation();
//
//        asesor.attemptsTo(
//                GetUsers.fromPage(1)
//        );
//
//        asesor.should(
//                seeThat("El codigo de respuesta", ResponseCode.was(),equalTo(200))
//        );
//
//        Datum user= new GetUsersQuestion().answeredBy(asesor)
//                .getData()
//                .stream()
//                .filter(e->e.getId()==1).findFirst().orElse(null);
//
//        asesor.should(
//                seeThat("Usuario no es nulo. ",act->user,notNullValue())
//        );
//
//        asesor.should(
//                seeThat("El email del usuario . ",act->user.getEmail(),equalTo("george.bluth@reqres.in"))
//        );
//    }

}
