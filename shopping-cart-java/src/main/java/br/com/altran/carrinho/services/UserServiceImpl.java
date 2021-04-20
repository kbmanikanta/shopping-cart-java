package br.com.altran.carrinho.services;

import br.com.altran.carrinho.dto.UserRequest;
import br.com.altran.carrinho.dto.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse authenticate(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        try {
            log.info("Inside authenticate {}", new ObjectMapper().writeValueAsString(userRequest));
            userResponse.setToken(UUID.randomUUID().toString());
        } catch (JsonProcessingException e) {
            log.error("Error in authenticate method {}", e.getMessage(), e);
        }
        return userResponse;
    }
}
