package com.example.Hogwarts31.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static javax.swing.text.html.HTML.Tag.OL;

public interface AvatarService {

    long uploadAvatar(long studentId, MultipartFile file) throws IOException;


    byte[] getAvatarFromDb(long studentId);


    byte[] getAvatarFromLocal(long studentId);

}
