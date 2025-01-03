package com.example.Hogwarts31.service.impl;

import com.example.Hogwarts31.model.Avatar;
import com.example.Hogwarts31.model.Student;
import com.example.Hogwarts31.model.exception.StudentNotFoundException;
import com.example.Hogwarts31.repository.AvatarRepository;
import com.example.Hogwarts31.repository.StudentRepository;
import com.example.Hogwarts31.service.AvatarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AvatarServiceImpl implements AvatarService {
    @Value("${image.path}")
    private  String pathDir;  //  или без аннотации private final String pathDir= "images";

    private final AvatarRepository avatarRepository;

    private final StudentRepository studentRepository;

    public AvatarServiceImpl(AvatarRepository avatarRepository,StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public long uploadAvatar(long studentId, MultipartFile file) throws IOException {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new StudentNotFoundException(studentId));
        Avatar avatar = new Avatar(
                null,
                file.getSize(),
                file.getContentType(),
                file.getBytes(),
                student

        );

         avatarRepository.save(avatar);
        return avatar.getId();
    }



    private String saveAvatarLocal() {
        return null;

    }

    private void createDirectoryIfNotExist() {

    }


    @Override
    public byte[] getAvatarFromDb(long studentId) {
        return new byte[0];
    }

    @Override
    public byte[] getAvatarFromLocal(long studentId) {
        return new byte[0];
    }
}
