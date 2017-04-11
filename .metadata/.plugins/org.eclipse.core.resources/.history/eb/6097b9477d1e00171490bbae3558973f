package textExcel;

public class TextCell implements Cell {
	
	String text; 
	
	public TextCell (String text) {
		this.text = text;
	}

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String abv = text;
		abv += "          ";
		return abv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return "\"" + text + "\"";
	}

}

