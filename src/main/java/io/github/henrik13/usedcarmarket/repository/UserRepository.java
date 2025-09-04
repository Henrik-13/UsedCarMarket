package io.github.henrik13.usedcarmarket.repository;

import io.github.henrik13.usedcarmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
