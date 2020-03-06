package com.yaorange.tqt.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tea_course")
public class TeaCourse {
  @Id
  private Long courseId;
  private String name;
  private Long state;


  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

}
