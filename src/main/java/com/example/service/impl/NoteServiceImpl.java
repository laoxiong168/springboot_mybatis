package com.example.service.impl;

import com.example.mapper.NoteMapper;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteMapper noteMapper;
    @Override
    public Integer insertNote(Map<String,Object> map) {
        return noteMapper.insertNote(map);
    }
    public  List<Map<String, Object>> queryContents(){
        return noteMapper.queryContents();
    }
}
