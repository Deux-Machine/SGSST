<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 

<jsp:include page="cabecera.jsp"/>


<h3>Editar Empleado</h3>
<form:form method="POST" action="/crear_empleado" modelAttribute="emp" >

<labe>Nombre</labe>
<form:input type="text" path="nombre" class="form-control"/>
<form:errors path="nombre"  style="color:red"></form:errors>

<br/>

<labe>Apellidos</labe>
<form:input type="text" path="apellidos" class="form-control"/>
<form:errors path="apellidos"  style="color:red"></form:errors>

<labe>Tipo Identificacion</labe>
<form:select  path="tipoID" class="form-select">

<form:option value="">-- Seleccionar</form:option>
<form:option value="CC">Cedula Ciudadania</form:option>
<form:option value="CE">Cedula Extranjeria</form:option>
<form:option value="CE">Permiso Especial de Permanencia</form:option>
<form:option value="CE">Permiso Temporal</form:option>

</form:select>
<form:errors path="tipoID"  style="color:red"></form:errors>
<br/>

<labe>No Identificacion</labe>
<form:input type="text" path="numID" class="form-control"/>
<form:errors path="numID"  style="color:red"></form:errors>
<br/>

<labe>Cargo</labe>
<form:input type="text" path="cargo" class="form-control"/>
<form:errors path="cargo"  style="color:red"></form:errors>
<br/>


<labe>Area Trabajo</labe>
<form:select  path="areaTrabajo" class="form-select">
<form:option value="Sistemas">Sistemas</form:option>
<form:option value="Contabilidad">Contabilidad</form:option>
<form:option value="Ventas">Ventas</form:option>
<form:option value="Cartera">Cartera</form:option>
<form:option value="Oficios Varios">Oficios Varios</form:option>
<form:option value="Administracion">Administracion</form:option>
<form:option value="Otros">Otros</form:option>
</form:select>
<form:errors path="areaTrabajo"  style="color:red"></form:errors>
<br/>


<labe>Salario</labe>
<form:input type="text" path="salario" class="form-control" />
<form:errors path="salario"  style="color:red"></form:errors>
<br/>


<labe>Edad</labe>
<form:input type="text" path="edad" class="form-control" />
<form:errors path="edad"  style="color:red"></form:errors>
<br/>

<labe>EPS</labe>
<form:input type="text" path="EPS" class="form-control" />
<form:errors path="EPS"  style="color:red"></form:errors>
<br/>

<labe>AFP</labe>
<form:input type="text" path="AFP" class="form-control" />
<form:errors path="AFP"  style="color:red"></form:errors>
<br/>

<labe>ARL</labe>
<form:input type="text" path="ARL" class="form-control" />
<form:errors path="ARL"  style="color:red"></form:errors>
<br/>

<form:input type="hidden" path="id" class="form-control" />

<button type="submit" class="btn btn-primary">Enviar</button>

</form:form>


<jsp:include page="pie.jsp"/>