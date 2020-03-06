package com.yaorange.tqt.mapper;

import com.yaorange.tqt.pojo.TeaCourse;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

public interface CourseMapper extends Mapper<TeaCourse>, DeleteByIdListMapper<TeaCourse,Long> {
}
