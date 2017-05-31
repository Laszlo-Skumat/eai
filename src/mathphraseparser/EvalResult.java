package mathphraseparser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents the result of the evaluation 
 */
@XmlRootElement
public class EvalResult implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement public String result;
}
