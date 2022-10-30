package kodlamaIo.kodlamaIoDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamaIo.kodlamaIoDevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	//Collection<ProgrammingLanguage> programmingLanguages2 = new ArrayList<ProgrammingLanguage>();

	public InMemoryProgrammingLanguageDao() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
	}
	
	
	@Override
	public void save(ProgrammingLanguage programmingLanguage) {
		
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		
		programmingLanguages.remove(programmingLanguage);
	}

	@Override
	public void modify(ProgrammingLanguage programmingLanguage) throws Exception {
		
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == programmingLanguage.getId()) {
				programmingLanguages.set(language.getId() -1, programmingLanguage);
			}
		}
	}

	@Override
	public List<ProgrammingLanguage> getList() {
		
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return programmingLanguages.get(id - 1);
	}
	
	
	
}
