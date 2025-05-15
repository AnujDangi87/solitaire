# Solitaire Card Game (Enhanced Version)

**PROJECT TITLE:** Solitaire  
**PURPOSE OF PROJECT:** Bonus Exercise - Java Lab  
**VERSION or DATE:** 07-05-25  
**AUTHORS:** 23MCCE16
**INSTITUTION:** University of Hyderabad - School of Computer and Information Sciences  

This project is developed on BlueJ java editor due to which there are readme files for every .java file

---

## 📌 Project Description

This project is an enhanced version of the classic Solitaire card game, originally based on the implementation from *Timothy Budd’s* book **Understanding Object-Oriented Programming with Java**. The enhancements overcome key limitations in the original code and add improvements to gameplay, usability, and code organization.

---

## 🚀 How to Start This Project

1. Ensure you have Java installed.
2. Compile all source files:
   ```bash
   javac *.java
   ```
3. Run the main class:
   ```bash
   java SolitaireGame  # Replace with your actual main class name if different
   ```

---

## ✨ Enhancements & Solutions

### ✅ Requirement 1: Multiple Instances of Gameplay

**Problem:**  
Only one game instance could be played due to static variables in the `Solitaire` class.

**Solution:**  
Converted static variables to instance variables:
```java
public DeckPile deckPile;
public DiscardPile discardPile;
public TablePile tableau[];
public SuitPile suitPile[];
public CardPile allPiles[];
```
Updated method calls (e.g., `select(int x, int y, CardPile[] allPiles)`) to pass required piles as arguments, supporting multiple independent instances of the game.

---

### ✅ Requirement 2: Moving a Valid Sequence of Cards in TablePile

**Problem:**  
Only the topmost face-up card could be moved. Valid descending sequences could not be transferred.

**Solution:**  
- Detected the clicked card index:
  ```java
  (y - pileTopY) / 35
  ```
  where 35 is half the card height.
- Extracted all cards from the clicked index to the top into a temporary stack `selectPile`.
- If the top card in `selectPile` was face-up:
  - If only one card, checked if it could be moved to a suit pile.
  - Else, searched for a valid target tableau pile to move the sequence.
- If no valid move was found, pushed all cards back to the original pile in the same order.

---

### ✅ Requirement 3: Auto Flip After Moving Cards

**Problem:**  
The top card of a tableau pile was not automatically flipped after moving cards away.

**Solution:**  
Implemented a `flipNext()` method in `TablePile`. After each valid card transfer, it checks and flips the new top card if it's face down.

---

### ✅ Requirement 4: Recycling DeckPile from DiscardPile

**Problem:**  
Once the `DeckPile` was exhausted and all cards were in `DiscardPile`, the deck could not be used again.

**Solution:**  
Updated `DeckPile.select()` logic:
- If `DeckPile` is not empty, move the top card to `DiscardPile`.
- If `DeckPile` is empty, transfer all cards from `DiscardPile` back into `DeckPile`.

> To recycle the deck, click on the empty `DeckPile` area.

---

## 📁 File Structure

- `Card.java` – Represents individual cards.
- `DeckPile.java` – Manages the main deck.
- `DiscardPile.java` – Holds drawn/discarded cards.
- `SuitPile.java` – Four piles for final suit placement.
- `TablePile.java` – Seven tableau piles for gameplay.
- `CardPile.java` – Superclass for all pile types.
- `SolitaireGame.java` – Main gameplay and setup logic.
- `GameWindow.java` – (Optional) GUI wrapper for multiple game windows.

---

## 📚 Original Source & Attribution

This project is based on the original Solitaire game code from:

**Timothy A. Budd**  
*Understanding Object-Oriented Programming with Java*  
Addison-Wesley

> © Timothy A. Budd – Original code  
> © 2025 Anuj Dangi (23MCCE16) – Enhancements and modifications  
> For academic use as part of the Java Lab bonus exercise

---

## 🏁 Final Note

This project demonstrates object-oriented enhancements, gameplay logic improvements, and UI interactivity updates. It was developed as part of the Java Lab Bonus Exercise at the University of Hyderabad.

Suggestions and contributions are welcome!

---
