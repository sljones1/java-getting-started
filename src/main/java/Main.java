import spark.ModelAndView;
import spark.Route;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;
import spark.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        Integer port = 8080;
        try {
            String portString = System.getenv("PORT");
            if (StringUtils.isNotEmpty(portString)) {
                port = Integer.valueOf(portString);
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a Number");
        }
        port(port);
        staticFileLocation("/public");

        Route route = (req, res) -> "Hello World";
        get("/hello", route);

        TemplateViewRoute message = (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        };
        get("/", message, new FreeMarkerEngine());
    }
}
