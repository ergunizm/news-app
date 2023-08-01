package com.ergun.news.business.concretes;

import com.ergun.news.business.abstracts.UserService;
import com.ergun.news.dataAccess.abstracts.UserRepository;
import com.ergun.news.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User u = repository.findById(id);
        if(u != null){
            repository.delete(u);
        }
    }
}
