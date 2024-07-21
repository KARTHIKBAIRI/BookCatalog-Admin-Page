<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Add New Books</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">Add New Books</h1>
		<div class="text-right mb-3">
			<a href="allbooks.jsp" class="btn btn-secondary">Back to List</a>
		</div>
		<form action="register" method="post">
			<div class="form-group">
				<label for="id">Book_ID:</label> <input type="number"
					class="form-control" id="bookid" name="id" value=""
					placeholder="enter book id" required />
			</div>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title" value=""
					placeholder="enter the title" required />
			</div>
			<div class="form-group">
				<label for="author">Author:</label> <input type="text"
					class="form-control" id="author" name="author" value=""
					placeholder="enter name of the author" required />
			</div>
			<div class="form-group">
				<label for="genre">Genre:</label> <input type="text"
					class="form-control" id="genre" name="genre" value=""
					placeholder="enter the genre" required />
			</div>
			<button type="submit" class="btn btn-primary">Add-Book</button>
		</form>
	</div>
</body>
</html>
