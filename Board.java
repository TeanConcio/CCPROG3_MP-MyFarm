import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {

    public final static int ROW = 10;
    public final static int COLUMN = 5;
    public final static int MIN_ROCKS = 10;
    public final static int MAX_ROCKS = 30;

    private int intDay;
    private Tile[][] arrobjTile = new Tile[ROW][COLUMN];
    private int intRockCount;





    /* ----- ----- ----- Board Constructor ----- ----- ----- */

    /**
     * Board Constructor
     * - This constructor creates a Board object. Initializes Rocks if there is an input file.
     */
    public Board() {

        intDay = 1;
        intRockCount = 0;

        // Find the File
        try {
            File file = new File("Rocks.txt");
            Scanner reader = new Scanner(file);

            // For each Row and Column
            for (int i = 0; i < ROW; i++) {

                for (int j = 0; j < COLUMN; j++) {


                    // If there are less rocks than minimum rocks, then add a rock
                    if (ROW*COLUMN - intRockCount < MIN_ROCKS - intRockCount) {
                        arrobjTile[i][j] = new Tile(i, j, Tile.ROCK);
                        intRockCount++;
                    }
                    
                    // If there are more rocks than maximum rocks then add an unplowed tile
                    else if (intRockCount >= MAX_ROCKS) {
                        arrobjTile[i][j] = new Tile(i, j, Tile.UNPLOWED);
                    }
                    
                    // If the file has a 1, then it is a Rock
                    else if (reader.nextInt() == 1) {
                        arrobjTile[i][j] = new Tile(i, j, Tile.ROCK);
                        intRockCount++;
                    }
                    
                    // If the file has a 0, then it is Unplowed
                    else {
                        arrobjTile[i][j] = new Tile(i, j, Tile.UNPLOWED);
                    }
                }              
            }
            
            // Clock Reader
            reader.close();
        }
        
        // No File Found
        catch (FileNotFoundException e){

            // For each Row and Column
            for (int i = 0; i < ROW; i++) {
            
                for (int j = 0; j < COLUMN; j++) {

                    // Initialize Tile to Unplowed
                    arrobjTile[i][j] = new Tile(i, j, Tile.UNPLOWED);
                }
            }
        }
    }




    /* ----- ----- ----- Board Methods ----- ----- ----- */

    /**
     * getTileFromCoords
     * - Returns the Tile at the given chess coordinates.
     *
     * @param strCoordinates String of Chess Coordinates.
     *
     * @return Tile at the given chess coordinates.
     */
    public Tile getTileFromCoords (String strCoordinates) {

        int intCol = convertLetterToNumber(strCoordinates.charAt(0));
        int intRow = Integer.parseInt(strCoordinates.substring(1, strCoordinates.length())) - 1;

        return arrobjTile[intRow][intCol];
    }



    /**
     * advanceDay
     * - Updates all Tiles in the board to the next day.
     */
    public void advanceDay() {

        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COLUMN; j++) {

                arrobjTile[i][j].updateTile();
            }
        }

        intDay++;
    }



    /**
     * hasLiveTiles
     * - Checks if there are any usable tiles on the board.
     *
     * @return True if there are usable tiles, false otherwise.
     */
    public boolean hasLiveTiles () {

        for (int i = 0; i < ROW; i++) {

            for (int j = 0; j < COLUMN; j++) {

                if (arrobjTile[i][j].getIntStatus() == Tile.UNPLOWED ||
                    arrobjTile[i][j].getIntStatus() == Tile.PLOWED ||
                    arrobjTile[i][j].getIntStatus() == Tile.OCCUPIED ||
                    arrobjTile[i][j].getIntStatus() == Tile.HARVESTABLE)
                    return true;
            }
        }
        
        return false;
    }



    /**
     * convertLetterToNumber
     * - Converts a letter to a number
     *
     * @param chrLetter Letter to be converted
     *
     * @return intNumber Number that corresponds to the letter
     */
    public int convertLetterToNumber(char chrLetter) {

        return (int) chrLetter - 65;
    }





    /* ----- ----- ----- Board Getters and Setters ----- ----- ----- */

    public int getIntDay() {return intDay;}
    public void setIntDay(int intDay) {this.intDay = intDay;}

    public Tile[][] getArrObjTile() {return arrobjTile;}
    public void setArrObjTile(Tile[][] arrobjTile) {this.arrobjTile = arrobjTile;}

    public int getIntRockCount() {return intRockCount;}
    public void setIntRockCount(int intRockCount) {this.intRockCount = intRockCount;}
}
