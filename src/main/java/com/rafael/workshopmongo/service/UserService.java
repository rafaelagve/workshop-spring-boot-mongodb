package com.rafael.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.workshopmongo.domain.User;
import com.rafael.workshopmongo.dto.UserDTO;
import com.rafael.workshopmongo.repository.UserRepository;
import com.rafael.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll()
	{
		return repo.findAll();
	}
	
	public User findById(String id)
	{
		Optional <User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));	
	}
	
	public User insert(User obj)
	{
		return repo.insert(obj);
	}
	
	public void delete(String id)
	{
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto)
	{
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	


}
