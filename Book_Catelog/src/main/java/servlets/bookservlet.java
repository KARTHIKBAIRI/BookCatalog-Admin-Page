package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.booksdb;
import models.bookcatalog;
import services.bookservice;
@WebServlet("/register")
public class bookservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String genre = req.getParameter("genre");
		bookcatalog bc = new bookcatalog(id,title,author,genre);
		bookservice bs = new bookservice(booksdb.conn());
		boolean f = bs.addbook(bc);
		if(f) {
			resp.sendRedirect("allbooks.jsp");
		}
		else {
			resp.sendRedirect("allbooks.jsp");
		}
				
	}
}
