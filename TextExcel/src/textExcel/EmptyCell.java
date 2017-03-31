package textExcel;

public class EmptyCell implements Cell {
	
	public EmptyCell() { // empty cell
	
	}
	
	public String abbreviatedCellText() {
		return "          "; // 10 spaces
	}

	public String fullCellText() {
		return "";
	}

}