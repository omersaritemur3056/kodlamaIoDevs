package kodlamaIo.kodlamaIoDevs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaIo.kodlamaIoDevs.entities.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {

	List<ProgrammingTechnology> findAllById(int id);
	List<ProgrammingTechnology> findAllByName(String name);
	
	ProgrammingTechnology findByName(String name);
	ProgrammingTechnology findById(int id);
	
	List<ProgrammingTechnology> findAllByProgrammingLanguage_Name(@Param("name") String name);
	ProgrammingTechnology findByProgrammingLanguage_Name(@Param("name") String name);
}
