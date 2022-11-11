package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	
	List<ProgrammingLanguage> findAllById(int id);
	List<ProgrammingLanguage> findAllByName(String name);
	
	ProgrammingLanguage findById(int id);
	
	
	ProgrammingLanguage findByNameAndId(String name, int id);
}
