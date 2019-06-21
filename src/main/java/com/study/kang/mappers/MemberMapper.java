package com.study.kang.mappers;

import com.study.kang.vo.UserVO;

import java.util.HashMap;
import java.util.List;

public interface MemberMapper {
    void memberJoin(UserVO userVO) throws Exception;
    UserVO getUser(String id);
    List<HashMap<String, String>> getRoles(String id);
    void authJoin(UserVO userVO);
}
