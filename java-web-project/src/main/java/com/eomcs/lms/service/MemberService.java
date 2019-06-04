package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {
  List<Member> list(String searchWord, int pageNo, int pageSize);

  int add(Member board);

  Member get(int no);

  Member get(String email, String password);

  Member get(String email);

  int update(Member board);

  int delete(int no);

  int size();
}
