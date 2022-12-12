package exercises;

import java.util.List;

public  final class CSvHeader {


	private List<CSVCell> csvCells;


	public CSvHeader(List<CSVCell> csvCells) {
		this.csvCells = csvCells;
	}

	public List<CSVCell> getCsvCells() {
		return csvCells;
	}


}
