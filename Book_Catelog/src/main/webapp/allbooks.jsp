<%@page import="models.bookcatalog"%>
<%@page import="java.util.List"%>
<%@page import="dbconnection.booksdb"%>
<%@page import="services.bookservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Book Catalog</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Book Catalog</h1>
		<div class="text-right mb-3">
			<a href="addbooks.jsp" class="btn btn-primary">Add Book</a>
		</div>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>BOOK_ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Genre</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				bookservice bs = new bookservice(booksdb.conn());
				List<bookcatalog> bm = bs.fetchall();
				for (bookcatalog b : bm) {
				%>
				<tr>
					<td><%=b.getId()%></td>
					<td><%=b.getTitle()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getGenre()%></td>
					<td><a href="edit.jsp?id=<%=b.getId()%>">
							<button class="btn btn-warning btn-sm">UPDATE</button>
					</a> <a href="delete?id=<%=b.getId()%>">
							<button class="btn btn-danger btn-sm">DELETE</button>
					</a></td>

				</tr>
				<%
				}
				%>
			</tbody>

		</table>
	</div>
</body>
</html>
