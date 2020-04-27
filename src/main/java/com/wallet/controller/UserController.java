package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(
				@Valid @RequestBody UserDTO dto,
				BindingResult result
	) 
	{
		Response<UserDTO> response = new Response<UserDTO>();
		
		
		User userSave = userService.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(userSave));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	private User convertDtoToEntity(UserDTO dto) {
		User u = new User();
		u.setEmail(dto.getEmail());
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		
		return u;
	}
	
	private UserDTO convertEntityToDto(User u) {
		UserDTO dto = new UserDTO();
		dto.setEmail(dto.getEmail());
		dto.setName(dto.getName());
		dto.setPassword(dto.getPassword());
		
		return dto;		
	}
}
