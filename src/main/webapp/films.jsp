<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="header.jsp"%>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Recherche des Films
            </div>
            <div class="card-body">
                <form action="chercher.do" method="get">
                    <label>Mot Clé</label>
                    <input type="text" name="motCle" value="${model.motCle}"/>
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </form>
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Nom Film</th>
                        <th>Rate</th>
                        <th>Date sortie</th>
                        <th>Genre</th>
                    </tr>
                    <c:forEach items="${model.films}" var="f">
                        <tr>
                            <td>${f.idFilm}</td>
                            <td>${f.nomFilm}</td>
                            <td>${f.rateFilm}</td>
                            <td>${f.dateSortie}</td>
                            <td>${f.genre.nomGen}</td>
                            <td>
    <a onclick="return confirm('Êtes-vous sûr ?')" href="supprimer.do?id=${f.idFilm}"> Supprimer </a>
</td>
<td>
    <a href="editer.do?id=${f.idFilm}">
        Edit
    </a>
</td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>