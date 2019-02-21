package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardService {
  List<Board> boards;
  ObjectInputStream in;
  ObjectOutputStream out;
  String filepath;
  
  public void init(ObjectInputStream in, ObjectOutputStream out) { 
    //(before: 생성자 클래스)
    //loaddata()에 Exception을 던질 경우,
    // 생성자에 Exception을 던저야 하기 때문에, 
    // 클래스 생성 및 사용시 try-catch 또는 throws 명령어를 쓰지 않을 경우 경고가 발생하므로,
    // 개발시 어떤 것 때문에 경고가 뜨는지 확인하기 때문에 '강하게' 경고함 ;클래스를 사용한 클래스에서 처리해야 함
    // 만약, loaddata()에 RuntimeException(처리하지 않아도 괜찮음)을 던졌을 경우,
    // 클래스 사용시 throws를 사용하지 않기 때문에 '느슨하게' 경고함 ;현재 클레스에서 처리 가능
    // 어떤 경고를 사용할지는 개발자가 판단!
    this.in = in;
    this.out = out;
  }
  
  @SuppressWarnings("unchecked")
  public void loadData(String filepath) {
    this.filepath = filepath;
    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
        new FileInputStream(this.filepath)))) {
      
      boards = (List<Board>) in.readObject();
      
    } catch (Exception e) {
      boards = new ArrayList<Board>();
      throw new RuntimeException("게시글 파일 로딩중 오류 발생: " + e);
    } 
  }

  public void saveData() throws Exception {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.filepath)))) {
      
      out.writeObject(boards);
      
    } catch (Exception e) {
      throw new Exception("게시글 파일 저장중 오류 발생: " + e);
    } 
  }
  
  public void execute(String request) throws Exception {

    switch (request) {
      case "/board/add": 
        add();
        break;
      case "/board/list": 
        list();
        break;
      case "/board/detail": 
        detail();
        break;
      case "/board/delete": 
        delete();
        break;
      case "/board/update": 
        update();
        break;
      default:
        out.writeUTF("FAIL");
        break;
    }
    out.flush();

  }

  private void add() throws Exception {
    out.writeUTF("OK");
    out.flush();
    boards.add((Board)in.readObject());
    out.writeUTF("OK");
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeUnshared(boards);
  }

  private void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();
    for(Board m : boards) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    }
    out.writeUTF("FAIL");
  }

  private void delete() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();
    int index = 0;
    for(Board m : boards) {
      if(m.getNo() == no) {
        boards.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }


  private void update() throws Exception {
    out.writeUTF("OK");
    out.flush();
    Board board = (Board)in.readObject();
    int index = 0;
    for(Board b : boards) {
      if(b.getNo() == board.getNo()) {
        boards.set(index, board);
        out.writeUTF("OK");
        return;
      }
      index++;
    }
    out.writeUTF("FAIL");
  }

}

