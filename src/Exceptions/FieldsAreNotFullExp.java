package Exceptions;

public class FieldsAreNotFullExp extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FieldsAreNotFullExp() {
		super("Not all feilds are full. Please fill them all!");
	}
}
