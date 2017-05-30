package mathphraseparser;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class EAITestController {
    @RequestMapping(value="/person/get/{id}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    String home(@PathVariable("id") String id) {
        return "{\"result\": \"Ez az:"+id+"\"}";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EAITestController.class, args);
    }
}
