package com.yaorange.tqt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.tqt.mapper.CourseMapper;
import com.yaorange.tqt.mapper.KnowledgeMapper;
import com.yaorange.tqt.pojo.Bo.KnowledgeBo;
import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.service.KnowledgeService;
import com.yaorange.tqt.utils.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    private KnowledgeMapper knowledgeMapper;
    @Resource
    private CourseMapper courseMapper;
    @Override
    public PageResult<KnowledgeBo> getPage(Integer pageNo, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNo,pageSize);
        Example example = new Example(TeaKnowledge.class);
        if(StringUtils.isNotBlank(keyWord)){
            example.createCriteria().andLike("knowledgeName",keyWord);
        }
        Page<TeaKnowledge>page=(Page<TeaKnowledge>) knowledgeMapper.selectByExample(example);
        PageResult<KnowledgeBo> pageResult = new PageResult<>();
        List<TeaKnowledge> result = page.getResult();
        List<KnowledgeBo> boList = new ArrayList<>();

        for (TeaKnowledge knowledge :result) {
         //   System.out.println(knowledge);
            Long courseId = knowledge.getCourseId();
            TeaCourse teaCourse = courseMapper.selectByPrimaryKey(courseId);
            KnowledgeBo knowledgeBo = new KnowledgeBo();
            knowledgeBo.setCourseName(teaCourse.getName());
            knowledgeBo.setKnowledgeName(knowledge.getKnowledgeName());
            knowledgeBo.setCourseId(knowledge.getCourseId());
            knowledgeBo.setKnowledgeId(knowledge.getKnowledgeId());
            boList.add(knowledgeBo);
        }

        pageResult.setItems(boList);
        pageResult.setTotal(page.getTotal());
        pageResult.setTotalPage(Long.valueOf(page.getPages()));
        return pageResult;
    }

    @Override
    public int addCourse(TeaKnowledge teaKnowledge) {
        String knowledgeName = teaKnowledge.getKnowledgeName();
        Long courseId = teaKnowledge.getCourseId();
        String[] split = knowledgeName.split(",");
        int c=0;
        for(int i=0;i<split.length;i++){
            String name = split[i];
            TeaKnowledge teaKnowledge1 = new TeaKnowledge();
            teaKnowledge1.setCourseId(courseId);
            teaKnowledge1.setKnowledgeName(name);
            int b = knowledgeMapper.insertSelective(teaKnowledge);
            if(b>0){
                c++;
            }
        }
        if(c==split.length) {
            return c;
        }else{
            return 0;
        }
    }
}
