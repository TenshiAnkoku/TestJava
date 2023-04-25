package com.example.test.Controllers;

import com.example.test.Domain.TestEntity;
import com.example.test.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/tests")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping()
    private ResponseEntity<List<TestEntity>> getAllTests()
    {
        List<TestEntity> tests = testService.getAllTests();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/{testid}")
    private ResponseEntity<TestEntity> getBooks(@PathVariable("testid") int testid)
    {
        try {
            TestEntity test = testService.getTestById(testid);
            return new ResponseEntity<>(test, HttpStatus.OK);
        } catch(Exception ex) {
            throw new ResponseStatusException(NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping()
    private ResponseEntity<TestEntity> deleteTest(@RequestBody TestEntity test)
    {
        try {
            testService.delete(test);
            return new ResponseEntity<>(test, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(CONFLICT, ex.getMessage());
        }
    }

    @PostMapping()
    private ResponseEntity<TestEntity> saveTest(@RequestBody TestEntity test)
    {
        try {
            TestEntity saved = testService.save(test);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new ResponseStatusException(CONFLICT, ex.getMessage());
        }
    }

    @PutMapping("/{testid}")
    private ResponseEntity<TestEntity> update(@RequestBody TestEntity test, @PathVariable("testid") int testid)
    {
        try {
            TestEntity testUpdated = testService.update(test, testid);
            return new ResponseEntity<>(testUpdated, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(NOT_FOUND, ex.getMessage());
        }
    }
}
