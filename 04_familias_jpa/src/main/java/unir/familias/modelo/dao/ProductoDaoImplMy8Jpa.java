package unir.familias.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.familias.modelo.entity.Producto;
import unir.familias.repository.ProductoRepository;

@Repository
public class ProductoDaoImplMy8Jpa implements ProductoDao {
	
	@Autowired
	private ProductoRepository prepo;

	@Override
	public Producto buscarUno(int idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public List<Producto> todos() {
		return prepo.findAll();
	}

	@Override
	public List<Producto> buscarProductosPorFamilia(int idFamilia) {
		return prepo.findProductosPorFamilia(idFamilia);
	}

	@Override
	public Producto insertOne(Producto producto) {
		try {
			return prepo.save(producto);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}
