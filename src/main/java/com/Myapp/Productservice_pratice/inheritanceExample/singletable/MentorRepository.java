package com.Myapp.Productservice_pratice.inheritanceExample.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("jt_mentor_repo")

public interface MentorRepository extends JpaRepository<Mentor,Long> {

}
