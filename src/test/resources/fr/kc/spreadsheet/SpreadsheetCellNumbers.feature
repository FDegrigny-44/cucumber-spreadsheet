# encoding: UTF-8
# language: en

@numbers
Feature: Spreadsheet Cell Numbers

  A cell can contains numbers

  Scenario: Integer number
    Given An empty table cell
    When  The cell is setted with value: "13"
    Then  The cell type should be "NUMBER"
    And   The cell number value should be "13"

  Scenario: Real number
    Given An empty table cell
    When  The cell is setted with value: "13.07"
    Then  The cell type should be "NUMBER"
    And   The cell number value should be "13.07"

  Scenario: Scientific notation
    Given An empty table cell
    When  The cell is setted with value: "2E+2"
    Then  The cell type should be "NUMBER"
    And   The cell value should be "2E+2"
    And   The cell number value should be "200"
