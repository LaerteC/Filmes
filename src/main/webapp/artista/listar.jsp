<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="pt_br">
<head>
<meta charset="UTF-8">


<title>Sistema Filmes</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.0/examples/sticky-footer-navbar/">

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">

</head>

<body>

	<header>
		<!-- Fixed navbar -->
		<jsp:include page="/resources/templates/navbar.jsp"></jsp:include>
	</header>


	<!-- Begin page content -->
	<main role="main" class="container">
		<h1 class="mt-5">Artista</h1>
		<p class="lead">Sistema Didático JAVA-WEB</p>

		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/artista/novo">

					<button type="submit" class="btn btn-primary">Inserir Novo</button>
					
				</form>

			</div>

			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/artista/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite um Nome" class="form-control">
						
					</div>
					<button type="submit" class="btn btn-success"> Filtrar </button>
				</form>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Nacionalidade</th>
					<th>Cache</th>
					<th>Nascimento</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codArtista}</td>
						<td>${x.nome}</td>
						<td>${x.nacionalidade}</td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.cache}"/></td>
						<td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${x.nascimento}"/></td>
						<td><a href="<%=request.getContextPath()%>/artista/editar?cod=${x.codArtista}" class="btn btn-primary  btn-xs"> Editar</a>
						 <a href="<%=request.getContextPath()%>/artista/remover?cod=${x.codArtista}" class="btn btn-danger btn-xs"> Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->

	<script src="<%=request.getContextPath()%>/resources/js/jquery-min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
