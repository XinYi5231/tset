package com.yaorange.tqt.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tea_knowledge")
public class TeaKnowledge {
  @Id
  private Long knowledgeId;
  private String knowledgeName;
  private Long courseId;



  public Long getKnowledgeId() {
    return knowledgeId;
  }

  public void setKnowledgeId(Long knowledgeId) {
    this.knowledgeId = knowledgeId;
  }


  public String getKnowledgeName() {
    return knowledgeName;
  }

  public void setKnowledgeName(String knowledgeName) {
    this.knowledgeName = knowledgeName;
  }


  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }


  @Override
  public String toString() {
    return "TeaKnowledge{" +
            "knowledgeId=" + knowledgeId +
            ", knowledgeName='" + knowledgeName + '\'' +
            ", courseId=" + courseId +
            '}';
  }
}
