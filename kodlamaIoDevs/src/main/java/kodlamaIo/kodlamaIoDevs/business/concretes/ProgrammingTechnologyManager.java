package kodlamaIo.kodlamaIoDevs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIo.kodlamaIoDevs.business.abstracts.ProgrammingTechnologyService;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import kodlamaIo.kodlamaIoDevs.business.responses.programmingTechnologyResponse.GetProgrammingTechnologyById;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

	@Autowired
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;
	

	@Override
	public void add(CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
		
		if (createProgrammingTechnology.getName().isBlank() || isNameExist(createProgrammingTechnology.getName())) {
			throw new Exception("Ekleme koşulları sağlanamadı! Kuralları inceleyiniz.");
		}
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage language = programmingLanguageRepository.findById(createProgrammingTechnology.getProgrammingLanguageId());
		programmingTechnology.setName(createProgrammingTechnology.getName());
		programmingTechnology.setProgrammingLanguage(language);
		
		
		programmingTechnologyRepository.save(programmingTechnology);
	}

	@Override
	public void delete(DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
		
		if (!isIdExist(deleteProgrammingTechnology.getId())) {
			throw new Exception("Silinecek objenin id'si bulunamadı!");
		}
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		programmingTechnology.setId(deleteProgrammingTechnology.getId());
		
		programmingTechnologyRepository.delete(programmingTechnology);
	}

	@Override
	public void update(UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
		
		if (isNameExist(updateProgrammingTechnology.getName()) || isIdNotExist(updateProgrammingTechnology.getId())) {
			throw new Exception("Güncelleme koşulları sağlanamadı! Koşulları inceleyiniz.");
		}
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingTechnology.getProgrammingLanguageId());
		programmingTechnology.setId(updateProgrammingTechnology.getId());
		programmingTechnology.setName(updateProgrammingTechnology.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		programmingTechnologyRepository.save(programmingTechnology);
	}

	@Override
	public List<GetListProgrammingTechnology> getAll() {
		
		List<ProgrammingTechnology> programmingTechnologies = programmingTechnologyRepository.findAll();
		List<GetListProgrammingTechnology> getListProgrammingTechnologiesResponse = new ArrayList<>();
		var result = programmingTechnologies.stream().findAny().get();
		
		for (ProgrammingTechnology programmingTechnology : programmingTechnologies) {
			GetListProgrammingTechnology programmingTechnologyResponseItem = new GetListProgrammingTechnology();
			
			programmingTechnologyResponseItem.setId(programmingTechnology.getId());
			programmingTechnologyResponseItem.setName(programmingTechnology.getName());
			programmingTechnologyResponseItem.setProgrammingLanguageId(result.getProgrammingLanguage().getId());
			programmingTechnologyResponseItem.setProgrammingLanguageName(result.getProgrammingLanguage().getName());
			
			getListProgrammingTechnologiesResponse.add(programmingTechnologyResponseItem);
		}
		
		return getListProgrammingTechnologiesResponse;
	}

	@Override
	public GetProgrammingTechnologyById getProgrammingTechnologyId(int id) throws Exception {
		
		if (!isIdExist(id)) {
			throw new Exception("Id bulunamadı!");
		}
		
		ProgrammingTechnology result = programmingTechnologyRepository.findById(id);
		GetProgrammingTechnologyById getProgrammingTechnologyeById = new GetProgrammingTechnologyById();		
		
		getProgrammingTechnologyeById.setId(result.getId());
		getProgrammingTechnologyeById.setName(result.getName());
		getProgrammingTechnologyeById.setProgrammingLanguageId(result.getProgrammingLanguage().getId());
		getProgrammingTechnologyeById.setProgrammingLanguageName(result.getProgrammingLanguage().getName());
		
		return getProgrammingTechnologyeById;
	}

	
	
	private boolean isNameExist(String name) {
		for (ProgrammingTechnology pt : programmingTechnologyRepository.findAll()) {
			if (pt.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIdExist(int id) {
		for (ProgrammingTechnology pt : programmingTechnologyRepository.findAll()) {
			if (pt.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isIdNotExist(int id) {
		for (ProgrammingTechnology pt : programmingTechnologyRepository.findAll()) {
			if (pt.getId() == id) {
				return false;
			}
		}
		
		return true;
	}
}
