<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Liste des Genres</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Liste des Genres</div>
			<div class="card-body">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Genres</th>
						<th>Date Cr�ation</th>
						<th>Suppression
						<th>Edition</th>
					</tr>
					<c:forEach items="${model.genres}" var="gen">
						<tr>
 							<td>${gen.idGen}</td>
							<td>${gen.nomGen}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${gen.dateCreation}" /></td>
							<td><a onclick="return confirm('Etes-vous s�r ?')" href="supprimerGen?id=${gen.idGen}">Supprimer</a></td>
							<td><a href="editerGen?id=${gen.idGen}">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>