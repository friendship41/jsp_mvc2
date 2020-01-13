package mvc2.member.action;

import mvc2.member.controller.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return new ActionForward("index.jsp", false);
    }
}
