package com.example.controller;

import com.example.domain.PersonDO;
import com.example.mapper.CourseMapper;
import com.example.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author xzy
 *
 */
@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/selectByCourseName")
	public List<Map<String, Object>> selectByCourseName(String courseName) {
		Map<String, Object> map = new HashMap<>();
		map.put("courseName", courseName);
		List<Map<String, Object>> resultList = courseService.selectByCourseName(map);
		return resultList;
	}

	@RequestMapping("/selectMyAttention")
	public List<Map<String, Object>> selectMyAttention(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		List<Map<String, Object>> resultList = courseService.selectMyAttention(map);
		return resultList;
	}
/**
 * 各种课程
 * @param type
 * @return
 */
	@RequestMapping("/selectAll")
	public List<Map<String, Object>> selectAll(String type) {
		if (StringUtils.isEmpty(type)) {
			return null;
		}
		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		switch (type) {
		case "1":
			resultList = courseService.selectAll(map);
			break;
		case "2":
			map.put("hot", "hot");
			resultList = courseService.selectAll(map);
			break;
		case "3":
			map.put("newest", "newest");
			resultList = courseService.selectAll(map);
			break;
		}
		return resultList;
	}

	@RequestMapping("/transaction")
	@Transactional // 需要事务的时候加上
	public Boolean transaction() {
		return true;
	}

}
