import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 12/27/2016.
 */
public class GenericRoute implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello World!");
        return new ModelAndView(attributes, "index.ftl");
    }
}
