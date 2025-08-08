package egovframework.itman.user.model.repository;

import egovframework.itman.user.dto.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerifyRepository extends CrudRepository<UserDto.Request, String> {}
