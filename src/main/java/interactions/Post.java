package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

public class Post extends RestInteraction {
    private final String resource;

    public Post(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a POST on the resource #resource")
    public <T extends Actor> void performAs(T actor) {
        this.rest().log().all().post(CallAnApi.as(actor).resolve(this.resource), new Object[0]).then().log().all();
    }

    public static Post to(String resource) {
        return (Post) Tasks.instrumented(Post.class, new Object[]{resource});
    }
}