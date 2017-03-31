package textExcel;

public class SpreadsheetLocation implements Location
{
	
   char col;
   int row;
   
   public int getRow() {
		
    return row - 1;
    }

    public int getCol()
    {
    	return col - 65;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	col = cellName.charAt(0);
    	row = Integer.parseInt(cellName.substring(1));
    }

}