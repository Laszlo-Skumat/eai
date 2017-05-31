package mathphraseparser;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@EnableAutoConfiguration
public class EAITestController implements ErrorController{

    private ErrorAttributes errorAttributes;
    private final static String ERROR_PATH = "/error";

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    /**
     * Part of error handling, used from a tutorial
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
    		boolean includeStackTrace) {
    	RequestAttributes requestAttributes = new ServletRequestAttributes(request);
    	return this.errorAttributes.getErrorAttributes(requestAttributes,
    			includeStackTrace);
    }

    /**
     * Part of error handling, used from a tutorial
     */
    private HttpStatus getStatus(HttpServletRequest request) {
    	Integer statusCode = (Integer) request
    			.getAttribute("javax.servlet.error.status_code");
    	if (statusCode != null) {
    		try {
    			return HttpStatus.valueOf(statusCode);
    		}
    		catch (Exception ex) {
    		}
    	}
    	return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Entry point
     * @param phrase
     * @return The result of the evaluation of the math phrase
     */
    @RequestMapping(value="/eval/{expression}", method=RequestMethod.GET)
    @ResponseBody
    String home(@PathVariable("expression") String phrase) {
    	//TODO: call the parser
    	//TODO: single line
		String result = "\"Ez az:"+phrase+"\""; 
        return result;
    }

    /**
     * Controller for the test web service
     * @param errorAttributes
     */
    public EAITestController(ErrorAttributes errorAttributes) {
    	this.errorAttributes = errorAttributes;
    }
    
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	/**
	 * Display error page  
	 * @param request
	 * @return Error page
	 */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
        HttpStatus status = getStatus(request);
        return new ResponseEntity<Map<String, Object>>(body, status);
    }
    
    /**
     * Application entry point
     * TODO: move out from this class 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(EAITestController.class, args);
    }

}
