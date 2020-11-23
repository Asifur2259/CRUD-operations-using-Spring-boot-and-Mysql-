package com.rafin.crudpro.service;


import com.rafin.crudpro.models.User;
import com.rafin.crudpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public Optional<User> findOne(Long id){
        return repo.findById(id);
    }

    public User saveUser(User user){
        return repo.save(user);
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}
