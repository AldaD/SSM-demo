package com.jinhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jinhu.entity.Author;
import com.jinhu.mapper.AuthorMapper;

@Service
public class AuthorService {
	@Autowired
	private AuthorMapper authorMapper;
	
	public Author findById(int id){
		return authorMapper.findById(id);
	}
	
}
