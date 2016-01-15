<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title" /></title>
<script type="text/javascript" >
function submitWithParameters(selectedPit){
	document.getElementById("pitPlayed").value = selectedPit;;
	document.forms["kalah"].submit();
}
</script>
</head>
<body>
	<div align="center">
		<h2>Bravo, la redirection fonctionne</h2>
		<br>

<form:form method="post" modelAttribute="kalah" action="play" name="kalah" id="kalah">

		<form:hidden path="pitPlayed" id="pitPlayed"/>
		<table border="1" align="center">
			<tr>
				<td rowspan="2"><c:out value="${kalah.pits[13]}" /></td>
				<td ><c:out value="${kalah.pits[12]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(12)"/></td>
				<td><c:out value="${kalah.pits[11]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(11)"/></td>
				<td><c:out value="${kalah.pits[10]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(10)"/></td>
				<td><c:out value="${kalah.pits[9]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(9)"/></td>
				<td><c:out value="${kalah.pits[8]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(8)"/></td>
				<td><c:out value="${kalah.pits[7]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(7)"/></td>
				<td rowspan="2"><c:out value="${kalah.pits[6]}" /></td>
			</tr>
			<tr>
				<td><c:out value="${kalah.pits[0]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(0)"/></td>
				<td><c:out value="${kalah.pits[1]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(1)"/></td>
				<td><c:out value="${kalah.pits[2]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(2)"/></td>
				<td><c:out value="${kalah.pits[3]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(3)"/></td>
				<td><c:out value="${kalah.pits[4]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(4)"/></td>
				<td><c:out value="${kalah.pits[5]}" /><input type="button" title="Jeu" value="Jeu" onclick="Javascript:submitWithParameters(5)"/></td>
			</tr>
		</table>
		<br><b><i><form:errors path="pitPlayed" cssclass="error" cssStyle="color:red;"/></i></b><br>
</form:form>
	</div>
</body>
</html>