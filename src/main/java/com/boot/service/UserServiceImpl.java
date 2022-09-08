package com.boot.service;

import com.boot.model.User;
import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(User user, Long id) {
        User currentUser = findUserById(id);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setAge(user.getAge());
        return userRepository.save(currentUser);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
