package Exceptions;

public class DepartmentAlreadyExistsExp extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DepartmentAlreadyExistsExp() {
		super(" This Department already exists in the system, will not be added again");
	}
}
