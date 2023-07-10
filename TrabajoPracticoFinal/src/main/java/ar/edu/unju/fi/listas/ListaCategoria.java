package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaCategoria {
	private List<String>categorias;
	
	//esta escrito en mayusculas por que es un constructor no un metodo ordinario
	public ListaCategoria() {
		categorias= new ArrayList<String>();
		categorias.add("Carnes");
		categorias.add("Bebidas");
		categorias.add("Dulces");
		categorias.add("Ensaladas");
		categorias.add("Legumbres y Cereales");
		categorias.add("Pescados");
		categorias.add("Pan");
		categorias.add("Sopas y Cremas");
	}
	
	/**
	 * Al llamar al método, se obtiene la lista de Categorias almacenadas 
	 * en el objeto ListaCategorias.
	 * @return devuelve un objeto de tipo List<String> que contiene los nombres de las Categorias.
	 */
	public List<String> getCategorias(){
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
}
