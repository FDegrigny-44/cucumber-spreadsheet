package fr.kc.spreadsheet;

import java.text.NumberFormat;
import java.text.ParseException;

public class SpreadsheetCell {
	
	public enum CellType {
		TEXT, NUMBER
	}

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

	public CellType getCellType() {
		if (isContentNumber()) {
			return CellType.NUMBER;
		} else {
			return CellType.TEXT;
		}
	}

	public String getNumberValue() {
		if( getCellType() != CellType.NUMBER) {
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
