package com.example.demo.service;

import com.example.demo.entitiy.Basket;
import com.example.demo.entitiy.User;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    /**
     * Yeni bir kullanıcı oluşturur ve ona boş bir sepet atar.
     */
    public UserResponse createUser(UserRequest userRequest) {
        User user = toEntity(userRequest);

        // Kullanıcıya boş bir sepet atıyoruz
        Basket basket = new Basket();
        basketRepository.save(basket);
        user.setUserBasket(basket);

        userRepository.save(user);
        return toResponse(user);
    }

    /**
     * Tüm kullanıcıları getirir.
     */
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(toResponse(user));
        }
        return userResponses;
    }

    // Request ve Response dönüştürücüler
    public User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setUserfullname(userRequest.getUsername());
        user.setUseremail(userRequest.getEmail());
        user.setUserpassword(userRequest.getPassword());
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getUserfullname());
        response.setEmail(user.getUseremail());
        return response;
    }

    public UserResponse updateUser(UserRequest request, Long id) {
        return null;
    }

    public void deleteUser(Long id) {

    }
}
