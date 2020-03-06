package com.yaorange.tqt.controller;


import com.yaorange.tqt.pojo.Bo.KnowledgeBo;
import com.yaorange.tqt.pojo.TeaKnowledge;
import com.yaorange.tqt.service.KnowledgeService;
import com.yaorange.tqt.utils.PageResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/knowledgePoint")
public class KnowledgeController {
    @Resource
    private KnowledgeService knowledgeService;

    @GetMapping
    public ResponseEntity<PageResult<KnowledgeBo>> getPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "keyWord",required = false) String keyWord
            //,@RequestParam(value = "access_token",required = false)String access_token
            ){
        PageResult<KnowledgeBo> pageResult=knowledgeService.getPage(pageNo,pageSize,keyWord);
        return ResponseEntity.ok(pageResult);
    }
    @PostMapping
    public void addCourse(@RequestBody TeaKnowledge teaKnowledge){
        int n= knowledgeService.addCourse(teaKnowledge);
    }
}
