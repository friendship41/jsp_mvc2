package mvc2.member.controller;

import mvc2.member.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ControlServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException
    {
        requset.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String cmd = requset.getParameter("cmd");
        if(cmd != null)
        {
            ActionFactory factory = ActionFactory.getInstance();
            Action action = factory.getAction(cmd);
            ActionForward af = action.execute(requset, response);
            if(af.isRedirect())
            {
                response.sendRedirect(af.getUrl());
            }
            else
            {
                RequestDispatcher disp = requset.getRequestDispatcher(af.getUrl());
                disp.forward(requset, response);
            }
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Error</title></head>");
            out.println("<body>");
            out.println("<h4>올바른 요청이 아닙니다!</h4>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
