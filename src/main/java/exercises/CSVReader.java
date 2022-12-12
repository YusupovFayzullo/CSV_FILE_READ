package exercises;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public final class CSVReader {
	private CSvHeader cSvHeader;
	private CSVBody csvBody;
	private boolean includeHeader;
	private static CSVReader instance;

	public CSVReader(CSvHeader header) {

		this.cSvHeader = header;

	}

	public CSVReader(String path){
      this(new File(path));
	}

	public CSVReader(File file){

	}

	public CSVReader(File file, boolean includeHeader) throws IOException {

         this.includeHeader=includeHeader;
		 initializeCSVHeaderAndCSVBody(file);
	}


	public static  CSVReader getInstance(String path, boolean includeHeader) throws IOException {
            return getInstance(new File(path), includeHeader);
	}

	public static CSVReader getInstance(File file, boolean includeHeader) throws IOException {

		if(instance==null){
			synchronized (CSVReader.class) {
				if (Objects.isNull(instance)) {

					instance = new CSVReader(file, includeHeader);
				}
			}
		}
		return instance;
	}

	private void initializeCSVHeaderAndCSVBody(File file) throws IOException {

		try (var in = new Scanner(file, StandardCharsets.UTF_8)) {

			if(in.hasNext()) {
				String nextLine = in.nextLine();

				if (!nextLine.isBlank()) {

					List<CSVCell> csvCells = new ArrayList<>();
					for (String s : nextLine.split(",")) {
						csvCells.add(new CSVCell(s.trim()));
					}
					this.cSvHeader = new CSvHeader(csvCells);
				}
			}

			List<CSVRow> csvRows=new ArrayList<>();


			while (in.hasNextLine()){

				String nextLine=in.nextLine();

				if(!nextLine.isBlank()){

					List<CSVCell>csvCells=new ArrayList<>();

					for (String s : nextLine.split(",")) {
						csvCells.add(new CSVCell(s.trim()));
					}

					csvRows.add(new CSVRow(csvCells));
				}
				this.csvBody=new CSVBody(csvRows);
			}

			



		}
	}

}
