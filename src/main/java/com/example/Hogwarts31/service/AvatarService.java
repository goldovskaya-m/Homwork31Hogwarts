package com.example.Hogwarts31.service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



public interface AvatarService {

    long uploadAvatar(long studentId, MultipartFile file) throws IOException;


    byte[] getAvatarFromDb(long studentId);


    byte[] getAvatarFromLocal(long studentId);

}
