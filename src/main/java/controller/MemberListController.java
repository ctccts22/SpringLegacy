package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.memberList();
        request.setAttribute("list", list);
        // member/memberList.jsp
        // 다음페이지는 //forward
//      return "/WEB-INF/member/memberList.jsp";
        return "memberList";
    }
}
