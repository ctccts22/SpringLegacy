package com.glowsoft.spring_test.controller;

import com.glowsoft.spring_test.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num=Integer.parseInt(request.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        int cnt=dao.memberDelete(num);
        if(cnt>0) {
            response.sendRedirect("/memberList.do");
        }else {
            throw new ServletException("not insert");
        }
    }
}