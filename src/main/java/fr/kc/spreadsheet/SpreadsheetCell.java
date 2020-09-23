package fr.kc.spreadsheet;

import java.text.NumberFormat;
import java.text.ParseException;

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
		if (isContentNumber()) {
			return "NUMBER";
		} else {
			return "TEXT";
		}
	}

	public String getNumberValue() {
		if( getCellType() != "NUMBER") {
			return null;
		} else {
			return getValue();
		}
	}

	private boolean isContentNumber() {
		boolean isOk;
		try {
			NumberFormat.getInstance().parse(this.textValue);
			isOk = true;
		} catch (ParseException e) {
			isOk = false;
		}
		return isOk;
	}
}
