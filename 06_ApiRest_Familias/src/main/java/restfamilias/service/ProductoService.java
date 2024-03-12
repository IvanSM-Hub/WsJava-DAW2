package restfamilias.service;

import java.util.List;

import restfamilias.modelo.entities.Producto;

public interface ProductoService {
	
	Producto findOne(int codigo);
	Producto insertOne(Producto producto);
	Producto updateOne(Producto producto);
	boolean deleteOne(int codigo);
	List<Producto> findAll();
	List<Producto> findByColorMarca(String color , String marca);
	List<Producto> findByFamilia(int codigoFamilia);

}
