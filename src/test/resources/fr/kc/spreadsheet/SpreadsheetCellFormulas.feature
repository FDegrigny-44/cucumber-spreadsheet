# encoding: UTF-8
# language: en

@formulas
Feature: Spreadsheet Cell Formulas

  A cell can evaluates simple arithmetics formulas

  Scenario: Very Simple Formula
    Given An empty table cell
    When  The cell is setted with value: "= 1 + 3"
    Then  The cell type should be "FORMULA"
    And   The result should be "4"

  Scenario Outline: Other formula
    Given An empty table cell
    When  The cell is setted with value: <cell_value>
    Then  The result should be <expected_result>
  Examples:
    | cell_value        | expected_result      |
    | " = 5 * 11"       | "55"                 |
    | "=  2 * 10 + 1"   | "21"                 |
    | "=  2 * (10 + 1)" | "22"                 |
    | "=1 / 3"          | "0.3333333333333333" |
    | "= 1.22 - 12.31"  | "-11.09"             |
    | "= Math.PI     "  | "3.141592653589793"  |

  @limit
  Scenario: Eval empty Cell
    Given An empty table cell
    Then  The result should be ""

  @limit
  Scenario: Eval empty formula
    Given An empty table cell
    When  The cell is setted with value: ""
    Then  The result should be ""

  @error
  Scenario: Invalid formula - bad reference
    Given An empty table cell
    When  The cell is setted with value: "= 1 + A"
    Then  The result should be "#ERR"
    And   the last error message should starts with "Invalid formula"
    And   the last error message should contains '"A" is not defined'
