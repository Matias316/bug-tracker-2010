<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
	<%@ include file="html_head.jsp" %>
<body>
<html:javascript formName="loginForm" />
	<h1><%= BTUNLP_Titulo %></h1>
    <h2>Log in</h2>
	<h3><font color="red"><html:errors/></font></h3>
	<html:form action="/login"  method="post" focus="login" onsubmit="return validateLoginForm(this);">
		<table>
			<tr>
				<td class="tabla_etiqueta">
					<div id="etiqueta_usuario">Usuario:</div>
				</td>
				<td class="tabla_input">
					<input type="text" name="nombre_usuario">
				</td>
			</tr>
			<tr>
				<td class="tabla_etiqueta">
					<div id="etiqueta_clave">Contrase&ntilde;a:</div>
				</td>
				<td class="tabla_input">
					<input type="password" name="clave_usuario">
				</td>
			</tr>
			<tr>
				<td class="tabla_centrado" colspan="2">
					<input type="submit" name="boton_login" value="Ingresar">
				</td>
			</tr>
		</table>
	</html:form>
	<%@ include file="footer.jsp" %>
</body>
</html:html>