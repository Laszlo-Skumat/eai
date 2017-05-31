package mathphraseparser;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class EAITestJsonService {

    /**
     * Entry point
     * @param phrase
     * @return The result of the evaluation of the math phrase
     */
    @RequestMapping(value="/eval2", method=RequestMethod.POST
    		, consumes="application/json"
    		)
    @ResponseBody
    EvalResult home(@RequestBody MathPhrase phrase) {
    	//TODO: call the parser
    	EvalResult result = new EvalResult();
    	try {
    		result.result = new MathPhraseParser(phrase.expression).getResult();	
		} catch (Exception e) {
			// TODO: handle exception
		}
        return result;
    }

}
