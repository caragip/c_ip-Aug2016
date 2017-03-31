package textExcel;

public class RealCell implements Cell {

	private String text;
	 
	public RealCell (String text){
		this.text = text;
	}
	public String abbreviatedCellText() {

		return "          ";
	}

	public String fullCellText() {
		return text;
	}
	
	public double getDoubleValue(String words){
		return Double.parseDouble(words);
	}

}
