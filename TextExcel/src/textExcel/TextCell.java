package textExcel;

public class TextCell implements Cell {
	
	private String text; 
	
	public TextCell (String string) {
		text = string;
	}

	public String abbreviatedCellText() {
		String abv = text;
		while(abv.length()<10){
			abv = abv + " ";
		}
		if(abv.length()>10){
			abv = abv.substring(0, 10);
		}
		return abv;
	}


	public String fullCellText() {

		return "\"" + text + "\"";
	}

}

