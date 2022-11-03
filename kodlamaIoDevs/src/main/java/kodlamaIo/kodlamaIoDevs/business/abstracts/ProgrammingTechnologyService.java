package kodlamaIo.kodlamaIoDevs.business.abstracts;

import java.util.List;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;
import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyService {

	void add(ProgrammingTechnology programmingTechnology) throws Exception;
	//void delete(int id) throws Exception;
	//void update(ProgrammingLanguage programmingLanguage) throws Exception;
	
	List<ProgrammingTechnology> getAll();
	ProgrammingTechnology getProgrammingTechnologyId(int id);
}
