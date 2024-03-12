package restfamilias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restfamilias.modelo.entities.Producto;
import restfamilias.repository.ProductoRepository;

@Service
public class ProductoServiceImplMy8 implements ProductoService {
	
	@Autowired
	private ProductoRepository  productoRepository;

	@Override
	public Producto findOne(int codigo) {
		return productoRepository.findById(codigo).orElse(null);
	}

	@Override
	public Producto insertOne(Producto producto) {
		try {
			return productoRepository.save(producto);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Producto updateOne(Producto producto) {
		try {
			if (productoRepository.findById(producto.getCodigo()) != null)
				return productoRepository.save(producto);
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int codigo) {
		try {
			if(productoRepository.findById(codigo)!=null) {
				productoRepository.deleteById(codigo);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> findByColorMarca(String color, String marca) {
		return productoRepository.findByColorAndMarca(color, marca);
	}

	@Override
	public List<Producto> findByFamilia(int codigoFamilia) {
		return productoRepository.findByFamilia(codigoFamilia);
	}

}
