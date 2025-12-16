package com.example.Vault1X.controller;

import com.example.Vault1X.dto.*;
import com.example.Vault1X.entity.Users;
import com.example.Vault1X.exception.UserAlreadyExistsException;
import com.example.Vault1X.exception.UserNotFoundException;
import com.example.Vault1X.service.UserService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // CREATE USER
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDetailsDto userDetailsDto) {
        log.info("POST /api/users - Creating new user with email: {}", userDetailsDto.getemail());

        try {
            Users createdUser = userService.createUser(userDetailsDto);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "User created successfully");
            response.put("userId", createdUser.getUserId());
            response.put("email", createdUser.getEmail());
            response.put("username", createdUser.getUserName());

            ApiResponseDto<Object> responseData = ApiResponseDto.success("User created successfully", response);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseData);

        } catch (UserAlreadyExistsException e) {
            log.warn("User creation failed: {}", e.getMessage());
            ApiResponseDto<Object> ErrorResponse = ApiResponseDto.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(ErrorResponse);
        } catch (Exception e) {
            log.error("Error creating user: {}", e.getMessage(), e);
            ApiResponseDto<Object> errorResponse = ApiResponseDto.error("Registration failed. Please try again.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }

    // GET USER BY ID
    @GetMapping("{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        log.info("GET /api/users/{} - Fetching user", userId);

        try {
            Users user = userService.getUserById(userId);
            UserDto userDTO = UserDto.fromEntity(user);
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException e) {
            log.warn("User not found with ID: {}", userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            log.error("Error fetching user with ID: {}", userId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("internal error");
        }
    }
    // private Map<String, Object> createErrorResponse(String error, String message)
    // {
    // Map<String, Object> response = new HashMap<>();
    // response.put("timestamp", LocalDateTime.now());
    // response.put("error", error);
    // response.put("message", message);
    // response.put("status", "error");
    // return response;
    // }

    // // GET ALL USERS
    @GetMapping("getusers")
    public ResponseEntity<?> getAllUsers() {
        log.info("GET /api/users - Fetching all users");

        try {
            List<Users> users = userService.getAllUsers();
            List<Map<String, Object>> response = users.stream()
                    .map(user -> {
                        Map<String, Object> userMap = new HashMap<>();
                        userMap.put("userId", user.getUserId());
                        userMap.put("email", user.getEmail());
                        userMap.put("username", user.getUserName());

                        return userMap;
                    })
                    .toList();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error fetching all users", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching users");
        }
    }

    // UPDATE USER
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long userId,
            @Valid @RequestBody UsersUpdateDto usersUpdateDto) {
        log.info("PUT /api/users/{} - Updating user", userId);

        try {
            Users updatedUser = userService.updateUser(userId, usersUpdateDto);
            // Instead of: return ResponseEntity.ok(convertToResponse(updatedUser));

            Map<String, Object> response = new HashMap<>();
            response.put("id", updatedUser.getUserId());
            response.put("username", updatedUser.getUserName());
            response.put("email", updatedUser.getEmail());
            // Add other fields as needed
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            log.warn("User not found for update with ID: {}", updateUser(userId, usersUpdateDto));
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (UserAlreadyExistsException e) {
            log.warn("Update failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        } catch (Exception e) {
            log.error("Error updating user with ID: {}", userId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error");
        }
    }

    // DELETE USER
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUsers(@PathVariable Long userId) {
        log.info("Delete /api/users/{} - Deleting user", userId);
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("user deleted successfully");
        } catch (Exception e) {
            log.error("Error fetching user with ID: {}", userId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + userId);
        }

    }

}
