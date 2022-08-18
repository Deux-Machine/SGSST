package org.fundacionview.sgsst.repositorios;

import org.fundacionview.sgsst.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Usuarios extends JpaRepository<Usuario, Long>{

	@Query(value="SELECT *FROM users WHERE id_empleado=:idEmp ORDER BY id LIMIT 1",nativeQuery = true)
	public Usuario buscarPorId_Empleado(@Param("idEmp")Long idEmp);
	
	//public Usuario findById_empleado(Long id_empleado);
	
	
}