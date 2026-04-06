package Exceptions;

public class ObjectAlreadyExistsException   extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ObjectAlreadyExistsException(String object) {
		super(object +"already exists in the system, will not be added again");
	}
	

}
