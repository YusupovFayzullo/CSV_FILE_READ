package exercises;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVRow {

	private  final List<CSVCell> csvCells;


	private final int count;


	public CSVRow(List<CSVCell> csvCells) {

		if(Objects.isNull(csvCells)){
			throw new CSVReaderException("CSV can not be null, It could be empty");
		}
		this.csvCells = csvCells;
		this.count=csvCells.size();
	}

	public CSVCell get(int index) {
		CSVUtils.checkIndex(count, index);

		return csvCells.get(index);
	}


	@Override
	public String toString() {

		return csvCells.stream()
				.map(CSVCell::data)
				.collect(Collectors.joining(","));
	}
}
