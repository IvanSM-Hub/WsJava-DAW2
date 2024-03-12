package restventas.service;

import restventas.modelo.entity.Comercial;

public interface ComercialService {
	
	Comercial insert(Comercial comercial);
	int delete(int idComercial);
	Comercial findOne(int idComercial);

}
