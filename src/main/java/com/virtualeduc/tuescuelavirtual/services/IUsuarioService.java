package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.models.DTOS.PersonaDTO;

public interface IUsuarioService {
	
	public Usuario findUsuarioByCedulaAndTipoUsuario(String tipodoc,String numdoc,String tipousuario);
	
	public PersonaDTO findPersonaByCedulaAndTipoUsuario(String tipodoc,String numdoc,String tipoUsuario);
	

}
