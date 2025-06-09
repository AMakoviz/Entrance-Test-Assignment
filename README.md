Gehtsoft Entrance Test Assignment

Overview
--------

This is a Java console application developed as part of the Gehtsoft Training Program Entrance Test. It demonstrates fundamental programming skills by implementing two core features:

1. Caesar Cipher encryption/decryption for both English and Russian alphabets  
2. Arithmetic Expression Evaluator that handles basic math with precedence and parentheses

Features
--------

### 1. Caesar Cipher

- Supports both English and Russian letters
- Preserves letter case (uppercase and lowercase)
- Leaves punctuation, spaces, and numbers unchanged
- Handles positive and negative shift values
- Works with file input or console input

Example:
```
Input: "Hello World", shift: 3  
Output: "Khoor Zruog"

Input: "Привет Мир", shift: 5  
Output: "Хумёзй Рну"

Input (decryption): "Khoor Zruog", shift: 3  
Output: "Hello World"
```

### 2. Arithmetic Expression Evaluator

- Parses and evaluates mathematical expressions
- Supports operations: +, -, *, /
- Handles operator precedence (PEMDAS/BODMAS)
- Supports parentheses, nested parentheses
- Supports decimal and negative numbers
- Proper handling of division by zero

Example:
```
Input: 2 + 3 * 4  
Output: 14.0

Input: (10 + 5) / 3  
Output: 5.0

Input: 2 * (3 + 4) - 1  
Output: 13.0

Input: -5 + 3  
Output: -2.0
```

Application Menu
----------------

```
Welcome to Gehtsoft Technical Assessment
Please choose an option:
1. Caesar Cipher
2. Arithmetic Expression Evaluation
3. Exit
```

For both functionalities, you can choose:

- Read from file
- Read from console

How to Compile and Run
-----------------------

### Prerequisites

- Java 8 or later
- Any Java IDE or terminal with javac and java
- (Optional) Maven if converting to a project structure

### Steps

1. Clone or download the repository
2. Navigate to the project directory
3. Compile the code:

```
javac org/example/Main.java
```

4. Run the application:

```
java org.example.Main
```

If using a Java IDE (like IntelliJ IDEA or Eclipse), just open the project and run Main.

Project Structure
-----------------

```
org.example.Main           // Application entry point
org.example.AEE.InToPost   // Converts infix to postfix (RPN)
org.example.AEE.ParsePost  // Evaluates postfix expression
org.example.CC.Shifr       // Caesar cipher implementation
org.example.CC.Bounder     // Enum for character ranges
```

Assumptions
-----------

- The input file for Caesar Cipher should contain:
  - Line 1: Text
  - Line 2: Integer shift
  - Line 3: Mode ("encryption" or "decryption")

- The input file for arithmetic expression evaluation should contain:
  - Line 1: A single mathematical expression as a string

Example Input File (Caesar)
---------------------------

```
Привет Мир
5
encryption
```

Example Input File (Arithmetic)
-------------------------------

```
2 * (3 + 4) - 1
```

Exception Handling
------------------

- Invalid menu selections or input formats show error messages
- Division by zero throws a handled ArithmeticException
- File reading issues handled with descriptive runtime exceptions

Author
------

Anastasia Makoviz  
Contact: chanas98@gmail.com  
Submission for: Gehtsoft Entrance Test

License
-------

This project is released for evaluation purposes only.
