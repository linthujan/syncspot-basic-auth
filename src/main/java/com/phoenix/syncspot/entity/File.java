package com.phoenix.syncspot.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private long fileSize;
    private String path;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "file")
    private List<User> user = new ArrayList<>();

    public File(String name, String type, long fileSize, String path, List<User> user) {
        this.name = name;
        this.type = type;
        this.fileSize = fileSize;
        this.path = path;
        this.user = user;
    }
    public File() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getFileSize() {
        return fileSize;
    }
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }
    public void addUser(User user){
        this.user.add(user);
        user.getFile().add(this);
    }
    public void removeUser(User user){
        this.user.remove(user);
        user.getFile().remove(this);
    }
}
