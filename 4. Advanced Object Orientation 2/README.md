# Practical: Advanced Object Orientation 2

## Overview

This practical aims to deepen your understanding of advanced object-oriented programming concepts through a real-world application for the Firework Management Bureau (FMB). The FMB requires a robust system to manage and validate Firework Displays, which includes handling different types of fireworks: Rockets and Fountains.

## Objectives

1. **Firework Class Hierarchy**: Implement a class hierarchy for managing different types of fireworks. Each type of firework should be represented as a distinct class with appropriate attributes.
2. **ToString Method**: Override the `toString` method in all classes to provide a clear and informative textual representation of the objects.
3. **IDisplayable Interface**: Introduce the `IDisplayable` interface in the `acsse.csc2a.fmb.model` package, which includes a `display` method for consistent printing of class representations.
4. **Enhanced DisplayFileHandler**: Modify the `DisplayFileHandler` class to include data validation and processing improvements:
   - Use regular expressions to validate data completeness.
   - Implement a static `validate` method in each class to check data validity.
   - Design a static `processLine` method for object instantiation based on provided lines of data.
   - Update the `readDisplay` method in `DisplayFileHandler` to use class-specific methods for validation and processing.

## Firework Types

### Rocket Fireworks

Attributes:
- **Firework ID**: Unique alphanumeric identifier, starting with `FR`, followed by 6 digits (e.g., `FR123456`).
- **Firework Name**: Name of the firework (e.g., "Bouncing Betty").
- **Firework Fuse Length**: Delay before explosion in seconds (e.g., 1.2 seconds).
- **Firework Colour**: Color emitted upon detonation.
- **Rocket Black Powder Colour**: Color of the trail before explosion.
- **Rocket Star Count**: Number of Star Spores released.
- **Rocket Star Radius**: Dispersion radius of Star Spores in meters.

### Fountain Fireworks

Attributes:
- **Firework ID**: Unique alphanumeric identifier, starting with `FF`, followed by 6 digits (e.g., `FF123456`).
- **Firework Name**: Name of the firework (e.g., "Sky Blossom").
- **Firework Fuse Length**: Delay before explosion in seconds (e.g., 2.5 seconds).
- **Firework Colour**: Color emitted upon detonation.
- **Fountain Duration**: Total display time in seconds.
- **Fountain Transition Colours**: Sequence of colors exhibited during display, formatted within brackets and separated by a pipe symbol (e.g., `[YELLOW|CYAN|MAGENTA]`).

## Data Formats

**Rocket Information Format**:
```
F_ID    F_NAME    F_FUSE_LENGTH    F_COLOUR    R_STAR_COUNT    R_RADIUS    R_BP_COLOUR
```

**Fountain Information Format**:
```
F_ID    F_NAME    F_FUSE_LENGTH    F_COLOUR    FT_DURATION    FT_TRANSITION_COLOURS
```

## Tasks

1. **Implement Classes**:
   - Create a base `Firework` class.
   - Extend it to create `RocketFirework` and `FountainFirework` classes with additional properties.
   - Implement the `IDisplayable` interface.

2. **Override Methods**:
   - Override the `toString` method in each class to provide a clear representation of the object.

3. **Enhance DisplayFileHandler**:
   - Implement validation using regular expressions.
   - Add `validate` and `processLine` methods to handle data integrity and object creation.
   - Update the `readDisplay` method to use new validation and processing methods.

4. **Testing**:
   - Utilize the `p04.jar` file and test the application with dirty, partial, and clean files.
   - Call the `P04MainTester` class’s `main` method to test the functionality in the `Main` class.

## Files

- **p04.jar**: Contains classes for testing.
- **Text Files**: Include dirty, partial, and clean files for validation.

## Example

(Picture for illustration: `images/images.png`)

## Submission

Ensure all classes are correctly implemented and validated. Submit your work according to the provided guidelines and verify functionality using the supplied test files.

## Notes

- Make sure to adhere to data formatting rules for accurate processing.
- Validate all inputs and handle errors gracefully.
- Ensure that the `toString` and `display` methods provide useful and clear output.

free to modify or expand any sections according to your specific needs or additional details.