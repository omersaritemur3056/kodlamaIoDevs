package kodlamaIo.kodlamaIoDevs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	//final değişkenini araştır.
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		//super();
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		for (ProgrammingLanguage inDbLanguage : programmingLanguageRepository.findAll()) {
			if (inDbLanguage.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu isimli programlama dili zaten mevcut!");
			}
			if (inDbLanguage.getId() == programmingLanguage.getId()) {
				throw new Exception("İd tekrar edemez!");
			}
		}
		
		programmingLanguageRepository.save(programmingLanguage);
	}

//	@Override
//	public void delete(int id) throws Exception {
//		
//		for (ProgrammingLanguage programmingLanguage : programmingLanguageRepository.findAll()) {
//			if (programmingLanguage.getId() == id ) {
//				programmingLanguageRepository.delete(id);
//			}
//		}
//	}

//	@Override
//	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
//		
//		if (programmingLanguage.getName().isBlank()) {
//			throw new Exception("Programlama dili boş geçilemez!");
//		}
//		
//		for (ProgrammingLanguage inDbLanguage : programmingLanguageRepository.findAll()) {
//			if (inDbLanguage.getName().equals(programmingLanguage.getName())) {
//				throw new Exception("Bu isimli programlama dili zaten mevcut!");
//			}
//		}
//		
//		programmingLanguageRepository.(programmingLanguage);
//	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.findAll();
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		
		return programmingLanguageRepository.getById(id);
	}
	
}
