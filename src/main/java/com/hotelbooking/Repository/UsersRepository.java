package com.hotelbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.Entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

}

