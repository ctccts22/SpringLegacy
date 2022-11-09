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


@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);
        request.setAttribute("vo", vo);
        RequestDispatcher rd=request.getRequestDispatcher("member/memberContent.jsp");
        rd.forward(request, response);
    }
}