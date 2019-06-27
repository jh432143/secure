package com.study.api.controller;

import com.study.api.vo.SampleVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/hello/text")
    public String text () {
        return "Hello Sample Text";
    }

    @RequestMapping("/hello/json")
    public SampleVO json () {
        SampleVO sampleVO = new SampleVO();
        sampleVO.setNo(1);
        sampleVO.setFirstName("강");
        sampleVO.setLastName("정훈");

        return sampleVO;
    }

    @RequestMapping("/hello/json-list")
    public List<SampleVO> jsonList () {
        List<SampleVO> list = new ArrayList<SampleVO>();

        for (int i=0; i<5; i++) {
            SampleVO sampleVO = new SampleVO();
            sampleVO.setNo(i);
            sampleVO.setFirstName("강");
            sampleVO.setLastName("정훈");

            list.add(sampleVO);
        }

        return list;
    }

    @RequestMapping("/hello/json-map")
    public List<Map<String, String>> jsonMap () {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        for (int i=0; i<5; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("no", String.valueOf(i));
            map.put("firstName", "강");
            map.put("lastName", "정훈");

            list.add(map);
        }

        return list;
    }
}
