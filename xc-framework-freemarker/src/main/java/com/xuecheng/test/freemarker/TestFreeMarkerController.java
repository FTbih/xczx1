package com.xuecheng.test.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/freemarker")
public class TestFreeMarkerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/banner")
    public String banner(Map<String, Object> map){
        String dataUrl = "http://localhost:31001/cms/config/getModel/5a791725dd573c3574ee333f";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        return "index_banner";
    }

    @RequestMapping("/banner1")
    public String banner1(Map<String, Object> map){
        System.out.println(1);
        return "index_banner";
    }

    @RequestMapping("/course")
    public String course(Map<String, Object> map){
        String dataUrl = "http://localhost:31200/course/courseView/4028e581617f945f01617f9dabc40000";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        System.out.println(1);
        return "course";
    }

}
