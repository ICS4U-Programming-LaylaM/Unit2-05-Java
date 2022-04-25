/**
* This program prints out
* the Magic Squares.
*
* @author Layla Michel
* @version 1.0
* @since 2022-04-20
*/

class MagicSquares {
    /**
    * The middle left index.
    */
    public static final int THREE = 3;
    /**
    * The center index.
    */
    public static final int FOUR = 4;
    /**
    * The middle right index.
    */
    public static final int FIVE = 5;
    /**
    * The lower left index.
    */
    public static final int SIX = 6;
    /**
    * The lower center index.
    */
    public static final int SEVEN = 7;
    /**
    * The lower right index.
    */
    public static final int EIGHT = 8;
    /**
    * The maximum number for magicNumbers.
    */
    public static final int NINE = 9;
    /**
    * The sum each row, column and diagonal should have.
    */
    public static final int MAGICNUM = 15;

    /**
    * Default empty constructor.
    */
    MagicSquares() { }

    /**
    * Creating function to create new magic squares.
    *
    * @param square as array
    * @param currentSquare as array
    * @param index as int
    */
    public void genSquare(final int[] square, final int[]
         currentSquare, final int index) {
        for (int counter = 0; counter < square.length; counter++) {
            // Create new squares
            if (currentSquare[counter] == 0) {
                currentSquare[counter] = 1;
                square[index] = counter + 1;

                if (index < square.length - 1) {
                    // Completes the rest of the new square array
                    genSquare(square, currentSquare, index + 1);
                } else {
                    if (isMagic(square)) {
                        printMagicSquare(square);
                    }
                }
                currentSquare[counter] = 0;
            }
        }
    }

    /**
    * Creating function to check if the square is actually a
    * magic square.
    *
    * @param preSquare as array
    *
    * @return boolean
    */
    public boolean isMagic(final int[] preSquare) {
        // Checks if each row, column and diagonal sums up to 15
        final int row1 = preSquare[0] + preSquare[1]
             + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR]
             + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN]
             + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE]
             + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR]
             + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE]
             + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR]
             + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR]
             + preSquare[SIX];

        // Returns true or false
        return row1 == MAGICNUM && row2 == MAGICNUM
             && row3 == MAGICNUM && col1 == MAGICNUM
             && col2 == MAGICNUM && col3 == MAGICNUM
             && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * Creating function to display the squares that are
    * actually magic squares with sums of 15.
    *
    * @param outputSquare as array
    */
    public void printMagicSquare(final int[] outputSquare) {
        // Prints inputted array in a magic square format
        System.out.println("\n*****");

        for (int count = 0; count < outputSquare.length; count++) {
            // Creates new line when at the 3rd or 6th number
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }

        System.out.println("\n*****");
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(String[] args) {
        // Create a magic square object
        final MagicSquares magicSquares = new MagicSquares();

        // Create default magic square
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE,
            SIX, SEVEN, EIGHT, NINE};
        // Create array of zeros with the same amount of
        // indexes as the default array
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.print("\n");
        System.out.print("All Possible Magic Squares (3x3):\n");
        magicSquares.genSquare(magicSquare, extraArray, 0);
    }
}
