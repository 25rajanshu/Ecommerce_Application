package com.Myapp.Productservice_pratice.inheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_student_repo")
public interface Studentrepository extends JpaRepository<Student,Long>{
}
