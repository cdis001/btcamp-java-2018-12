package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDaoProxy {

  String serverAddr;
  int port;
  String rootPath;

  public MemberDaoProxy(String serverAgent, int port, String rootPath) {
    this.serverAddr = serverAgent;
    this.port = port;
    this.rootPath = rootPath;
  }

  @SuppressWarnings("unchecked")
  public List<Member> list() {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF("/member/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 목록 가져오기 실패");

      }
      return (List<Member>) in.readObject();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void add(Member member) {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF("/member/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeObject(member);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버의 데이터 저장 실패!");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Member get(int no) {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF("/member/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
      return (Member) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void update(Member member) {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF("/member/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(member);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 변경하기 실패!");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void delete(int no) {
    try(Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF("/member/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

} // class
