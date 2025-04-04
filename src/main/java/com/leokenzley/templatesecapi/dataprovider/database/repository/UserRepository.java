package com.leokenzley.templatesecapi.dataprovider.database.repository;

import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for UserEntity.
 * This interface extends JpaRepository to provide CRUD operations for UserEntity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
