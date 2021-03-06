package com.study.kang.mappers;

import com.study.kang.vo.UserVO;

import java.util.HashMap;
import java.util.List;

public interface MemberMapper {
    void insertMember(UserVO userVO) throws Exception;
    UserVO getUser(String id);
    List<HashMap<String, String>> getRoles(String id);
    void insertAuth(UserVO userVO);
}
