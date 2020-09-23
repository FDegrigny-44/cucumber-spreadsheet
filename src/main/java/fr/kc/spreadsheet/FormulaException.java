package fr.kc.spreadsheet;

public class FormulaException extends Exception {

	private static final long serialVersionUID = 1L;

	public FormulaException() {
		super();
	}

	public FormulaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormulaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormulaException(String message) {
		super(message);
	}

	public FormulaException(Throwable cause) {
		super(cause);
	}

}
