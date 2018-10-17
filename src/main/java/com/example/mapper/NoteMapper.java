package com.example.mapper;

import com.example.domain.PersonDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xzy
 */
@Mapper
public interface NoteMapper {
    //插入记录数据
    Integer insertNote(Map<String, Object> map);

    List<Map<String, Object>> queryContents();

    Integer selectContent(String id);

    Integer updateContent(Map<String, Object> map);
}
