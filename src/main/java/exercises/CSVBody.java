package exercises;

import java.util.List;
import java.util.Objects;

public class CSVBody {

	private final List<CSVRow> csvRow;

	private  final  int count;

	public CSVBody(List<CSVRow> csvRow) {
		if (Objects.isNull(csvRow))
			throw new CSVReaderException("Row can not be null");
		this.csvRow = csvRow;
		this.count = csvRow.size();
	}

	public List<CSVRow> getCsvRow() {
		return csvRow;
	}

	public CSVRow get(int rowIndex) {
		CSVUtils.checkIndex(count, rowIndex);
		return csvRow.get(rowIndex);
	}


}
