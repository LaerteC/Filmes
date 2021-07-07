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
		<h2 class="mt-5"> Inserir Novo Artista </h2>
		

	</main>
	
	<form method="post" name="myform" class="form-horizontal" action="<%=request.getContextPath()%>/artista/inserir">
		<div class="form-group">
			<label class="col-sm-2  control-label" for="nome" > Nome :</label>
			
			<div class="col-sm-5">
				<input type="text" name="nome" id="nome" value="${item.nome}" required="required" class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2  control-label" for="nacionalidade" > Nacionalidade :</label>
			
			<div class="col-sm-5">
				<input type="text" name="nacionalidade" id="nacionalidade" value="${item.nacionalidade}" required="required" class="form-control" />
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-sm-2  control-label" for="cache" > Cache :</label>
			
			<div class="col-sm-5">
				<input type="text" name="cache" id="cache" value="${item.cache}" required="required" class="form-control" />
			</div>
		</div>
		
		
		<div class="form-group">
				<label class="col-sm-2 control-label" for="nascimento">Nascimento:</label>
				<div class="col-sm-5">
					<input type="text" name="nascimento" id="nascimento"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${item.nascimento}"/>"
						required="required" class="form-control" />
				</div>
			</div>
		
		<div class="form-group">
		  	<div class="col-sm-offset-2" col-sm-10">
		  		<button  type="submit"  class="btn btn-primary"> Inserir 
		  		</button>
		  		<a href="<%=request.getContextPath()%>/artista/listar"  class="btn btn-default"> Voltar :</a>
		  	</div>
		</div>
		
	</form>
		 
		  
	
	
	
	<jsp:include page="/resources/templates/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript -->

	<script src="<%=request.getContextPath()%>/resources/js/jquery-min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
