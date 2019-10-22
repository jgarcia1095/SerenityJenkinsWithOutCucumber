package facts;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;
import java.util.List;

public class EmployeeList implements Fact {

    private String usuariosInfo;

    public static EmployeeList toPerfomLogin() {
        return new EmployeeList();
    }

    @Override
    public void setup(Actor actor) {
        actor.attemptsTo(
                Get.resource("/users?page=2")
        );
        List<HashMap<String,String>> usuarios= SerenityRest.lastResponse().path("data");

        actor.remember("users",usuarios);
        usuariosInfo=usuarios.toString();

    }

    public String toString(){
        return "Los usuarios son".concat(usuariosInfo);
    }
}
