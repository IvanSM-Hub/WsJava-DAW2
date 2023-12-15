package cliente.pedido.modelo.dao;

import java.util.List;

import cliente.pedido.model.entity.Comercial;

public interface ComercialDao {
	
	List<Comercial> buscarTodosComerciales();
	Comercial buscarUnComercial(int idComercial);
	boolean insertarComercial(Comercial comercial);
	boolean eliminarComercial(int idComercial);

}
