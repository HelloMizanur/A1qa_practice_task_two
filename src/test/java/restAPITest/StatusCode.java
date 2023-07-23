package restAPITest;
public enum StatusCode {
	 	OK(200),
	    CREATED(201),
	    BAD_REQUEST(400),
	    UNAUTHORIZED(401),
	    NOT_FOUND(404);
	    private final int code;
	    StatusCode(int code) {
	        this.code = code;
	    }
	    
	    public int getCode() {
	        return code;
	    }
	    
	    
}
