<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styletabl.css"/>

<title>Planning tache</title>

</head>
<body>

<div id="selectDate">
<form action="MajoriteServlet" method="get">
Date de debut : <input type="text" NAME="DATE1" value="${bean.date1}"/><br/>
Date de fin : <input type="text" NAME="DATE2" value="${bean.date2}"/><br/>
<input type="submit" NAME="SUBDATE" value="valider"/>
</form>
</div>

<div id="result">
${bean.taches}
</div>

</body>
</html>