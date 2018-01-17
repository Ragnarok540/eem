package modelo;

/**
 * @author Nova
 *
 */
public class NotEncryptedException extends Exception {

	private static final long serialVersionUID = -5088497026094375773L;

	/**
	 * See {@link #NotEncryptedException(String)}
	 * */
	public NotEncryptedException () {
		super();
	}
	
	/**
	 * Constructs an instance of NotEncryptedException
	 * with the specified detail message. A detail 
	 * message is an instance of String that describes 
	 * this particular exception.
	 * 
	 * @param message the detail message
	 * */
	public NotEncryptedException (String message) {
		super(message);
	}
	
}
