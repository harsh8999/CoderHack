// package com.harsh.coderhack.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.harsh.coderhack.dto.UserResponseDto;
// import com.harsh.coderhack.entity.User;
// import com.harsh.coderhack.exception.ResourceNotFoundException;
// import com.harsh.coderhack.repository.UserRepository;
// import com.harsh.coderhack.services.UserServiceImplementation;

// @SpringBootTest
// public class UserServiceTest {

//     @InjectMocks
//     private UserServiceImplementation userService;

//     @MockBean
//     private UserRepository userRepository;

//     @BeforeEach
//     public void setUp() {
//         userRepository = mock(UserRepository.class);
//         userService = new UserServiceImplementation(userRepository);
//     }

//     @Test
//     public void createUserTest() {
//         when(userRepository.save(any(User.class))).thenReturn(new User(1, "Harsh"));

//         UserResponseDto createdUser = userService.createUser(1, "Harsh");

//         // Verify that the user was created successfully
//         assertEquals(1, (int) createdUser.getId());
//         assertEquals("Harsh", createdUser.getUsername());

//     }

//     @Test
//     public void getUserTest() {
//         when(userRepository.findById(any(Integer.class))).thenReturn(Optional.of(new User(1, "Harsh")));

//         UserResponseDto retrivedUser = userService.getUser(1);

//         assertEquals(1, (int) retrivedUser.getId());
//         assertEquals("Harsh", retrivedUser.getUsername());
//     }

//     @Test
//     public void getUserThrowsExceptionUserNotFoundTest() {
//         when(userRepository.findById(any(Integer.class))).thenThrow(ResourceNotFoundException.class);
//         assertThrows(ResourceNotFoundException.class, () -> userService.getUser(90));
//     }

//     @Test
//     public void deregisterUserThrowsExceptionUserNotFoundTest() {
//         when(userRepository.findById(any(Integer.class))).thenThrow(ResourceNotFoundException.class);
//         assertThrows(ResourceNotFoundException.class, () -> userService.deregisterUserFromTheContest(90));
//     }

//     @Test
//     public void updateUserScoreThrowsExceptionUserNotFoundTest() {
//         when(userRepository.findById(any(Integer.class))).thenThrow(ResourceNotFoundException.class);
//         assertThrows(ResourceNotFoundException.class, () -> userService.updateScoreOfUser(82, 90));
//     }
    
//     @Test
//     public void updateUserScoreThrowsRuntimeExceptionTest() {
//         // score less than 0
//         assertThrows(RuntimeException.class, () -> userService.updateScoreOfUser(1, -19));
//         // score more than 100
//         assertThrows(RuntimeException.class, () -> userService.updateScoreOfUser(1,200));
//     }
// }
