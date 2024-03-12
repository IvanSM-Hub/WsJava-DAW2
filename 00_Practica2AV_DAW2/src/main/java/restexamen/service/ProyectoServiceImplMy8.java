package restexamen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import restexamen.configuration.AutowiredRepository;
import restexamen.model.entity.Proyecto;

@Service
public class ProyectoServiceImplMy8 extends AutowiredRepository implements ProyectoService {

	@Override
	public Proyecto findOne(int idProyecto) {
		return proyectoRepository.findById(idProyecto).orElse(null);
	}

	@Override
	public Proyecto insertOne(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	public Proyecto updateOne(Proyecto proyecto) {
		try {
			if (proyectoRepository.findById(proyecto.getIdProyecto())!=null)
				return proyectoRepository.save(proyecto);
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int deleteOne(int idEmpleado) {
		try {
			if(proyectoRepository.findById(idEmpleado)!=null) {
				empleadoRepository.deleteById(idEmpleado);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			
		}
		return -1;
	}

	@Override
	public List<Proyecto> findAll() {
		return proyectoRepository.findAll();
	}

}
