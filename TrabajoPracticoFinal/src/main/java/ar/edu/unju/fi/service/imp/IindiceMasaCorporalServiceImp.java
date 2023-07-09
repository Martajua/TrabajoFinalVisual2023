/*
 * package ar.edu.unju.fi.service.imp;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import ar.edu.unju.fi.entity.IndiceMasaCorporal; import
 * ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository; import
 * ar.edu.unju.fi.service.IIndiceMasaCorporalService;
 * 
 * @Service public class IindiceMasaCorporalServiceImp implements
 * IIndiceMasaCorporalService {
 * 
 * @Autowired private IndiceMasaCorporal indiceMasaCorporal;
 * 
 * @Autowired private IIndiceMasaCorporalRepository
 * indiceMasaCorporalRepository;
 * 
 * @Override public void addTestimonio(IndiceMasaCorporal masaCorporal) {
 * 
 * indiceMasaCorporalRepository.save(masaCorporal);
 * 
 * }
 * 
 * @Override public List<IndiceMasaCorporal> getAllImc() {
 * List<IndiceMasaCorporal> imc =
 * indiceMasaCorporalRepository.findByEstado(true); return imc; }
 * 
 * @Override public void deleteImcById(IndiceMasaCorporal masaCorporal) {
 * masaCorporal.setEstado(false);
 * indiceMasaCorporalRepository.save(masaCorporal); }
 * 
 * @Override public IndiceMasaCorporal findIndiceMasaCorporalById(Integer id) {
 * indiceMasaCorporal = indiceMasaCorporalRepository.findById(id).get(); return
 * indiceMasaCorporal; }
 * 
 * }
 */