package fr.kc.spreadsheet;

public class SpreadsheetCell {

	/**
	 * Store the user input
	 */
	private String textValue;

	public SpreadsheetCell() {
		this.textValue = null;
	}

	public void setValue(final String newValue) {
		this.textValue = newValue;
	}

	public String getValue() {
		return this.textValue;
	}

	public String getCellType() {
		return "TEXT";
	}

}
