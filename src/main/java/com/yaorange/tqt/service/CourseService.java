package com.yaorange.tqt.service;

import com.yaorange.tqt.pojo.TeaCourse;
import com.yaorange.tqt.utils.PageResult;

import java.util.List;

public interface CourseService {
    public PageResult<TeaCourse> getPage(Integer pageNo, Integer pageSize, String keyWord) ;

    public int addCourse(TeaCourse teaCourse) ;

    public int updateCourse(TeaCourse teaCourse);


    public int deleteCourseByIds(List<Long> courseIds) ;

    public List<TeaCourse> findAll();
}
