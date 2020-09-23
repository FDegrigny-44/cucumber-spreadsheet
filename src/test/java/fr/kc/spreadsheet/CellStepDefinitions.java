package fr.kc.spreadsheet;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Steps implementation for Cucumber
 */
public class CellStepDefinitions {

	private SpreadsheetCell currentCell;
	
	@Given("An empty table cell")
	public void an_empty_table_cell() {
		currentCell = new SpreadsheetCell();
	}
	
	@When("The cell is setted with value: {string}")
	public void the_cell_is_setted_with_value(String value) {
		currentCell.setValue(value);
	}
	
	@Then("The cell value should be {string}")
	public void the_cell_value_should_be(String expectedValue) {
		String actualValue = currentCell.getValue();
		Assert.assertEquals("The cell value should be", expectedValue, actualValue );
	}

	@Then("The cell type should be {string}")
	public void the_cell_type_should_be(String expectedType) {
		String actualType = currentCell.getCellType();
		Assert.assertEquals("The cell type should be", expectedType, actualType);
	}
	
	@Then("The cell number value should be {string}")
	public void the_cell_number_value_should_be(String expectedNumber) {
		String actualNumber = currentCell.getNumberValue();
		Assert.assertEquals("The cell number vlaue should be", expectedNumber, actualNumber);
	}
}
