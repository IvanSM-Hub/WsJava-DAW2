package cliente.pedido.reository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cliente.pedido.model.entity.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {
	
	@Query("select c from Comercial c")
	public List<Comercial> findAllComercial();
	
	@Query("select c from Comercial c where c.idComercial=?1")
	public Comercial findOneComercial(int idComercial);

}
