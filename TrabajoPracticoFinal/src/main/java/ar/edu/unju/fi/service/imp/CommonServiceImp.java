package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaCategoria;
import ar.edu.unju.fi.service.ICommonService;

@Service
public class CommonServiceImp implements ICommonService {
	
	@Autowired
	private ListaCategoria listaCategoria;
	
	@Override
	public List<String> getCategorias() {
		return listaCategoria.getCategorias();
	}

}
