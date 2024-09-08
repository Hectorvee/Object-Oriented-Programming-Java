# Practical: Text IO and Regular Expressions

## Objective
This practical aims to introduce **Text IO** and **Regular Expressions** by developing a system to validate and manage firework display data. The **Firework Management Bureau (FMB)** requires assistance in examining text files containing firework display instructions to ensure they are valid and correctly formatted.

## Problem Statement
The Lead PyroTechnicians send text files to the FMB containing data about firework displays. Due to possible disruptions, these files might be corrupted or inaccurate. Your task is to:
1. Validate the data within these files using regular expressions.
2. Create a `DisplayFileHandler` class to process these files.
3. Generate a UML class diagram for all classes in your solution.
4. Read the data and display valid firework displays and their details.

### File Structure
The text file for transmission has the following attributes:

- **FD_ID**: Unique Identifier for Firework Display (e.g., FD0076)
- **FD_NAME**: Name of the Firework Display (e.g.,[Ode to Joy]
- **FD_THEME**: Theme of the Firework Display (e.g., "New Years Eve")
- **PT_FULL_NAME**: Full Name of the Lead PyroTechnician (e.g., Jane-Doe)
- **PT_PHONE_NUMBER**: Phone Number of the Lead PyroTechnician (e.g., 555-010-9111)
- **F_ID**: Unique Identifier for Firework (e.g., FW007600)
- **F_Name**: Name of the Firework (e.g., Bouncing Betty)
- **F_FUSE_LENGTH**: Explosion delay (in seconds) (e.g., 1.2)
- **F_COLOUR**: Colour of the Firework (E_COLOUR)

### Validation Rules
- **Firework Display IDs**: Must start with `FD` followed by 4 digits. Example: `FD1234`
- **Firework Display Names**: Can be any length, enclosed in square brackets `[ ]`. Example: `[New Year's Eve Spectacular]`
- **Firework Display Themes**: Can be any length, enclosed in quotation marks `" "`. Example: `"Winter Wonderland"`
- **PyroTechnician Full Names**: Format as `Yxxxx-Yxxxxx`, where `Y` is a capital letter and `x` is lowercase letters. Example: `Ajohn-Bsmiiiiiith`
- **PyroTechnician Phone Numbers**: Must be in the format `XXX-XXX-XXXX`, starting and ending with a non-zero digit. Example: `123-456-7891`
- **Firework IDs**: Must start with `FW` followed by 6 digits. Example: `FW123456`
- **Firework Names**: Can be of any length with uppercase and lowercase letters, and spaces. Example: `Sky Blossom`
- **Firework Fuse Lengths**: Must be any value greater than 0, including decimal values. Example: `0.5` or `2.52`
- **E_COLOUR**: Only the following colours are valid:
  - RED
  - ORANGE
  - GREEN
  - BLUE
  - YELLOW
  - MAGENTA
  - WHITE
  - CYAN

## Tasks

### 1. UML Class Diagram
- Develop a UML class diagram for all the classes used in your solution to ensure accurate modeling.

### 2. `DisplayFileHandler` Class
- **Package**: `acsse.csc2a.fmb.file`
- **Methods**:
  - `readDisplay(String filename)`: 
    - Reads each line of the file.
    - Validates the data using regular expressions.
    - Prints error messages for invalid lines.
    - Creates and populates a `FireworkDisplay` instance with valid data.
    - Returns the `FireworkDisplay` instance.
    - Handles exceptions during File IO.

### 3. `Main` Class
- Use the `DisplayFileHandler` to read the provided text files.
- Display valid firework displays and their fireworks in a user-friendly format.

## Example Output
```plaintext
Firework Display: Ode to Joy
Theme: New Year's Eve
Lead Pyrotechnician: Jane-Doe, Contact: 555-010-9111
Fireworks:
1. [ID: FW007600] Name: Bouncing Betty, Fuse Length: 1.2 sec, Colour: RED

Firework Display: New Year Celebration
Theme: "Winter Wonderland"
Lead Pyrotechnician: John-Smith, Contact: 555-012-3456
Fireworks:
1. [ID: FW008900] Name: Star Burst, Fuse Length: 2.5 sec, Colour: BLUE
