package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.CourseMapper;
import com.example.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Override
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return courseMapper.selectAll(map);
	}

	@Override
	public List<Map<String, Object>> selectByCourseName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return courseMapper.selectByCourseName(map);
	}

	@Override
	public List<Map<String, Object>> selectMyAttention(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return courseMapper.selectMyAttention(map);
	}

}
