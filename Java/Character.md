## Character

- public static boolean isLetterOrDigit(char ch): Determines if the specified character is a letter or digit. 
  A character is considered to be a letter or digit if either Character.isLetter(char ch) or 
  Character.isDigit(char ch) returns true for the character. Implmented by Unicode compare.
  
- public static int getNumericValue(char ch)
Returns the int value that the specified Unicode character represents. For example, the character '\u216C' (the roman numeral fifty) will return an int with a value of 50.
