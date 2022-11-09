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


@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //클라이언트에 요청을 받는 작업 .. 파라메터(VO) 수집
        int num=Integer.parseInt(request.getParameter("num"));
        int age= Integer.parseInt(request.getParameter("age"));
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");

        MemberVO vo=new MemberVO();
        vo.setNum(num);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO dao=new MemberDAO();
        int cnt=dao.memberUpdate(vo);
        if(cnt>0) {
            response.sendRedirect("/memberList.do");
        } else {
            throw new ServletException("not update");
        }
    }
}