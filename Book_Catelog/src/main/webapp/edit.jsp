<%@page import="dbconnection.booksdb"%>
<%@page import="models.bookcatalog"%>
<%@page import="services.bookservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="bootstrap.jsp"%>
<body>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	bookservice bs = new bookservice(booksdb.conn());
	bookcatalog b = bs.getbyid(id);
	
	%>
	
	<div class="container mt-5">
		<h1 class="text-center mb-4">Update the book information</h1>
		<div class="text-right mb-3">
			<a href="allbooks.jsp" class="btn btn-secondary">Back to List</a>
		</div>
		<form action="update" method="post">
			<div class="form-group">
				<label for="id">Book_ID:</label> <input type="number"
					class="form-control" id="bookid" name="id" value="<%=b.getId()%>"
					placeholder="enter book id" required />
			</div>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title" value="<%=b.getTitle()%>"
					placeholder="enter the title" required />
			</div>
			<div class="form-group">
				<label for="author">Author:</label> <input type="text"
					class="form-control" id="author" name="author" value="<%=b.getAuthor()%>"
					placeholder="enter name of the author" required />
			</div>
			<div class="form-group">
				<label for="genre">Genre:</label> <input type="text"
					class="form-control" id="genre" name="genre" value="<%=b.getGenre()%>"
					placeholder="enter the genre" required />
			</div>
			<button type="submit" class="btn btn-primary">Update-Book</button>
		</form>
	</div>
</body>
</html>