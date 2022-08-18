<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="cabecera.jsp"/>

<center><h3>Reporte por Tipo de Incapacidad</h3></center>

<br/>
<hr/>
<form action="/reporteTipo" method="POST">
<div class="container">
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Seleccionar Tipo de Incapacidad</span>
  <select name="tipoIncapacidad" class="form-select">
             <option value="">- Seleccionar -</option>
             <option value="Enfermedad Comun">Enfermedad Comun</option>
             <option value="Licencia Maternidad">Licencia Maternidad</option>
             <option value="Licencia Paternidad">Licencia Paternidad</option>
              <option value="Accidente de Trabajo">Accidente de trabajo</option>
              <option value="Enfermedad Laboral">Enfermedad Laboral</option>
              <option value="Fondo Pensiones">Fondo Pensiones</option>
              <option value="Accidente de Transito">Accidente de transito</option>
           </select>
</div>
</div>
<br/>
<center><button type="submit" class="btn btn-primary">Enviar</button></center>
</form>



<jsp:include page="pie.jsp"/>