<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="espacevert.css">
<title>Ajout Employe</title>
</head>


<body>


	<nav>
	<ul>
		<li><a href="vue_accueil.jsp">Accueil</a></li>
		<li><a href="vue_planning.jsp">Planning</a></li>
		<li class="active"><a href="vue_ajoutemploye.jsp">Gestion des
				employés</a></li>
		<li><a href="vue_dispoemploye.jsp">Disponibilité des employés</a></li>
	</ul>
	</nav>



	<div id="addEmploye">
		<form action="AjoutEmployeServlet" method="get">
			Nom : <input type="text" NAME="NOM" value="${bean.nom}" /><br />
			Prenom : <input type="text" NAME="PRENOM" value="${bean.prenom}" /><br />
			<input type="submit" NAME="SUBDATE" value="valider" />
		</form>
	</div>

	<div id="result">${bean.nom}${bean.prenom}${bean.etat}</div>

</body>
</html>