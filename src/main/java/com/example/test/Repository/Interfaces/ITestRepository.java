package com.example.test.Repository.Interfaces;

import com.example.test.Domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<TestEntity, Integer> {

}
