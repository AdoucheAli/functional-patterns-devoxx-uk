package victor.clean.lambdas;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// get the list of users to UI


class UserFacade {
	
	private UserRepo userRepo;
	
	public List<UserDto> getAllUsers() {
		return userRepo.findAll().stream().map(this::toDto).collect(toList());
	}

	private UserDto toDto(User user) {
		UserDto dto = new UserDto(user);
//		dto.setUsername(user.getUsername());
//		dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
//		dto.setActive(user.getDeactivationDate() == null);
		return dto;
	}
}










// VVVVVVVVV ==== supporting (dummy) code ==== VVVVVVVVV
interface UserRepo {
	List<User> findAll();
}

@Data
class User {
	private String firstName;
	private String lastName;
	private String username;
	private LocalDate deactivationDate;
}

@Data
class UserDto {
	public UserDto(User user) {
		this.setUsername(user.getUsername());
		this.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
		this.setActive(user.getDeactivationDate() == null);
	}
	private String fullName;
	private String username;
	private boolean active;
}
