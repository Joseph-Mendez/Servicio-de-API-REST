package com.example.Servicio_API_REST.service;

import com.example.Servicio_API_REST.dto.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> userMap = new HashMap<>();
    private long currentId = 1L;

    @Override
    public User createUser(User user) {
        user.setId(currentId++);
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userMap.containsKey(id)) {
            user.setId(id);
            userMap.put(id, user);
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }
}
