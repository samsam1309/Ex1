# Ex1 - Conversion and Operations on Numbers in Different Bases

## Description
This project implements a Java program designed to work with numbers represented in various bases (from 2 to 16). The program provides tools for number conversion, validation, arithmetic operations, and comparison.

## Objectives
The primary goals of the project are:
- To enable conversion between number bases.
- To validate the correctness of numbers in specific bases.
- To perform arithmetic operations such as addition and multiplication on numbers in different bases.
- To compare numbers and find the maximum number in a list.

## Usage
The program consists of three main files:

1. **Ex1.java**
   - Contains the core logic for base conversions, validation, and arithmetic operations.

2. **Ex1Main.java**
   - Implements a user-friendly interactive interface that utilizes the functions from `Ex1.java` to perform the described tasks.

3. **Ex1Test.java**
   - Provides automated unit tests to verify the correctness of the implemented functions.

### Key Features
#### Conversion Functions
- **`isNumber(String num, int base)`**
   - Checks whether the string `num` is a valid number in the given base.
- **`number2Int(String num, int base)`**
   - Converts a number in a specific base to its decimal (base 10) equivalent.
- **`int2Number(int num, int base)`**
   - Converts a decimal integer to its representation in the specified base.

#### Arithmetic and Comparison Functions
- **`add(String num1, int base1, String num2, int base2, int resultBase)`**
   - Adds two numbers represented in different bases and returns the result in a specified base.
- **`multiply(String num1, int base1, String num2, int base2, int resultBase)`**
   - Multiplies two numbers in different bases and returns the result in a specified base.
- **`equals(String num1, int base1, String num2, int base2)`**
   - Compares two numbers represented in different bases.
- **`maxIndex(String[] nums, int[] bases)`**
   - Identifies the index of the largest number in an array of numbers, each represented in a specific base.

### Main Program (Ex1Main.java)
The main program offers the following functionalities via an interactive user interface:
- Conversion of numbers between bases.
- Validation of input numbers in their respective bases.
- Execution of arithmetic operations.
- Comparison of numbers and identification of the largest number in an array.

### Testing (Ex1Test.java)
The `Ex1Test.java` file includes unit tests for all implemented functions. These tests cover:
- Valid inputs.
- Edge cases (e.g., smallest and largest possible values).
- Invalid inputs to ensure error handling is robust.

## How to Run the Program
### Prerequisites
- **Java Development Kit (JDK) 17** or higher installed.
- An integrated development environment (IDE) such as IntelliJ IDEA or access to a command-line interface with `javac` and `java` configured.

### Steps
1. Clone the repository to your local machine:
   ```bash
   git clone <repository-link>
   ```
2. Navigate to the project directory:
   ```bash
   cd <project-directory>
   ```
3. Compile all the Java files:
   ```bash
   javac Ex1.java Ex1Main.java Ex1Test.java
   ```
4. Run the main program:
   ```bash
   java Ex1Main
   ```
5. Execute the tests:
   ```bash
   java Ex1Test
   ```

## Project Structure
The directory structure of the project is as follows:
```
project-root/
│
├── Ex1.java        # Core logic for number conversions and operations
├── Ex1Main.java    # Interactive main program
├── Ex1Test.java    # Unit tests for all functions
├── README.md       # Project documentation
```

## Notes
- This project does not support fractional numbers or bases greater than 16.
- Ensure all inputs adhere to the expected format; otherwise, validation functions will return errors.

---

### Example Usage
**Input:**
```
num1 = "101"
base1 = 2
num2 = "2F"
base2 = 16
resultBase = 10
```
**Operation:**
```
add(num1, base1, num2, base2, resultBase)
```
**Output:**
```
Result = 54
```

---

