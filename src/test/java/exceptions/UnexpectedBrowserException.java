package exceptions;

public class UnexpectedBrowserException extends RuntimeException {
	 public UnexpectedBrowserException(String browserName) {
	        super("❌ Unexpected Browser: " + browserName +
	              ". Please use one of: CHROME, FIREFOX, EDGE, SAFARI.");
	    }

}
