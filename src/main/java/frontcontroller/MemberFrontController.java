package frontcontroller;

import controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 클라이언트가 어떤 요청을 했는지 파악하기
        String url = request.getRequestURI();
//        System.out.println(url);

        String ctx = request.getContextPath();
//        System.out.println(ctx);

        // 실제로 요청한 명령이 무엇인지 파악
        String command = url.substring(ctx.length());
        System.out.println(command);
        // 요청에 따른 분기작업

        Controller controller=null;
        String nextPage=null;

        HandlerMapping mapping = new HandlerMapping();
       controller = mapping.getController(command);
       nextPage=controller.requestHandler(request, response);
        //forward or redirect
        if(nextPage!=null) {
            if(nextPage.indexOf("redirect:")!=-1) {
                response.sendRedirect(nextPage.split(":")[1]); //redirect
            } else {
                RequestDispatcher rd=request.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
                rd.forward(request, response);
            }
        }
    }
}