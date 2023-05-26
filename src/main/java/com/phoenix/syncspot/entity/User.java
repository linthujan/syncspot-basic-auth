package com.phoenix.syncspot.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;
    private String department;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<File> file = new ArrayList<>();

    public User(String username, String fullname, String department, List<File> file) {
        this.username = username;
        this.fullname = fullname;
        this.department = department;
        this.file = file;
    }
    public User() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public List<File> getFile() {
        return file;
    }
    public void setFile(List<File> file) {
        this.file = file;
    }
    public void addFile(File file){
        this.file.add(file);
        file.getUser().add(this);
    }
    public void removeFile(File file){
        this.file.remove(file);
        file.getUser().remove(this);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
