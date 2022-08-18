<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<jsp:include page="cabecera.jsp"/>


<h3>Listado de Empleados   &nbsp; <img style="cursor: pointer;" src="https://findicons.com/files/icons/1014/ivista/256/plus.png" width="40" onclick="direccionar()"/> </h3>   
<br> <br>
<a class=" btn btn-danger" onclick="pdf()" style="margin-left:80px;margin-top:-68px">Descargar PDF<span class="bi bi-file-pdf red-color"></a>
<a class=" btn btn-success" onclick="excel()" style="margin-left:80px;margin-top:-68px">Descargar Excel<span class="bi bi-file-excel green-color"></a>

<table class="table" id="incapacidades" style="color:black;" >
<thead style="color:white;">
  <th>Nombre</th>
  <th>Apellidos</th>
  <th>Documento</th>
  <th>TipoID</th>
  <th>Cargo</th>
  <th>Editar</th>
  <th>Eliminar</th>
 <th>Usuario</th>
</thead>
<tbody>
<c:forEach items="${listaEmpleados}" var="emp">
<tr>
<td>${emp.getNombre()}</td>
<td>${emp.getApellidos()}</td>
<td>${emp.getNumID()}</td>
<td>${emp.getTipoID()}</td>
<td>${emp.getCargo()}</td>
<td><a href="/editarE?id=${emp.getId()}" style="color:black;">Editar</a></td>
<td><button  onclick="confirmarEliminar(${emp.getId()})" type="button">Eliminar</button></td>
<td><a href="/crearUser?id=${emp.getId()}" style="color:black">Usuario</a></td>
</tr>

</c:forEach>

</tbody>

</table>


<script>
function direccionar(){
	window.location.href="/crear";
}

function pdf(){
	window.location.href="/exportar_pdf";	
}

function excel(){
	window.location.href="/exportar_excel";	
}

function confirmarEliminar(idem){
	
	if(confirm("Esta seguro de eliminar el registro?")){

		window.location.href="/eliminarEmpleado?id="+idem;
	}
}
</script>


<jsp:include page="pie.jsp"/>
<script>
$(document).ready(function () {
    $('#incapacidades').DataTable();
});
</script>