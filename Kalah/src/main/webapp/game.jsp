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
function submitWithParameters(selectedPit, player, pits0, pits1, pits2, pits3, pits4, pits5, pits6, pits7, pits8, pits9, pits10, pits11, pits12, pits13, winner){
	document.getElementById("pitPlayed").value = selectedPit;
	document.getElementById("player").value = player;	
	document.getElementById("pits0").value = pits0;		
	document.getElementById("pits1").value = pits1;	
	document.getElementById("pits2").value = pits2;	
	document.getElementById("pits3").value = pits3;	
	document.getElementById("pits4").value = pits4;	
	document.getElementById("pits5").value = pits5;	
	document.getElementById("pits6").value = pits6;	
	document.getElementById("pits7").value = pits7;	
	document.getElementById("pits8").value = pits8;	
	document.getElementById("pits9").value = pits9;	
	document.getElementById("pits10").value = pits10;	
	document.getElementById("pits11").value = pits11;	
	document.getElementById("pits12").value = pits12;	
	document.getElementById("pits13").value = pits13;	
	document.getElementById("winner").value = winner;
	
	document.forms["kalah"].submit();
}
</script>
</head>
<body>
	<div align="center">
		<h2><spring:message code="enjoy" /></h2>
		<br>

<form:form method="post" modelAttribute="kalah" action="play" name="kalah" id="kalah">

		<form:hidden path="pitPlayed" id="pitPlayed"/>
		<form:hidden path="currentPlayer" id="player"/>
		<form:hidden path="pits[0]" id="pits0" />
		<form:hidden path="pits[1]" id="pits1" />
		<form:hidden path="pits[2]" id="pits2" />
		<form:hidden path="pits[3]" id="pits3" />
		<form:hidden path="pits[4]" id="pits4" />
		<form:hidden path="pits[5]" id="pits5" />
		<form:hidden path="pits[6]" id="pits6" />
		<form:hidden path="pits[7]" id="pits7" />
		<form:hidden path="pits[8]" id="pits8" />
		<form:hidden path="pits[9]" id="pits9" />
		<form:hidden path="pits[10]" id="pits10" />
		<form:hidden path="pits[11]" id="pits11" />
		<form:hidden path="pits[12]" id="pits12" />
		<form:hidden path="pits[13]" id="pits13" />
		<form:hidden path="victory" id="winner" />
		<table border="1" align="center" height="200px" width="600px">
			<tr>
				<th width="20%"><spring:message code="player.two" /></th>
				<th colspan="7">&nbsp;</th>
			</tr>
			<tr>
				<td rowspan="2" width="20%">
					<spring:message code="score" /> : <c:out value="${kalah.pits[13]}" /></td>
				<td  width="10%">
					<c:out value="${kalah.pits[12]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[12] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(12, 2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[11]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[11] != 0}">							
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(11,2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[10]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[10] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(10,2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[9]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[9] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(9,2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[8]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[8] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(8,2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[7]}" />
					<c:if test="${kalah.currentPlayer == 2}">
						<c:if test="${kalah.pits[7] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(7,2, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td rowspan="2"  width="20%">
					<spring:message code="score" /> : <c:out value="${kalah.pits[6]}" /></td>
			</tr>
			<tr>
				<td  width="10%">
					<c:out value="${kalah.pits[0]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[0] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(0, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[1]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[1] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(1, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[2]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[2] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(2, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[3]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[3] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(3, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[4]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[4] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(4, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
				<td  width="10%">
					<c:out value="${kalah.pits[5]}" />
					<c:if test="${kalah.currentPlayer == 1}">
						<c:if test="${kalah.pits[5] != 0}">
							<input type="button" value="Play" onclick="Javascript:submitWithParameters(5, 1, ${kalah.pits[0]}, ${kalah.pits[1]}, ${kalah.pits[2]}, ${kalah.pits[3]}, ${kalah.pits[4]}, ${kalah.pits[5]}, ${kalah.pits[6]}, ${kalah.pits[7]}, ${kalah.pits[8]}, ${kalah.pits[9]}, ${kalah.pits[10]}, ${kalah.pits[11]}, ${kalah.pits[12]}, ${kalah.pits[13]}, ${kalah.victory})"/>
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th colspan="7" width="20%">&nbsp;</th>
				<th><spring:message code="player.one" /></th>
			</tr>
		</table>
		<br>
		<c:if test="${kalah.victory == 0}">
			<spring:message code="current.player" arguments="${kalah.currentPlayer}"/>
		</c:if>
		<c:if test="${kalah.victory != 0}">
			<spring:message code="winner" arguments="${kalah.victory}"/>
		</c:if>
		<br>
		<b><i><form:errors path="pitPlayed" cssclass="error" cssStyle="color:red;"/></i></b>
		<br><br>		
		<c:url value="/newGame" var="url" />
		<a href="${url}">
			<input type="button" value="<spring:message code="new.game" />" > 
		</a>
		<input type="button" value="<spring:message code="exit" />" onclick="Javascript: window.close();" > 		
</form:form>
	</div>
</body>
</html>