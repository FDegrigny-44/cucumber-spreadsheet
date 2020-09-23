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

