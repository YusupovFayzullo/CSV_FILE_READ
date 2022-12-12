package exercises;

public final  class CSVUtils {


	public static void checkIndex(int count,  int index) throws CSVReaderException{

		if(index>=count || index<0) throw  new CSVReaderException("Invalid index, Index must be between [0 and $d) ".formatted(count));

	}
}
