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

    @Override
    public Integer selectContent(String id) {
        return noteMapper.selectContent(id);
    }

    @Override
    public Integer updateContent(Map<String, Object> map) {
        return noteMapper.updateContent(map);
    }

    @Override
    public Integer deleteNote(String id) {
        return noteMapper.deleteNote(id);
    }
}
