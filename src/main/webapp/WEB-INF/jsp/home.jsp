
    <%@ include file="/WEB-INF/jsp/includes.jsp"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pendientes</title>
<style type="text/css">
        body {
            font-family: verdana;
            font-size: 12px;
            margin: 40px;
        }
        .pendienteTable, .pendienteTable td {
            border-collapse: collapse;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px 2px 2px 10px;
            font-size: 12px;
        }
        .pendienteTable th {
            font-weight: bold;
            font-size: 12px;
            background-color: #5C82FF;
            color: white;
        }
        .pendienteLabel {
            font-family: verdana;
            font-size: 12px;
            font-weight: bold;
        }
        a, a:AFTER {
            color: blue;
        }
    </style>
    <script type="text/javascript">
    function deletePendiente(pendienteId){
    	console.log(pendienteId);
    	var i = ".do"
        if(confirm('¿Esta seguro de borrar este pendiente?')){
            var url = 'delete/'+pendienteId+".do";
            window.location.href = url;
        }
    }
    </script>
</head>
<body>
   <div style="margin-left: 30%">
     <div style="margin-left: 15%">
	<h2 style="margin-left: 10%; color: #333399;">Pendientes</h2>
	<div class="container">
		 <form:form action="/savePendiente.do" method="POST" commandName="pendiente">
	<table>
		<tr>
			<td></td>
			<td><form:input path="id" hidden="true"/></td>
		</tr>
		<tr>
			<td>Pendiente</td>
			<td><form:input path="pendiente" required="required"/></td>
		</tr>
		<tr>
			<td>Descripcion</td>
			<td><form:input path="descripcion" required="required"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><br>
			 <div><input type="submit" name="action" value="Guardar"/></td><td></div><br>
			 <div><a href="/CRUDWebAppMavenized/index.do">Recargar</a></div>
				
			</td>
		</tr>
	</table>
	</form:form> 
	</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////// -->	
	<div style="width: 110%;"><p style="font-size: 15px; color: #006600;">El total de Pendientes es: "${total}"</p>
	</div>
	
	<table border="1" class="pendienteTable">
	
	<tr>
		
		<th width="150">Pendiente</th>
		<th width="250">Descripcion</th>
		<th width="120; !important">Acciones</th>
	</tr>
		
		<c:forEach items="${PendienteList}" var="pendiente">
		
		
			<tr>
				<td height="50" style="margin-top: -50">${pendiente.pendiente}</td>
				<td>${pendiente.descripcion}</td>
				
				<td>
				<a href="edit/${pendiente.id}.do">Editar		
				</a>&nbsp;&nbsp;
				<a href="javascript:deletePendiente(${pendiente.id})">Eliminar</a>
				</td>
			</tr>		    
		</c:forEach>
	</table>
	</div>
	</body>
</html>
