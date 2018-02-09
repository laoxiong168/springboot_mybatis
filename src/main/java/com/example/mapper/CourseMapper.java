package com.example.mapper;

import com.example.domain.PersonDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author xzy
 *
 */
@Mapper
public interface CourseMapper {

	Map<String, Object> selectPersonById(Integer id);

	List<Map<String, Object>> selectAll(Map<String, Object> map);

	List<Map<String, Object>> selectByCourseName(Map<String, Object> map);
	
	List<Map<String, Object>> selectMyAttention(Map<String, Object> map);
	
	
//	List<Map<String, Object>> selectByCourseName(String courseName);

	void insert(PersonDO personDO);

	Long update(PersonDO personDO);

	Long delete(Long id);
}
