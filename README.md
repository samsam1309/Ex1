# Ex1 - Conversion and Operations on Numbers in Different Bases

## Description
This project implements a Java program to work with numbers in various bases (from 2 to 16).  
The main features include:
- Converting numbers between bases.
- Validating the correctness of numbers.
- Performing arithmetic operations (addition, multiplication).
- Comparing numbers.
- Finding the maximum number in an array.

## Project Structure
The project is divided into three main files:
1. **Ex1.java**: Contains the core functions for conversions and operations.
2. **Ex1Main.java**: Implements an interactive program using the functions from `Ex1.java`.
3. **Ex1Test.java**: Provides unit tests to validate each function.

## Features
### Implemented Functions
- **`isNumber(String num, int base)`**: Checks if `num` is valid for the specified base.
- **`number2Int(String num, int base)`**: Converts a number `num` (in a given base) to an integer in base 10.
- **`int2Number(int num, int base)`**: Converts an integer into a number represented in the specified base.
- **`equals(String num1, int base1, String num2, int base2)`**: Compares two numbers in different bases.
- **`maxIndex(String[] nums, int[] bases)`**: Returns the index of the largest number from an array.

### Main Program
The file `Ex1Main.java` provides an interactive program to:
- Convert numbers.
- Perform arithmetic operations on numbers in different bases.
- Identify the largest number in an array.

### Tests
The file `Ex1Test.java` includes tests for each function, covering:
- Valid and edge cases.
- Incorrect inputs.

## Running the Program
### Requirements
- **Java 17 or higher**.
- An IDE like IntelliJ IDEA or a command-line interface with `javac` configured.

### Instructions
1. Clone this repository to your local machine:
   ```bash
   git clone <repository-link>
