package com.leokenzley.templatesecapi.application.mapper;

import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.model.UserRequest;
import com.leokenzley.templatesecapi.model.UserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-03T22:40:01-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class UserApplicationMapperImpl implements UserApplicationMapper {

    @Override
    public UserDomain toDomain(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserDomain userDomain = new UserDomain();

        if ( request.getId() != null ) {
            userDomain.setId( request.getId().longValue() );
        }
        userDomain.setName( request.getName() );
        userDomain.setEmail( request.getEmail() );
        userDomain.setCpf( request.getCpf() );

        return userDomain;
    }

    @Override
    public UserResponse toResponse(UserDomain domain) {
        if ( domain == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        if ( domain.getId() != null ) {
            userResponse.setId( domain.getId().intValue() );
        }
        userResponse.setName( domain.getName() );
        userResponse.setEmail( domain.getEmail() );
        userResponse.setCpf( domain.getCpf() );

        return userResponse;
    }
}
