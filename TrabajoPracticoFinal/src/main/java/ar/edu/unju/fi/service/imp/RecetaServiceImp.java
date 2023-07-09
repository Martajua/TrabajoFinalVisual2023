/*
 * package ar.edu.unju.fi.service.imp;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import ar.edu.unju.fi.entity.Receta; import
 * ar.edu.unju.fi.repository.IRecetaRepository; import
 * ar.edu.unju.fi.service.IRecetaService;
 * 
 * @Service public class RecetaServiceImp implements IRecetaService {
 * 
 * @Autowired private Receta receta;
 * 
 * @Autowired private IRecetaRepository recetaRepository;
 * 
 * @Override public void addReceta(Receta receta) {
 * 
 * recetaRepository.save(receta); }
 * 
 * @Override public List<Receta> getAllRecetas() { List<Receta> recetas =
 * recetaRepository.findByEstado(true); return recetas; }
 * 
 * @Override public void deleteRecetaById(Receta receta) {
 * receta.setEstado(false); recetaRepository.save(receta);
 * 
 * }
 * 
 * @Override public Receta findRecetaById(Long id) { receta =
 * recetaRepository.findById(id).get(); return receta; }
 * 
 * }
 */
