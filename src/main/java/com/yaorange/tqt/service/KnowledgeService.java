package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.Bo.KnowledgeBo;
import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.utils.PageResult;

public interface KnowledgeService {
    PageResult<KnowledgeBo> getPage(Integer pageNo, Integer pageSize, String keyWord);

    int addCourse(TeaKnowledge teaKnowledge);
}
