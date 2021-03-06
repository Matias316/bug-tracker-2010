<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
	<%@ include file="html_head.jsp" %>
	
	<c:set var="tipoItem" value="${sessionScope.sistema.getTipoItemID(param.idTI)}"/>
	<c:set var="estadoInicial" value="${sessionScope.sistema.getEstadoID(param.idE)}"/>
	
<body>
	<html:javascript formName="eliminarEstadoSiguienteForm" />
	
	<h1><%= BTUNLP_Titulo %></h1>
    <h2>Eliminar Estado Siguiente a <c:out value="${estadoInicial.getDescripcion()}"/></h2>
    
    <html:form method="POST" action="/eliminarEstadoSiguiente">

	<html:hidden property="descripcionEstadoInicial" value="${estadoInicial.getDescripcion()}" />
	<html:hidden property="idTipoItem" value="${param.idTI}" />
	<html:hidden property="idProyecto" value="${param.idP}" />
    
    <table>
			<tr>	
				<td class="tabla_etiqueta">
					<div id="etiqueta_descripcion">Seleccione estado a eliminar: </div>
				</td>
				<td class="tabla_centrado">
	    		<select name="descripcionEstadoSiguiente">
	    			<c:forEach var="estado" items="${sessionScope.sistema.getEstadosSiguientes(estadoInicial)}">
						<option><c:out value="${estado.getDescripcion()}"/></option>
	         		</c:forEach>
	    		</select>
	    		</td>
			</tr>
			<tr>
				<td class="tabla_centrado" colspan="2">
					<input type="submit" name="eliminarEstadoSiguiente" value="Eliminar estado">
				</td>
			</tr>
		</table>
	
	</html:form>
	<%@ include file="footer.jsp" %>
</body>
</html:html>