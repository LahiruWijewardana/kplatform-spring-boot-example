package com.kolvin.kplaform.repository;

import com.kolvin.kplaform.models.TelcoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TelcoUser, Integer> {
  Optional<TelcoUser> findUserByMobileNumber(String mobileNumber);
}