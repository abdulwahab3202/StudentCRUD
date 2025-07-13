package com.kce.service;

import com.kce.enumeration.ResponseStatus;
import com.kce.models.Users;
import com.kce.repository.UserRepository;
import com.kce.response.CommonResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    @Override
    public CommonResponce register(Users users) {
        CommonResponce response = new CommonResponce();
        try{
            Users existingUser = userRepository.findByUsername(users.getUsername());
            if(existingUser != null){
                response.setStatus(ResponseStatus.FAILURE);
                response.setErrorMessage("User Already Exists");
                response.setCode(404);
                return response;
            }
            else{
                users.setPassword(passwordEncoder.encode(users.getPassword()));
                Users user = userRepository.save(users);
                response.setStatus(ResponseStatus.SUCCESS);
                response.setSuccessMessage("User Registered Successfully");
                response.setData(user);
                response.setCode(200);
                return response;
            }
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setErrorMessage("Failed to register the user");
            response.setCode(404);
            return response;
        }
    }

    @Override
    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "failed";
    }
}
