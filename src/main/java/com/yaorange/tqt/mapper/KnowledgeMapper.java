package com.yaorange.tqt.mapper;


import com.yaorange.tqt.pojo.TeaKnowledge;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface KnowledgeMapper extends Mapper<TeaKnowledge>, DeleteByIdListMapper<TeaKnowledge,Long> {
}
