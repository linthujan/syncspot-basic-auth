package com.phoenix.syncspot.service;



import com.phoenix.syncspot.repository.FileRepository;
import com.phoenix.syncspot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FileService {
    @Autowired
    FileRepository fileRepo;
    @Autowired
    UserRepository userRepo;
}
