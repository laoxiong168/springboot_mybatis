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
public interface NoteMapper {
//插入记录数据
Integer insertNote(Map map);
}