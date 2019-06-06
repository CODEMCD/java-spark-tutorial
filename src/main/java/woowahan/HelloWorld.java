package woowahan;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        staticFiles.location("/static");

        get("/hello", (req, res) -> {
            return "Get Hello : " + req.queryParams("name") + " 나이 : " + req.queryParams("age");
        });

        post("/hello", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", req.queryParams("name"));
            model.put("age", req.queryParams("age"));

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
