package com.example.Hogwarts31.model.exception;

public class FacultyNotFoundException extends RuntimeException{
    private final long id;

    public FacultyNotFoundException(long id) {
        super("Faculty not found by id: [%s]".formatted(id));
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
