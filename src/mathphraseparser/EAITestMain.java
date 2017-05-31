/**
 * 
 */
package mathphraseparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author elszsku
 *
 */
@ComponentScan
@EnableAutoConfiguration
public class EAITestMain {

    /**
     * Application entry point
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	Object[] sources = {EAITestController.class, EAITestJsonService.class};
    	SpringApplication.run(sources, args);
    }

}
