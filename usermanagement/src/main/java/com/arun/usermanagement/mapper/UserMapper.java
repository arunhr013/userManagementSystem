package com.arun.usermanagement.mapper;

import com.arun.usermanagement.dto.UserManagementSystemDTO;
import com.arun.usermanagement.entity.UserManagementSystem;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {


    UserManagementSystem toEntity(UserManagementSystemDTO userDTO);

    UserManagementSystemDTO toDto(UserManagementSystem user);

    List<UserManagementSystemDTO> toDtoList(List<UserManagementSystem> users);
}
