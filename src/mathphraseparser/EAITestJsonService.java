package mathphraseparser;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class EAITestJsonService {

    /**
     * Entry point
     * @param phrase
     * @return The result of the evaluation of the math phrase
     */
    @RequestMapping(value="/eval2/{expression}", method=RequestMethod.GET)
    @ResponseBody
    String home(@PathVariable("expression") String phrase) {
    	//TODO: call the parser
    	//TODO: single line
		String result = "\"Ez a masik:"+phrase+"\""; 
        return result;
    }

}
