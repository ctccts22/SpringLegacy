package controller;

import com.glowsoft.spring_test.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDeleteController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx=request.getContextPath();

        int num = Integer.parseInt(request.getParameter("num"));

        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberDelete(num);
        String nextPage=null;
        if (cnt > 0) {
            nextPage="redirect:"+ctx+"/memberList.do";
        } else {
            throw new ServletException("not insert");
        }
        return nextPage;
        //redirect
    }
}
