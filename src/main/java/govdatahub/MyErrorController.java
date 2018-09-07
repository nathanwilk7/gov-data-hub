package govdatahub;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value=PATH)
    public String myShowError () {
        return "{\"error\": \"Internal Server Error\"}";
    }

    @Override
    public String getErrorPath () {
        return PATH;
    }
}
