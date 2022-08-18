<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<jsp:include page="cabecera.jsp"/>


<h3>Listado de Incapacidades   &nbsp;<a href="/crearInc" style="text-decoration: none; "> <img src="https://findicons.com/files/icons/1014/ivista/256/plus.png" width="40"/></a> </h3>   
<br> <br>
<a class=" btn btn-danger" onclick="pdf()" style="margin-left:80px;margin-top:-68px">Descargar PDF<span class="bi bi-file-pdf red-color"></a>
<a class=" btn btn-success" onclick="excel()" style="margin-left:80px;margin-top:-68px">Descargar Excel<span class="bi bi-file-excel green-color"></a>

<table class="table table" id="incapacidades" style="color:black" >
<thead style="color:white;">
  <th>Nombres</th> 
  <th>Documento</th>
   <th>Area</th>
  <th>TipoIncapacidad</th>
  <th>Diagnotico CIE10</th>
  <th>Eps</th>
  <th>SalarioDia</th>
  <th>FechaInicial</th>
  <th>TotalDias</th>
  <th>Editar</th>
  <th>Eliminar</th>
  

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
<td><a href="/editarI?id=${emp.getId()}" style="color:white;">Editar</a></td>
<td><button  onclick="confirmarEliminar(${emp.getId()})" type="button">Eliminar</button></td>
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

function pdf(){
	window.location.href="/exportar_ausentismo_pdf";	
}

function excel(){
	window.location.href="/exportar_ausentismo_excel";	
}

</script>


<jsp:include page="pie.jsp"/>

<script>

$(document).ready(function () {
    $('#incapacidades').DataTable();
});
</script>