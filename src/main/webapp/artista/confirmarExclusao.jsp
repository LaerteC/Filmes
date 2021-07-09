<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Filmes</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Begin page content -->
	<div class="container">
		<div class="page-header">
			<h1>Confirmar Exclusão de Artista</h1>
		</div>

	</main>
	<div class="col-sm-8">
		<ul class="list-group">
			<li class="list-group-item list-group-item-info"y"> Código: ${item.codArtista}</li>
			<li class="list-group-item list-group-item-info""> Nome: ${item.nome}</li>
			<li class="list-group-item list-group-item-info""> Nacionalidade: ${item.nacionalidade}</li>
			<li class="list-group-item list-group-item-info""><fmt:setLocale value="pt_BR" />
				<fmt:formatNumber type="currency" value="${item.cache}" /></li>
			<li class="list-group-item list-group-item-info"><fmt:formatDate type="date" pattern="dd/MM/yyyy"
					value="${item.nascimento}" /></li>
		</ul>

	</div>
	
	<div class="col-sm-offset-2 col-sm-10">
		<a href="<%=request.getContextPath()%>/artista/excluir?cod=${item.codArtista}" class="btn btn-danger"> Excluir</a>
		<a href="<%=request.getContextPath()%>/artista/listar" class="btn btn-default"> Voltar</a>
	</div>

	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->

	<script src="<%=request.getContextPath()%>/resources/js/jquery-min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
