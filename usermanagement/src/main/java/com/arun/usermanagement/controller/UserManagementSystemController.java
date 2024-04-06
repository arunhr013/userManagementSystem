package com.arun.usermanagement.controller;

import com.arun.usermanagement.dto.UserManagementSystemDTO;
import com.arun.usermanagement.service.UserManagementSystemService;
import com.arun.usermanagement.util.ApplicationConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApplicationConstants.API_VERSION_V1)
@Log4j2
public class UserManagementSystemController {

    private final UserManagementSystemService userManagementSystemService;
private final KafkaTemplate<String, Object> kafkaTemplate;

    public UserManagementSystemController(UserManagementSystemService userManagementSystemService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.userManagementSystemService = userManagementSystemService;
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping(value = ApplicationConstants.GET_ALL_USER)
    public ResponseEntity<List<UserManagementSystemDTO>> getUserPresentationList() {
        List<UserManagementSystemDTO> list = userManagementSystemService.getUserPresentationList();
        return ResponseEntity.ok(list);
    }

    @PostMapping(ApplicationConstants.CREATE_USER)
    public ResponseEntity<UserManagementSystemDTO> createUser(@RequestBody UserManagementSystemDTO createOrUpdateUserManagementSystemDTO) {
        UserManagementSystemDTO userManagementSystemDTO = userManagementSystemService.createUser(createOrUpdateUserManagementSystemDTO);
        try {
            kafkaTemplate.send(ApplicationConstants.TOPIC_NAME, userManagementSystemDTO);
            log.info("Sent user management system DTO to {}", userManagementSystemDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(userManagementSystemDTO, null, HttpStatus.CREATED);
    }

    @GetMapping(ApplicationConstants.GET_USER)
    public UserManagementSystemDTO getUserById(@PathVariable("id") Long id) {
        return userManagementSystemService.getUserById(id);
    }

    @PutMapping(ApplicationConstants.EDIT_USER)
    public ResponseEntity<UserManagementSystemDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserManagementSystemDTO updateUserManagementSystemDTO) {
        return new ResponseEntity<>(userManagementSystemService.updateUser(id, updateUserManagementSystemDTO), null, HttpStatus.CREATED);
    }

    @DeleteMapping(ApplicationConstants.DELETE_USER)
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        userManagementSystemService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
