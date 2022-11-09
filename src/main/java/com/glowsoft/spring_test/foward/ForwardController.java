package com.glowsoft.spring_test.foward;

import com.glowsoft.spring_test.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name="park";
        int age=45;
        String email="aaa@empal.com";

        MemberVO vo = new MemberVO();
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
//        forward.jsp
//        객체바인딩
        request.setAttribute("vo", vo);
//        forward
        RequestDispatcher rd=request.getRequestDispatcher("view/forward.jsp");
        rd.forward(request, response);
    }

}