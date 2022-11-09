package com.glowsoft.spring_test.controller;

import com.glowsoft.spring_test.model.MemberDAO;
import com.glowsoft.spring_test.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();

//        객체바인딩
        request.setAttribute("list", list);
//        포워딩기법
        RequestDispatcher rd=request.getRequestDispatcher("member/memberList.jsp");
        rd.forward(request, response);
    }
}