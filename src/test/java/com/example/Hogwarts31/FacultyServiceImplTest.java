package com.example.Hogwarts31;

import com.example.Hogwarts31.model.Faculty;
import com.example.Hogwarts31.service.impl.FacultyServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.example.Hogwarts31.impl.TestConstants.TEST_FACULTY;
import static com.example.Hogwarts31.impl.TestConstants.TEST_FACULTY_2;
import static org.assertj.core.api.Assertions.assertThat;

public class FacultyServiceImplTest {

    private final FacultyServiceImpl facultyService = new FacultyServiceImpl(null);

    @Test
    void add() {
        //test
        long expected = facultyService.add(TEST_FACULTY);

        //check
        assertThat(expected).isOne();
        Faculty actual = facultyService.findById(expected);
        assertThat(actual).isEqualTo(TEST_FACULTY);
    }

    @Test
    void update() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);
        //test
        Faculty oldFaculty = facultyService.update(targetId, TEST_FACULTY_2);

        //check
        assertThat(oldFaculty).isEqualTo(TEST_FACULTY);
        Faculty actual = facultyService.findById(targetId);
        assertThat(actual).isEqualTo( TEST_FACULTY_2);
    }

    @Test
    void deleteById() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);

        //test
         facultyService.deleteById(targetId);

        //check
        //assertThat(deletedFaculty).isEqualTo(TEST_FACULTY);
        Faculty actual = facultyService.findById(targetId);
        assertThat(actual).isNull();
    }

    @Test
    void findById() {
        long targetId = TEST_FACULTY.getId();
        facultyService.add(TEST_FACULTY);

        //test
        Faculty actual = facultyService.findById(targetId);
        //check
        assertThat(actual).isEqualTo(TEST_FACULTY);

    }

    @Test
    void findAll() {
        facultyService.add(TEST_FACULTY);
        facultyService.add(TEST_FACULTY_2);
        List<Faculty> expected = List.of(TEST_FACULTY, TEST_FACULTY_2);

        //test
        Collection<Faculty> actual = facultyService.findAll();

        //check
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);

    }

    @Test
    void findByColor() {
        facultyService.add(TEST_FACULTY);

        //test
        Collection<Faculty> actual = facultyService.findByColor(TEST_FACULTY.getColor());

        //check
        assertThat(actual).containsExactly(TEST_FACULTY);
    }

}
