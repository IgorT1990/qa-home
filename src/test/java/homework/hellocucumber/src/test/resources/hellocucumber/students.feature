Feature: Students

  Scenario: Check age of students
    Given the following students exist
      | name | age | course|
      | Ivan | 18  |    2  |
      | Anna | 23  |    5  |
      | Olha | 28  |    3  |
    When students are sorted by age
    Then youngest student is at least 16 years

