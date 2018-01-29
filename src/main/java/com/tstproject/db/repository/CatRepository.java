package com.tstproject.db.repository;

import com.tstproject.db.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    @Query("from Cat c where c.name like '% %'")
    List<Cat> getCatsWithSpaces();
}
