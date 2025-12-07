package enums;

import exceptions.UnexpectedBrowserException;

public enum BrowserType {
	CHROME,
	FIREFOX,
	EDGE,
	SAFARI;
	
	
	 public static BrowserType fromString(String browserName) {
	        for (BrowserType type : BrowserType.values()) {
	            if (type.name().equalsIgnoreCase(browserName)) {
	                return type;
	            }
	        }
	        throw new UnexpectedBrowserException(browserName);
	    }

}
