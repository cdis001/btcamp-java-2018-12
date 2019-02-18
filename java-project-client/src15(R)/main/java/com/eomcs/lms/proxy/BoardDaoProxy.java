package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoProxy implements BoardDao {
  
  String serverAddr;
  int port;
  String rootPath;
  
  public BoardDaoProxy(String serverAgent, int port, String rootPath) {
    this.serverAddr = serverAgent;
    this.port = port;
    this.rootPath = rootPath;
  }
  
  @SuppressWarnings("unchecked")
  public List<Board> findAll() {
    //interface(규칙)에 예외가 표기되어 있지 않기 때문에 클래스에서 예외를 던질 수 없음
    //다만, 예외가 있음을 호출자에 알리기 위해서 예외를 던져줘야 하는데,
    //이때 예외를 몰래 던지기 위해서 runtimeexception을 던져줌
    //규칙을 어기지 않으면서, 예외를 던질 수 있는 방법
    //호출자에게 굳이 알려줄 필요가 없을 경우, throws runtimeexception 을 붙여줘도 상관 없음
    try (Socket socket = new Socket(this.serverAddr, this.port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

      out.writeUTF(rootPath + "/list");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못하였습니다.");

      String status = in.readUTF();
      
      if (!status.equals("OK")) 
        throw new Exception("서버에서 목록 가져오기 실패");
      
      return (List<Board>) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Board board) {
    try (Socket socket = new Socket(serverAddr, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      
      out.writeUTF(rootPath + "/add");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeObject(board);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버의 데이터 저장 실패!");
      }
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Board findByNo(int no) {
    try (Socket socket = new Socket(serverAddr, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF(rootPath + "/detail");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
      return (Board) in.readObject();
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Board board) {
    try (Socket socket = new Socket(serverAddr, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF(rootPath + "/update");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

      out.writeObject(board);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) 
        throw new Exception("서버에서 게시글 변경하기 실패!");
      return 1;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try (Socket socket = new Socket(serverAddr, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      out.writeUTF(rootPath + "/delete");
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못 하였습니다.");
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();
      if (!status.equals("OK")) {
        throw new Exception("서버에서 게시글 가져오기 실패");
      }
      return 1;
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

} // class
