package com.ntuc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.hresource.model.Department;
import com.hresource.repository.DepartmentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DepartmentRepositorTestDatabase {
	
	@Autowired
	private DepartmentRepository repo;
	
	@Test
	public void testDepartment() {
	Department savedDepartment = 	repo.save(new Department("Televisions"));
		assertThat(savedDepartment.getId()).isGreaterThan(0);
		
	}
	

}
