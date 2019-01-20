package com.eomcs.lms.handelr;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int OLDLENGTH = 10;
  Member[] members;
  int memberIdx = 0;
  
  public MemberList() {
   members = new Member[OLDLENGTH];
  }
  public MemberList(int NEWLENGTH) {
    members = new Member[NEWLENGTH];
  }
  
  public Member[] toArray() {
    return Arrays.copyOf(members, memberIdx);
  }
  
  public void add(Member member) {
    if (OLDLENGTH > memberIdx) {
      int oldL = OLDLENGTH;
      int newL = oldL + (oldL >> 1);
      members = Arrays.copyOf(members, newL);
    }
    members[memberIdx++] = member;
  }
}
