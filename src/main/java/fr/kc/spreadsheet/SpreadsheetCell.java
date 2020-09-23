package fr.kc.spreadsheet;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SpreadsheetCell {

	public static final String FORMULA_PREFIX = "=";
	public static final String ERR_DISPLAY_CODE = "#ERR";

	public enum CellType {
		TEXT, NUMBER, FORMULA, EMPTY
	}
	
	private static final String INVALID_FORMULA_MSG = "Invalid formula:";

	/**
	 * Store the user input
	 */
	private String textValue;

	/**
	 * Store the last exception occurred, if any
	 */
	private FormulaException lastError;

	/**
	 * Inner Javascript engine to compute formulas
	 */
	private ScriptEngine jsEngine;

	public SpreadsheetCell() {
		this.textValue = null;
		// init the inner Javascript engine
		this.jsEngine = new ScriptEngineManager().getEngineByName("javascript");
	}

	public void setValue(final String newValue) {
		this.textValue = newValue == null ? null : newValue.trim();
	}

	public String getValue() {
		return this.textValue;
	}

	public CellType getCellType() {
		if (this.textValue == null) {
			return CellType.EMPTY;
		} else if (isContentFormula()) {
			return CellType.FORMULA;
		} else if (isContentNumber()) {
			return CellType.NUMBER;
		} else {
			return CellType.TEXT;
		}
	}

	public String getNumberValue() {
		if (getCellType() != CellType.NUMBER) {
			return null;
		} else {
			return evalMath(getValue());
		}
	}

	public String getResult() {
		return evalFormula(getValue());
	}

	private String evalFormula(final String formula) {
		String script = formulaToScript(formula);
		return evalMath(script);
	}

	private String evalMath(final String math) {
		String result = "";
		try {
			Object computed = jsEngine.eval(math);
			if (computed == null) {
				result = "";
			} else {
				result = computed.toString();
			}
		} catch (ScriptException e) {
			result = ERR_DISPLAY_CODE;
			this.lastError = new FormulaException(e.getMessage(), e);
		}
		return result;
	}

	public FormulaException getLastError() {
		return this.lastError;
	}

	public String getLastErrorMessage() {
		if (getLastError() == null) {
			return null;
		} else {
			return INVALID_FORMULA_MSG + " " + getLastError().getMessage();
		}
	}

	// ****************** Private part: ******************************

	private boolean isContentFormula() {
		return this.textValue != null && this.textValue.startsWith(FORMULA_PREFIX);
	}

	private String formulaToScript(final String formula) {
		if (formula == null || formula.length() <= FORMULA_PREFIX.length()) {
			return "";
		} else {
			// trim the leading '=' from the input formula
			return formula.substring(FORMULA_PREFIX.length());
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
