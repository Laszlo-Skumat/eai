package mathphraseparser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

/**
 * Represents the input of the evaluation 
 */
@XmlRootElement
public class MathPhrase implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement public String expression;
}
