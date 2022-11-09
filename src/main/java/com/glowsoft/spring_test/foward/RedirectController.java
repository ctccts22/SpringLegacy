package com.glowsoft.spring_test.foward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        int su=100;
        String data="apple";
//        View page(result.jsp)로 data를 전달하여 View page에서 출력
//        Controller에서 View로 페이지 전한하는 방법
//        1. redirect
//        2. forward
//        request.setAttribute("data", data);
        response.sendRedirect("view/result.jsp?data="+data);

    }
}