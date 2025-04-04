package com.leokenzley.templatesecapi.dataprovider.database.repository.mapper;

import com.leokenzley.templatesecapi.core.domain.UserDomain;
import com.leokenzley.templatesecapi.dataprovider.database.entity.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting between UserEntity and UserDomain.
 * This interface uses MapStruct to generate the implementation at compile time.
 */
@Mapper(
  componentModel = MappingConstants.ComponentModel.SPRING,
  unmappedSourcePolicy =  ReportingPolicy.IGNORE,
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

  /**
   * Converts a UserDomain object to a UserEntity object.
   *
   * @param userDomain the UserDomain object to convert
   * @return the converted UserEntity object
   */
  @Mappings({
    @Mapping(target = "name", source = "userDomain.name"),
    @Mapping(target = "email", source = "userDomain.email"),
    @Mapping(target = "cpf", source = "userDomain.cpf")
  })
  UserEntity toEntity(UserDomain userDomain);

  /**
   * Converts a UserEntity object to a UserDomain object.
   *
   * @param userEntity the UserEntity object to convert
   * @return the converted UserDomain object
   */
  @Mappings({
    @Mapping(target = "id", source = "userEntity.id"),
    @Mapping(target = "name", source = "userEntity.name"),
    @Mapping(target = "email", source = "userEntity.email"),
    @Mapping(target = "cpf", source = "userEntity.cpf")})
  UserDomain toDomain(UserEntity userEntity);
}
