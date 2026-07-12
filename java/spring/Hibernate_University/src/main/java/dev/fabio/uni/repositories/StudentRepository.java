package dev.fabio.uni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.fabio.uni.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByLast(String lastName);
	List<Student> findByFirstAndLast(String firstName, String lastName);
	
	Student findByEnroll(String enrollmentId);
	
	@Query("SELECT s FROM Student s WHERE last LIKE %:lst%")
	List<Student> findByLastFragment(@Param("lst") String lastName);
	
	List<Student> findByLastStartingWith(String prefix); // LIKE prefix%
	List<Student> findByLastEndingWith(String suffix); // LIKE prefix%

}
