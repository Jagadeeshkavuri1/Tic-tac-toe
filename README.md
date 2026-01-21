🎮 Tic Tac Toe Game — Java Command Line Application

A console-based Tic Tac Toe game developed in Java, supporting two players, input validation, winner detection, draw handling, and score tracking across multiple rounds.

📖 Overview

This is a 3×3 Tic Tac Toe game played in the terminal.
Players take turns entering row and column values (0–2) to place their symbol (X or O).

The game:

Prevents invalid input

Prevents overwriting occupied cells

Automatically detects wins and draws

Allows replay without restarting the program

Maintains final scores

🖥️ Actual Console Output (From Program)
=================================
        TIC TAC TOE GAME
=================================
Instructions:
- Two players take turns (X and O)
- Enter row and column (0 to 2)
- First to get 3 in a row wins
- Example: enter 1 then press Enter, then 2
=================================

Enter Player X name: player1
Enter Player O name: player2

Current Board:
    0   1   2
0     |   |   
   ---+---+---
1     |   |
   ---+---+---
2     |   |

player1's turn (X)
Enter row (0-2): 0
Enter column (0-2): 0

Current Board:
    0   1   2
0   X |   |
   ---+---+---
1     |   |
   ---+---+---
2     |   |

player2's turn (O)
Enter row (0-2): 1
Enter column (0-2): 1

Current Board:
    0   1   2
0   X |   |
   ---+---+---
1     | O |
   ---+---+---
2     |   |

✨ Features
🎮 Gameplay

Two-player mode (X vs O)

Custom player names

Turn-based play

Clear board with row & column indexes

Replay option after each game

🧠 Logic & Validation

Row, column & diagonal winner detection

Draw detection when board is full

Prevents invalid numeric input

Prevents selecting already-filled cells

Tracks scores across multiple rounds

🔄 Game Flow
Start Game
   ↓
Show Instructions
   ↓
Enter Player Names
   ↓
Initialize Empty Board
   ↓
Player X Turn
   ↓
Validate Row & Column
   ↓
Place Symbol
   ↓
Check Win / Draw
   ↓
Switch Player
   ↓
Repeat

🛠️ How to Run
✅ Requirements

Java JDK 8 or higher

▶️ Compile & Run
javac TicTacToeGame.java
java TicTacToeGame

🕹️ How to Play
Board Layout
    0   1   2
0     |   |
   ---+---+---
1     |   |
   ---+---+---
2     |   |

Input

Enter row number (0–2)

Enter column number (0–2)

Example:

Enter row (0-2): 1
Enter column (0-2): 2

🏆 Win Conditions

A player wins by placing three identical symbols in:

Any row

Any column

Any diagonal

🤝 Draw

If all 9 cells are filled and no winner exists.

📊 Score Tracking

Scores are preserved until the program ends:

🏆 Final Scores:
player1 (X): 2
player2 (O): 1

📂 File Structure
TicTacToeGame.java


All logic is contained in one clean, well-structured Java file.

🧠 Concepts Used

2D arrays (char[][])

Loops & conditionals

Input validation

Exception handling

Modular methods

Game state management

🎓 Learning Outcome

This project helps you understand:

Java console applications

Game logic implementation

Input validation techniques

Clean method-based design

Real-time state updates
