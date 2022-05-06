package com.kolvin.kplaform.services;

import com.kolvin.kplaform.models.TelcoUser;
import com.kolvin.kplaform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<TelcoUser> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(TelcoUser user) {
        Optional<TelcoUser> userByMobileNumber = userRepository.findUserByMobileNumber(user.getMobileNumber());

        if (userByMobileNumber.isPresent()) {
            throw new IllegalStateException("Msisdn already exist");
        }

        userRepository.save(user);
    }

    public void removeUser(int userId) {
        boolean studentExists = userRepository.existsById(userId);

        if (!studentExists) {
            throw new IllegalStateException("User do not exists with id " + userId);
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(int userId, int status, String serviceProvider) {
        TelcoUser user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User do not exists with id " + userId
        ));

        if (status > 0 && user.getStatus() != status) {
            user.setStatus(status);
        }

        if (serviceProvider != null && serviceProvider.length() > 0 &&
                !Objects.equals(user.getServiceProvider(), serviceProvider)) {
            user.setServiceProvider(serviceProvider);
        }
    }
}
