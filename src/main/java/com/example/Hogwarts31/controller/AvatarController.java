package com.example.Hogwarts31.controller;
import com.example.Hogwarts31.service.AvatarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RequestMapping("/avatar")
@RestController
public class AvatarController {

    private final AvatarService avatarService;
    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;

    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public long uploadAvatar(@RequestParam("studentId") long studentId,
                               @RequestBody MultipartFile file) throws IOException {
        return avatarService.uploadAvatar(studentId, file);
    }

    @GetMapping("/get/from-db")
    public byte[] getAvatarFromDb(@RequestParam("studentId") long studentId) {
    return avatarService.getAvatarFromDb(studentId);
    }

    @GetMapping("/get/from-local")
    public byte[] getAvatarFromLocal(@RequestParam("studentId") long studentId) {
        return getAvatarFromLocal(studentId);
    }

}
