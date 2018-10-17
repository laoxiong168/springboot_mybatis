package com.example.service;

import java.util.List;
import java.util.Map;

public interface NoteService {

    Integer insertNote(Map<String, Object> map);

    List<Map<String, Object>> queryContents();

    Integer selectContent(String id);

    Integer updateContent(Map<String, Object> map);


}
