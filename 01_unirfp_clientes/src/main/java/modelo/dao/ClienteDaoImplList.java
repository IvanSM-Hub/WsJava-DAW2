package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Cliente;

public class ClienteDaoImplList implements ClienteDao{
	
	private List<Cliente> lista;
	
	public ClienteDaoImplList() {
		lista=new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		lista.add(new Cliente(1,"UNIRFP",128,1_000_000));
		lista.add(new Cliente(2,"UNIR",1000,7_000_000));
		lista.add(new Cliente(3,"TTT",67,3_000_000));
	}

	@Override
	public Cliente findById(int idCliente) {
		for (int i=0;i<lista.size();i++) {
			if(lista.get(i).getIdCliente() == idCliente) {
				return lista.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		return lista;
	}

	@Override
	public Cliente insert(Cliente cliente) {
		if(!lista.contains(cliente)) {
			lista.add(cliente);
			cliente.setIdCliente(lista.size());
			return cliente;
		}
		return null;
	}

	@Override
	public int delete(int idCliente) {
		Cliente cliente = findById(idCliente);
		
		if (cliente == null) 
			return 0;
		
		return lista.remove(cliente) ? 1 : 0;
		
	}

}//End ClienteDaoImplList
