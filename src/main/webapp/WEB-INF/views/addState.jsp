<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add State</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	
        <form:form method="POST" action="addState" modelAttribute="state">
             <table>
                <tr>
                  
				<td>Despription:</td>
				<td><form:select path="description">
						<form:option value="NONE" label="--- Select ---" />		
						<form:option value="Aguascalientes"/>
					</form:select></td>
				<td><form:errors path="description" cssClass="error" /></td>




				<!--<td><form:input path="description"/></td>  -->
                </tr>
                <tr>
                    <td><form:label path="shipping_zone_id">Shipping Zone</form:label></td>
                    <td><form:input path="shipping_zone_id"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>