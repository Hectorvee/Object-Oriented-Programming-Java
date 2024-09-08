# Practical: Problem Analysis and Model Classes

## Objective
This practical aims to familiarise you with **Problem Analysis** and **Model Classes** by developing a comprehensive system to manage firework displays for the **Firework Management Bureau (FMB)**. The system will help organize Firework Displays and manage the diverse array of Fireworks used, ensuring a seamless and spectacular event.

## Problem Statement
The FMB requires a system capable of:
1. Creating multiple **Firework Displays**, each consisting of various **Fireworks**.
2. Assigning a **Lead Pyrotechnician** to each display for accountability.
3. Using only legal colours for Fireworks through the `E_COLOUR` enumeration.

### Key Data Elements
- **Pyrotechnician**: Tracks the lead pyrotechnician for each display.
    - Full Name: In the format `<Name>-<Surname>` (e.g., Jane-Doe)
    - Phone Number: Contact in case of mishaps.

- **E_COLOUR Enumeration**: Defines legal firework colours:
    - RED, GREEN, BLUE, YELLOW, MAGENTA, WHITE, CYAN

- **Firework**: Details of each firework.
    - Firework ID: A unique alphanumeric ID
    - Firework Name: The firework’s name
    - Fuse Length: The explosion delay (in seconds)
    - Firework Colour: Defined by the `E_COLOUR` enumeration

- **Firework Display**: Information about each display.
    - Display ID: A unique alphanumeric ID
    - Display Name: The display’s name (e.g., Ode to Joy)
    - Display Theme: The theme (e.g., New Year’s Day)
    - Lead Technician: The pyrotechnician in charge
    - Fireworks: The fireworks used in the display

## Required Classes

### 1. Pyrotechnician Class
A class to store the pyrotechnician’s:
- Full Name
- Phone Number

### 2. E_COLOUR Enumeration
An enumeration for legal firework colours:
- RED, GREEN, BLUE, YELLOW, MAGENTA, WHITE, CYAN

### 3. Firework Class
A class to store the firework’s:
- Firework ID
- Firework Name
- Fuse Length (in seconds)
- Firework Colour (from the `E_COLOUR` enumeration)

### 4. Firework Display Class
A class to store the firework display’s:
- Display ID
- Display Name
- Display Theme
- Lead Technician (Pyrotechnician object)
- Fireworks (a list of Firework objects)

It should also include methods to:
- Add new fireworks to the display
- Print the display details in a well-formatted manner

### 5. Main Class
A class to:
- Create two **Firework Display** instances
- Add two **Fireworks** to each display
- Assign a **Pyrotechnician** to each display
- Call the `printDisplay` method on each display for output

### Output Example
```plaintext
Firework Display: Ode to Joy
Theme: New Year’s Day
Lead Pyrotechnician: Jane-Doe, Contact: 123-456-7890
Fireworks:
1. [ID: FW1] Name: SkyRocket, Fuse Length: 5 sec, Colour: RED
2. [ID: FW2] Name: ThunderCracker, Fuse Length: 10 sec, Colour: BLUE

Firework Display: Celebration Blast
Theme: Independence Day
Lead Pyrotechnician: John-Smith, Contact: 987-654-3210
Fireworks:
1. [ID: FW3] Name: StarBurst, Fuse Length: 8 sec, Colour: GREEN
2. [ID: FW4] Name: MegaBoom, Fuse Length: 12 sec, Colour: MAGENTA
