package Exceptions;

public class CourtRoomAlreadyExistsExp extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CourtRoomAlreadyExistsExp() {
		super(" This Courtroom already exists in the system, will not be added again");
	}
}
