package io.rugvedmarathe.springbootvalidations.repository;

import io.rugvedmarathe.springbootvalidations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
