package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.booksdb;
import services.bookservice;
@WebServlet("/delete")
public class deletebook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		bookservice bs = new bookservice(booksdb.conn());
		boolean f = bs.deletebook(id);
		if(f) {
			resp.sendRedirect("allbooks.jsp");
		}
		else {
			resp.sendRedirect("allbooks.js");
		}
		
	}
}
