package com.virtualeduc.tuescuelavirtual.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualeduc.tuescuelavirtual.models.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {

	public Usuario findByUsername(String username);
	
	//public Usuario findByCedula(String cedula);
	
}
