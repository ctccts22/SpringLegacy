package com.glowsoft.spring_test.controller;

import com.glowsoft.spring_test.model.MemberDAO;
import com.glowsoft.spring_test.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
//        1. 파라메터 수집(VO)
         String id=request.getParameter("id");
         String pass=request.getParameter("pass");
         String name=request.getParameter("name");
         int age=Integer.parseInt(request.getParameter("age"));
         String email=request.getParameter("email");
         String phone=request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPass(pass);
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

//        System.out.println(vo);
//        Model과 연동부분
        MemberDAO dao=new MemberDAO();
        int cnt=dao.memberInsert(vo);
//        PrintWriter out=response.getWriter();
        if(cnt>0) {
            //가입성공
            //out.println("insert success");
            response.sendRedirect("/memberList.do");
        } else {
            //가입실패 >> 예외객체를 만들어서 와스에게 던지자
            throw new ServletException("not insert");
        }
    }
}