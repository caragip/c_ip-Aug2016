package textExcel;

public class SpreadsheetLocation implements Location
{
	
   char col;
   int row;
   
   public int getRow() {
		
    return row - 1; // zero based array
    }

    public int getCol()
    {
    	return col - 65; // char value to array index
    }
    
    public SpreadsheetLocation(String cellName) // changes location to index
    {
    	col = cellName.charAt(0);
    	row = Integer.parseInt(cellName.substring(1));
    }

}