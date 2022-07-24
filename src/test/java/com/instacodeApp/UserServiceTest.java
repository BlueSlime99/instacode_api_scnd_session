package com.instacodeApp;

import com.instacodeApp.use_cases.user.repository.UserRepository;
import com.instacodeApp.use_cases.user.service.DefaultUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DefaultUserService defaultUserService;

    @Test
    void returnAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of());

        final var result = defaultUserService.getAllUsers();

        assertEquals(List.of(), result);
    }
}
