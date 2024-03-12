package restexamen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import restexamen.configuration.AutowiredRepository;
import restexamen.model.entity.Empleado;

@Service
public class EmpleadoServiceImplMy8 extends AutowiredRepository implements EmpleadoService {

	@Override
	public Empleado findOne(int idEmpleado) {
		return empleadoRepository.findById(idEmpleado).orElse(null);
	}

	@Override
	public Empleado insertOne(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		try {
			if (empleadoRepository.findById(empleado.getIdEmpleado())!=null)
				return empleadoRepository.save(empleado);
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int deleteOne(int idEmpleado) {
		try {
			if(empleadoRepository.findById(idEmpleado)!=null) {
				empleadoRepository.deleteById(idEmpleado);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

}
