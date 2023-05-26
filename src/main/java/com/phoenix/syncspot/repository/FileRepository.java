package com.phoenix.syncspot.repository;

import com.phoenix.syncspot.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    public boolean existsByName(String name);
}
