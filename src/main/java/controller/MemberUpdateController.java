package controller;

import com.glowsoft.spring_test.model.MemberDAO;
import com.glowsoft.spring_test.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ctx=request.getContextPath();
        int num = Integer.parseInt(request.getParameter("num"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setNum(num);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberUpdate(vo);
        String nextPage=null;
        if (cnt > 0) {
         nextPage="redirect:"+ctx+"/memberList.do";
        } else {
            throw new ServletException("not update");
        }
        return nextPage;
    }
}
