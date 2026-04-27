Tic-tac-toe, Xs and Os or CROSS and NOUGHTS is a game for two players, X and O, who take turns marking the spaces in a 3X3 matrix as depicted below. The player who places three of their marks in a horizontal, vertical, or diagonal row [either from right top to left bottom or left top to right bottom ]is the winner. Game result will be declared as 'Draw' when all the positions in game board are marked.
0 1 2
3 4 5
6 7 8

## **Purpose**

This tic-tac-toe game is developed using Test Driven Development approach in Java programming language.

## **Rules**

##### **The rules are described below :**

1) X always goes first.
2) Players cannot play on a played position.
3) Players alternate placing X’s and O’s on the board until either:
4) One player has three in a row, horizontally, vertically or diagonally
5) All nine squares are filled.
6) If a player is able to draw three X’s or three O’s in a row, that player wins.
7) If all nine squares are filled and neither player has three in a row, the game is a draw.
   Functional Cases:
8) Player X should be always given the first move and should be able to place the mark in gameBoard
9) Player 0 should be given the next move , following player X
10) Player X should be given the next move , following player O
11) Player X should be declared as winner when he takes all the fields in 1st row
12) Player X should be declared as winner when he takes all the fields in 2nd row
13) Player X should be declared as winner when he takes all the fields in 3rd row
14) Player X should be declared as winner when he takes all the fields in 1st column
15) Player X should be declared as winner when he takes all the fields in 2nd column
16) Player X should be declared as winner when he takes all the fields in 3rd column
17) Player X should be declared as winner when he takes diagonally all positions from left to right
18) Player X should be declared as winner when he takes diagonally all positions from right to left
19) Player O should be declared as winner when he takes all the fields in 1st row
20) Player O should be declared as winner when he takes all the fields in 2nd row
21) Player O should be declared as winner when he takes all the fields in 3rd row
22) Player O should be declared as winner when he takes all the fields in 1st column
23) Player O should be declared as winner when he takes all the fields in 2nd column
24) Player O should be declared as winner when he takes all the fields in 3rd column
25) Player O should be declared as winner when he takes diagonally all positions from left to right
26) Player O should be declared as winner when he takes diagonally all positions from right to left
27) Game should be declared as Draw when all positions are filled in the board by both players
28) Exception should be thrown when any player selects the range other than 0 to 8
29) Game should not allow any player to place their mark in already occupied position