package com.example.Hogwarts31.service;

import com.example.Hogwarts31.model.Student;
import com.example.Hogwarts31.model.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> repository = new HashMap<>();
    private long counter = 0;

    @Override
    public long add(Student student) {
        student.setId(++counter);
        repository.put(counter, student);
        return counter;
    }

    @Override
    public Student update(Long id, Student student) {
        checkStudentExist(id);
        //Student studentForUpdate = repository.get(id);

        return repository.put(id, student);
    }


    @Override
    public Student deleteById(Long id) {
        checkStudentExist(id);
        return repository.remove(id);

    }

    @Override
    public Student findById(Long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Student> FindAll() {
        return Collections.unmodifiableCollection
                (repository.values());
    }



    @Override
    public  Collection<Student> FindByAge(int age) {
        return repository.values().stream().filter(st -> st.getAge() == age).toList();
    }

    private void checkStudentExist(Long id) {
        if (!repository.containsKey(id)) {
            throw new StudentNotFoundException(id);
        }
    }
}
