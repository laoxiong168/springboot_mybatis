package com.example.service;

import java.util.List;
import java.util.Map;

public interface CourseService {

	List<Map<String, Object>> selectAll(Map<String, Object> map);

	List<Map<String, Object>> selectByCourseName(Map<String, Object> map);
	
	List<Map<String, Object>> selectMyAttention(Map<String, Object> map);
}
