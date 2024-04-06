package com.arun.usermanagement.service;

import com.arun.usermanagement.dto.UserManagementSystemDTO;
import com.arun.usermanagement.entity.UserManagementSystem;
import com.arun.usermanagement.mapper.UserMapper;
import com.arun.usermanagement.repository.UserManagementSystemRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementSystemService {

    private final UserManagementSystemRepository userManagementSystemRepository;

    private  final UserMapper userMapper;

    public UserManagementSystemService(UserManagementSystemRepository userManagementSystemRepository, UserMapper userMapper) {
        this.userManagementSystemRepository = userManagementSystemRepository;
        this.userMapper = userMapper;
    }

    public void deleteUserById(Long id) {
        userManagementSystemRepository.deleteById(id);
    }

    public UserManagementSystemDTO updateUser(Long id, UserManagementSystemDTO updateUserManagementSystemDTO) {
        Optional<UserManagementSystem> user = userManagementSystemRepository.findById(id);
        if(user.isPresent()) {
          updateUserManagementSystemDTO.setId(id);
          userManagementSystemRepository.save(userMapper.toEntity(updateUserManagementSystemDTO));
          return userMapper.toDto(user.get());
        }
        return null;

    }

    public UserManagementSystemDTO createUser(UserManagementSystemDTO createOrUpdateUserManagementSystemDTO) {

       return userMapper.toDto(userManagementSystemRepository.save(userMapper.toEntity(createOrUpdateUserManagementSystemDTO)));

    }

    public List<UserManagementSystemDTO> getUserPresentationList() {
        return userMapper.toDtoList(userManagementSystemRepository.findAll());
    }

    public UserManagementSystemDTO getUserById(Long id) {
        Optional<UserManagementSystem> user = userManagementSystemRepository.findById(id);
        return user.map(userMapper::toDto).orElse(null);

    }
}
