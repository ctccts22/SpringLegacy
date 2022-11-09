package com.glowsoft.spring_test.model;
//JDBC -> myBatis // JPA

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

//    데이터베이스 연결객체(Connection)
    public void getConnect() {
//        데이터베이스접속URL
        String URL="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="admin12345";
//        MySQL Driver Loading

        try {
//            동적로딩(실행시점에서 객체를 생성하는 방법)
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
//    회원저장 동작
    public int memberInsert(MemberVO vo) {                                       //parameter
        String SQL="insert into member(id, pass, name, age, email, phone) values(?,?,?,?,?,?)";
        getConnect();
//        SQL문장을 전송하는 객체
        int cnt=-1;
        try {
            ps=conn.prepareStatement(SQL);  //미리 컴파일 시킨다 >> 속도가 빠름
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPass());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());
            // 1,0
            cnt=ps.executeUpdate(); //전송(실행)

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return cnt;
    }
    // 회원(VO)전체 리스트(Array List) 가져오기
    public ArrayList<MemberVO> memberList() {
        String SQL="select * from member";
        getConnect();
        ArrayList<MemberVO> list = new ArrayList<MemberVO>();
        try {
            ps= conn.prepareStatement(SQL);
            rs=ps.executeQuery();
            while(rs.next()) {
                int num=rs.getInt("num");
                String id=rs.getString("id");
                String pass=rs.getString("pass");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
               // 묶고 >> 담고
               MemberVO vo=new MemberVO(num, id, pass, name, age, email, phone);
               list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                dbClose();
        }
        return list;
    }//memberList
    public int memberDelete(int num) {
        String SQL="delete from member where num=?";
        getConnect();
        int cnt=-1;
        try {
            ps=conn.prepareStatement(SQL);
            ps.setInt(1, num);
            cnt=ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    public MemberVO memberContent(int num) {
        String SQL = "select * from member where num=?";
        getConnect();
        MemberVO vo = null;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                //회원 한명의 정보를 가져와서 >> 묶고(VO)
                num=rs.getInt("num");
                String id=rs.getString("id");
                String pass=rs.getString("pass");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                vo=new MemberVO(num, id, pass, name, age, email, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return vo;
    }
    public int memberUpdate(MemberVO vo) {
        String SQL="update member set age=?, email=?, phone=? where num=?";
        getConnect();
        int cnt=-1;
        try{
            ps=conn.prepareStatement(SQL);
            ps.setInt(1, vo.getAge());
            ps.setString(2, vo.getEmail());
            ps.setString(3, vo.getPhone());
            ps.setInt(4, vo.getNum());
            
            cnt=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }
    // 데이터베이스 연결 끊기
    public void dbClose() {
        try {
            if(rs!=null) rs.close();
            if(rs!=null) ps.close();
            if(rs!=null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

