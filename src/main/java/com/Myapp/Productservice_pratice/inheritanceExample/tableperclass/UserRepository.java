package com.Myapp.Productservice_pratice.inheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_user_repo")

public interface UserRepository extends JpaRepository<User,Long> {
}
