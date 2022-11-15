package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLogoutController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //세션을 가져와서 세센을 제거
        //세션을 제거하는 방법
        //1. 강제로
        String ctx=request.getContextPath();
        request.getSession().invalidate();
        //2. 브라우저를 종료하는것(JSESSIONID 브라우저쿠키에 저장)
        //3. 세션이 종료될때까지 기다리는것(세션타임아웃 : 30분=1800초)
        return "redirect:"+ctx+"/memberList.do";
    }
}
