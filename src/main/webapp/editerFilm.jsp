<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Films</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Film :</label> <input type="text"
							name="id" class="form-control" value="${film.idFilm}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom Film :</label> <input type="text"
							name="nom" class="form-control" value="${film.nomFilm}" />
					</div>
					<div class="form-group">
						<label class="control-label">rate :</label> <input type="text"
							name="rate" class="form-control" value="${film.rateFilm}" />
					</div>
					<div class="form-group">
						<label class="control-label">DateSortie :</label> <input
							type="date" name="dateSortie" class="form-control"
							value="${film.dateSortie}" />
					</div>
					<div class="form-group">
						<select name="genre" class="form-control">
							<option value="${film.genre.idGen}" selected>${film.genre.nomGen}</option>
							<c:forEach items="${genModel.genres}" var="gen">
								<c:if test="${gen.idGen != film.genre.idGen}">
									<option value="${gen.idGen}">${gen.nomGen}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>

					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>