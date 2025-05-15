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

PROJECT TITLE: Solitaire
PURPOSE OF PROJECT: Bonus_Exercise
VERSION or DATE: 07-05-25
HOW TO START THIS PROJECT:
AUTHORS: 23MCCE16

Report: 
    Requirement: Multiple instances of gameplay: Allow users to play multiple games simultaneously.
    Solution : In Solitaire Class these class variables  
                public static DeckPile deckPile;
                public static DiscardPile discardPile;
                public static TablePile tableau [ ];
                public static SuitPile suitPile [ ];
                public static CardPile allPiles [ ];
                were static which lead to the limitation of only one instance can by played to counter 
                this i changed this to instance scope and pass the allPiles[] array as argument where the
                requirment for this piles were necessary such as select(int x, int y, CardPile[] allPile)
    
    Requirement: The current select method in TablePile is designed to move only the topmost face-up
                card. If you have a sequence of face-up cards in a tableau pile that are in valid
                descending rank and alternating color order, the code doesn't provide a mechanism to
                pick up and move this entire sequence to another valid tableau pile.
    Solution: First calculated where in the table pile is the user is clicked on 
              using this formula -> ((y -axix position on which mouse clicked)-(the starting y position of the pile on which is clicked))/35;
            here 35 is half of height of card.
             after finding which card is clicked we will pop card form pile and insert into our selectPile stack
             and check if top card of stack if its face is up if yes then check if selectPile size is one then chcek if it can be inserted into 
             suite pile otherwise check the top card can be inserted into other table pile if yes then insert the whole selectPile into the accepting
             table pile. If no such pile is found then push the cards again in same table pile

    Requirement: After transferring one card to other pile the top card of the outgoing pile is not automatically fliped.
    Solution: In tablePile class:  After each transferring of cards from one pile to other pile in case of tables piles call a method name flipNext()
                which flip the remaining top card face if not flipped.

    Requirement: If all the cards present in the DeckPile is exhausted and transferred into discardPile we can't go through that pile agian.
    Solution: In DeckPile class: when the select method is called check if the pile is empty or not if no then send the top card into discard pile and if yes
                then Remove all the card from discard pile and insert again into the DeckPile stack.
                To use thsi function again press on the empty DeckPile .
             


## 🏗️ How to Run

Make sure you have Java installed. Then:

```bash
javac *.java
java SolitaireGame  # or your main class name
