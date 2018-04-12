package com.jinhu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.jinhu.entity.Author;

public interface AuthorMapper {
	@Select("select id,username,password,email,address,phone from author where id=#{id}")
	public Author findById(@Param("id") int id);
}
