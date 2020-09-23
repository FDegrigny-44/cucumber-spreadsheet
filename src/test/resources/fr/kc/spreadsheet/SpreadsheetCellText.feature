# encoding: UTF-8
# language: en

@text
Feature: Spreadsheet Cell Text

  A cell can contains some text

  Scenario: Some text
    Given An empty table cell
    When  The cell is setted with value: "Somme text."
    Then  The cell type should be "TEXT"
    And   The cell value should be "Somme text."

  Scenario: Some text with accents and symbols
    Given An empty table cell
    When  The cell is setted with value: "Some text with accents and symbols àéèùüû $§!#&"
    Then  The cell type should be "TEXT"
    And   The cell value should be "Some text with accents and symbols àéèùüû $§!#&"
    
  Scenario: Empty cell type
    Given An empty table cell
    Then  The cell type should be "EMPTY"

