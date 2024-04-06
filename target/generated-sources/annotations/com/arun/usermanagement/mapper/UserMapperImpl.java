package com.arun.usermanagement.mapper;

import com.arun.usermanagement.dto.UserManagementSystemDTO;
import com.arun.usermanagement.entity.UserManagementSystem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-06T12:24:32+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (OpenLogic)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserManagementSystem toEntity(UserManagementSystemDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserManagementSystem userManagementSystem = new UserManagementSystem();

        userManagementSystem.setId( userDTO.getId() );
        userManagementSystem.setUsername( userDTO.getUsername() );
        userManagementSystem.setFirstName( userDTO.getFirstName() );
        userManagementSystem.setLastName( userDTO.getLastName() );
        userManagementSystem.setEmail( userDTO.getEmail() );
        userManagementSystem.setPhone( userDTO.getPhone() );
        userManagementSystem.setCity( userDTO.getCity() );
        userManagementSystem.setState( userDTO.getState() );
        userManagementSystem.setCountry( userDTO.getCountry() );
        userManagementSystem.setZip( userDTO.getZip() );
        userManagementSystem.setGender( userDTO.getGender() );
        userManagementSystem.setBirthday( userDTO.getBirthday() );

        return userManagementSystem;
    }

    @Override
    public UserManagementSystemDTO toDto(UserManagementSystem user) {
        if ( user == null ) {
            return null;
        }

        UserManagementSystemDTO userManagementSystemDTO = new UserManagementSystemDTO();

        userManagementSystemDTO.setId( user.getId() );
        userManagementSystemDTO.setUsername( user.getUsername() );
        userManagementSystemDTO.setFirstName( user.getFirstName() );
        userManagementSystemDTO.setLastName( user.getLastName() );
        userManagementSystemDTO.setEmail( user.getEmail() );
        userManagementSystemDTO.setPhone( user.getPhone() );
        userManagementSystemDTO.setCity( user.getCity() );
        userManagementSystemDTO.setState( user.getState() );
        userManagementSystemDTO.setCountry( user.getCountry() );
        userManagementSystemDTO.setZip( user.getZip() );
        userManagementSystemDTO.setGender( user.getGender() );
        userManagementSystemDTO.setBirthday( user.getBirthday() );

        return userManagementSystemDTO;
    }

    @Override
    public List<UserManagementSystemDTO> toDtoList(List<UserManagementSystem> users) {
        if ( users == null ) {
            return null;
        }

        List<UserManagementSystemDTO> list = new ArrayList<UserManagementSystemDTO>( users.size() );
        for ( UserManagementSystem userManagementSystem : users ) {
            list.add( toDto( userManagementSystem ) );
        }

        return list;
    }
}
