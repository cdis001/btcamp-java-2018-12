package com.eomcs.lms.handelr;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int OLDLENGTH = 10;
  Lesson[] lessons;
  int lessonIdx = 0;
  
  public LessonList() {
    lessons = new Lesson[OLDLENGTH];
  }
  public LessonList(int newLength) {
    if (OLDLENGTH < newLength) {
      lessons = new Lesson[OLDLENGTH];
    } else {
      lessons = new Lesson[newLength];
    }
  }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(lessons, lessonIdx);
  }
  
  public void add(Lesson lesson) {
    if (lessonIdx > OLDLENGTH) {
      int oldL = lessons.length;
      int newL = oldL + (oldL >> 1);
      lessons = Arrays.copyOf(lessons, newL);
  }
    lessons[lessonIdx++] = lesson;
  }
}
