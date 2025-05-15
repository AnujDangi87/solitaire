# Enhanced Solitaire Card Game
*Java Lab Bonus Exercise - University of Hyderabad*

## Overview

This project is an enhanced version of the classic **Solitaire Card Game**, originally implemented in Java and based on the code provided in *Timothy Budd’s* book "**Understanding Object-Oriented Programming with Java**". The enhancements address key limitations in the original version and introduce new features to improve gameplay and usability.

## 🎯 Objectives

This project was part of a lab assignment to improve the existing Solitaire game by overcoming the following limitations:

- Only a single game instance could run due to the use of static/global variables.
- The game logic restricted users from moving valid sequences of cards (descending rank, alternating colors) between tableau piles.
- Codebase lacked modular structure and separation of concerns.

## ✅ Enhancements & Features

- **Multi-instance Support**: You can now open and play multiple game windows independently.
- **Improved TablePile Logic**: Allows moving valid sequences of face-up cards (not just the top card) between tableau piles.
- **Refactored Code Structure**:
  - Eliminated overuse of global/static variables.
  - Introduced object-oriented principles to encapsulate state.
  - Better separation of concerns for maintainability.
- **User Interface Tweaks**: (Add here if you’ve made visual improvements or interactions better.)

## 🏗️ How to Run

Make sure you have Java installed. Then:

```bash
javac *.java
java SolitaireGame  # or your main class name
