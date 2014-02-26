package me.dokollari.cmanager.manager;

/**
 * @author Rizart Dokollari
 * @version 1.7
 * @since February, 2014
 * 
 */
public class CManagerException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CManagerException() {
		super("General Application Error...");
	}

	public CManagerException(String errorMessage) {
		super(errorMessage);
	}

}
