package edu.cvtc.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * Servlet implementation class ViewAllController
 */
@WebServlet("/ViewAll")
public class ViewAllController extends HttpServlet {

	private static final long serialVersionUID = 4560498379566434901L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String fileName = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
		final File inputFile=new File(fileName);
		
		String target=null;
		
		try {
			final List<Movie> movieName = WorkbookUtility.retrieveMovieNameFromWorkbook(inputFile);
			
			request.setAttribute("movieName", movieName);
			
			target = "view-all.jsp";
		
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new IOException("The Workbook file has a invalid format.");
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

