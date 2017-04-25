/**
 * 
 */
package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Movie;

/**
 * @author William Ramirez
 *
 */
public class WorkbookUtility {
	
	public static final String INPUT_FILE="/assets/MoviesWeb.xlsx";
	
	public static List<Movie> retrieveMovieNameFromWorkbook(final File inputFile) throws InvalidFormatException, IOException
	{
		final List<Movie> movieName = new ArrayList<>();
		
		//TODO: create a workbook from the input file
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		final Sheet sheet = workbook.getSheetAt(0);
		
		//TODO: iterate over each row in the worksheet from the workbook
		for (final Row row : sheet) {
			final Cell titleCell = row.getCell(0);
			final Cell directorCell = row.getCell(1);
			final Cell lengthInMinutesCell = row.getCell(2);

					
			final Movie movie = new Movie(titleCell.getStringCellValue().trim(), directorCell.getStringCellValue().trim(), (int)lengthInMinutesCell.getNumericCellValue());
			
			//NOTES: add each new person to our list of people
			
				movieName.add(movie);	
				
			//	System.out.println(titleCell.getStringCellValue().trim());
			
		}
		
		return movieName;
	
	}
	
	

}
