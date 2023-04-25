package com.example.test.Services;

import com.example.test.Domain.TestEntity;
import com.example.test.Repository.Interfaces.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    ITestRepository testRepository;

    public List<TestEntity> getAllTests()
    {
        List<TestEntity> tests = new ArrayList<TestEntity>();
        testRepository.findAll().forEach(test -> tests.add(test));
        return tests;
    }

    public TestEntity getTestById(int id)
    {
        return testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test not found"));
    }

    public TestEntity save(TestEntity test)
    {
        Optional<TestEntity> found = testRepository.findById(test.Id);
        if (!found.isEmpty()) throw new RuntimeException("Test with id" + test.Id + "Already exists");
        return testRepository.save(test);
    }

    public void delete(TestEntity test)
    {
        testRepository.findById(test.Id).orElseThrow(() -> new RuntimeException("Test not found"));
        testRepository.deleteById(test.Id);
    }

    public TestEntity update(TestEntity test, int testid)
    {
        TestEntity existingTest = testRepository.findById(testid).orElseThrow(() -> new RuntimeException("Test not found"));
        existingTest.setName(test.getName());
        return testRepository.save(existingTest);
    }
}
