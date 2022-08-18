<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<jsp:include page="cabecera.jsp"/>


<h3>Reportes</h3>   
<table class="table table" id="incapacidades" style="color:white;">
<thead style="color:black;">
  <th>Nombres</th> 
  <th>Documento</th>
  <th>Area</th>
  <th>TipoIncapacidad</th>
  <th>Diagnotico CIE10</th>
  <th>Eps</th>
  <th>SalarioDia</th>
  <th>FechaInicial</th>
  <th>TotalDias</th>

  

</thead>
<tbody>
<c:forEach items="${listaIncapacidades}" var="emp">
<tr>
<td>${emp.getNombre()} ${emp.getApellidos()}</td>
<td>${emp.getNumID()}</td>
<td>${emp.getAreaTrabajo()}</td>
<td>${emp.getTipoIncapacidad()}</td>
<td style="font-size:60%">${emp.getDiagnostico().getDiagnostico()}</td>
<td>${emp.getEPS()}</td>
<td ><fmt:formatNumber type="number" maxFractionDigits="2" value="${emp.getSalarioDia()}" /></td>
<td style="font-size:60%">${emp.getFechaInicial()}</td>
<td>${emp.getTotalDias()}</td>

</tr>

</c:forEach>

</tbody>

</table>


<script>


function confirmarEliminar(idem){
	
	if(confirm("Esta seguro de eliminar el registro?")){
		
		window.location.href="/eliminarInc?id="+idem;
	}
}
</script>


<jsp:include page="pie.jsp"/>

<script>

$(document).ready(function () {
    $('#incapacidades').DataTable();
});
</script>