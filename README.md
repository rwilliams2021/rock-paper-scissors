## Table of Contents

- [Overview](#overview)
- [Design Patterns](#design-patterns)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project is a simple Rock-Paper-Scissors game designed to be played in the console. It allows 
a human player to compete against the computer. The game is built using several design patterns 
to ensure a clean, maintainable, and extensible codebase.

## Design Patterns

The following design patterns are used in this project:

- **Singleton**: Ensures only one instance of the `GameManager` exists.
- **Factory**: Creates instances of `Player` (either user or computer).
- **Strategy**: Defines strategies for selecting the symbols (Rock, Paper, or Scissors).
- **MVC (Model-View-Controller)**: Separates the game logic (Model), user input (View), 
- and game management (Controller).

## Project Structure

The project is organized into several packages:

src/
├── main/
│ ├── java/
│ │ └── org/
│ │ └── game/
│ │ ├── constants/
│ │ │ └── Constants.java
│ │ ├── controller/
│ │ │ └── GameManager.java
│ │ ├── enums/
│ │ │ ├── Outcome.java
│ │ │ └── Symbol.java
│ │ ├── exceptions/
│ │ │ └── QuitGameException.java
│ │ ├── model/
│ │ │ ├── choosestrategy/
│ │ │ │ ├── ChooseStrategy.java
│ │ │ │ ├── RandomChooseStrategy.java
│ │ │ │ └── UserChooseStrategy.java
│ │ │ ├── player/
│ │ │ │ ├── Computer.java
│ │ │ │ ├── Player.java
│ │ │ │ ├── PlayerFactory.java
│ │ │ │ └── User.java
│ │ │ ├── Game.java
│ │ │ ├── Processor.java
│ │ │ └── ScoreManager.java
│ │ └── view/
│ │ ├── InputProvider.java
│ │ └── ScannerInputProvider.java
│ └── resources/
│ └── README.md


## Setup

### Prerequisites

- Java 21 or higher
- Maven

### Installation

1. Clone the repository:

git clone https://github.com/yourusername/rock-paper-scissors-game.git
cd rock-paper-scissors-game

2. Compile the project using Maven:

mvn clean install

### Usage

mvn exec:java -Dexec.mainClass="org.game.Main"

Example Game:
--------------
Enter your name: Alice
Let's play Rock-Paper-Scissors!
Enter number of games to play: 3
Enter your choice: rock, paper or scissors? ('q' to quit): rock
You chose: ROCK
Computer chose: PAPER
PAPER wraps ROCK
Computer wins!
Your score: 0
Computer score: 1
...
Thank you for playing. Goodbye!

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. 
Ensure your code follows the existing coding style and includes appropriate tests.

1. Fork the repository
2. Create a feature branch (git checkout -b feature/your-feature)
3. Commit your changes (git commit -m 'Add some feature')
4. Push to the branch (git push origin feature/your-feature)
5. Open a pull request

### License

This project is licensed under the MIT License. See the LICENSE file for more details.