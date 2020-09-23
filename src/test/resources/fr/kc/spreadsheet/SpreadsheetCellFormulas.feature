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
