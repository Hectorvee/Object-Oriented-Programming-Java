# Practical: Introduce Generics and Binary I/O 2

## Overview

In this practical, you are tasked with developing a system to manage and read data from binary files detailing fireworks displays. Following a less-than-stellar performance by a previous technician, you'll help the Firework Management Bureau (FMB) by creating a robust solution to handle and process firework display data.

## Objectives

1. **Implement Entity Class**: Create an immutable `Entity` class with specific attributes and accessors.
2. **Create FireworkEntity Class**: Extend the `Entity` class to include a reference to a `Firework`.
3. **Read Binary Files**: Develop a file handler to read and process binary data into entities.
4. **Demonstrate Functionality**: Show the process of reading from a binary file and displaying its contents.

## Classes and Interfaces

### Entity Class

- **Package**: `acsse.csc2a.fmb.model`
- **Attributes**:
  - `xLocation` (int): Position along the x-axis.
  - `angle` (double): Angle of inclination.
- **Methods**:
  - `toString()`: Override to provide a textual representation of the object.
- **Notes**: The `Entity` class should be immutable, meaning its attributes cannot be changed once set.

### FireworkEntity Class

- **Package**: `acsse.csc2a.fmb.model`
- **Attributes**:
  - `firework` (Firework): Reference to a `Firework` object.
- **Methods**:
  - Accessor for `firework`.

### OrchestrationFileHandler Class

- **Package**: `acsse.csc2a.fmb.file`
- **Methods**:
  - `readLayout(String fileName)`: Reads a binary file, extracts data, and populates an `ArrayList` of `Entity` objects.
- **Details**:
  - **Input**: Binary file name.
  - **Output**: `ArrayList` of `Entity` objects.

### Main Method

- **Purpose**: Demonstrate the functionality of reading from a binary file and displaying its contents.

## Binary File Format

- **Structure**:
  ```FD_ID F_ID X_LOCATION ANGLE ... F_ID X_LOCATION ANGLE```
  
- **Attributes**:
  - `FD_ID`: Unique Identifier for the Firework Display.
  - `F_ID`: Unique Identifier for the Firework.
  - `X_LOCATION`: Position on the x-axis.
  - `ANGLE`: Angle of inclination.

## Tasks

1. **Implement Entity and FireworkEntity Classes**:
   - Create the `Entity` class with immutable attributes and a `toString` method.
   - Extend `Entity` to create the `FireworkEntity` class with an additional `firework` attribute.

2. **Develop OrchestrationFileHandler**:
   - Implement the `readLayout` method to read binary file data and populate an `ArrayList` of `Entity` objects.

3. **Create Main Method**:
   - Implement a main method to test reading from the binary file and displaying the data.

## Provided Files

- **p05.jar**: Contains necessary classes and JavaDoc for the practical.
- **FD0001.txt**: A text file with FireworkDisplay information (ID “FD0001”).
- **layout_1.dat**: Binary file containing orchestration information.

## Hints

- Review the JavaDoc and `p05.jar` for methods and classes you need to use.
- Pay attention to the structure of the binary file and the new methods in `FireworkDisplay`.
- Use the FireworkDisplay ID to find relevant information in text files.

## Example

(Picture for illustration: `images/images.png`)

## Submission

Ensure that all classes are correctly implemented and tested. Submit your work according to the provided guidelines and verify functionality with the provided files.

## Notes

- Ensure that the `Entity` and `FireworkEntity` classes are immutable.
- Validate the binary file reading and ensure accurate data processing.
- Use provided resources effectively to complete the practical.
