package kodlamaIo.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingLanguageService;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingTechnologyRepository programmingTechnologyRepository) {
		//super();
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.programmingTechnologyRepository = programmingTechnologyRepository;
	}
	

	@Override
	public void add(CreateProgrammingLanguage createProgrammingLanguage) throws Exception {
		
		if (createProgrammingLanguage.getName().isBlank() || isNameExist(createProgrammingLanguage.getName())) {
			throw new Exception("Ekleme koşulları sağlanamadı! Kuralları inceleyiniz.");
		}
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguage.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception {
		
		if (!isIdExist(deleteProgrammingLanguage.getId())) {
			throw new Exception("Silinecek objenin id'si bulunamadı!");
		}
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(deleteProgrammingLanguage.getId());
		
		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception {
		
		if (isNameExist(updateProgrammingLanguage.getName()) || isIdNotExist(updateProgrammingLanguage.getId())) {
			throw new Exception("Güncelleme koşulları sağlanamadı! Koşulları inceleyiniz.");
		}
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguage.getId());
		programmingLanguage.setName(updateProgrammingLanguage.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetListProgrammingLanguage> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetListProgrammingLanguage> getListProgrammingLanguagesResponse = new ArrayList<>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetListProgrammingLanguage programmingLanguageResponseItem = new GetListProgrammingLanguage();
			programmingLanguageResponseItem.setId(programmingLanguage.getId());
			programmingLanguageResponseItem.setName(programmingLanguage.getName());
			//88. satıra kadar olan kodlar bütün programlama dillerinin teknolojilerini göstermek içindi
			var techs = programmingTechnologyRepository.findAll().stream()
                    .filter(x -> x.getProgrammingLanguage().getId() == programmingLanguage.getId()).toList();
            List<String> listItem = new ArrayList<>();
            for (var tech : techs) {
                listItem.add(tech.getName());
            }
            programmingLanguageResponseItem.setProgrammingTechnologies(listItem);
			
			getListProgrammingLanguagesResponse.add(programmingLanguageResponseItem);
		}
		
		return getListProgrammingLanguagesResponse;
	}

	@Override
	public GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception {
		
		if (!isIdExist(id)) {
			throw new Exception("Id bulunamadı!");
		}
		
		ProgrammingLanguage result = programmingLanguageRepository.findById(id);
		GetProgrammingLanguageById getProgrammingLanguageById = new GetProgrammingLanguageById();
		
		getProgrammingLanguageById.setId(result.getId());
		getProgrammingLanguageById.setName(result.getName());
		//bir programlama dilinin bütün technologylerini göstermek içindi buradan 115. satıra kadar olan kodlar
		var techs = programmingTechnologyRepository.findAll().stream()
                .filter(x -> x.getProgrammingLanguage().getId() == id).toList();
        List<String> listItem = new ArrayList<>();
        for (var tech : techs) {
            listItem.add(tech.getName());
        }
        getProgrammingLanguageById.setProgrammingTechnologies(listItem);
		
		return getProgrammingLanguageById;
	}
	
	

	private boolean isNameExist(String name) {
		for (ProgrammingLanguage pl : programmingLanguageRepository.findAll()) {
			if (pl.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIdExist(int id) {
		for (ProgrammingLanguage pl : programmingLanguageRepository.findAll()) {
			if (pl.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIdNotExist(int id) {
		for (ProgrammingLanguage pl : programmingLanguageRepository.findAll()) {
			if (pl.getId() == id) {
				return false;
			}
		}
		
		return true;
	}
}
