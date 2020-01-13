package mvc2.member.action;

import mvc2.member.controller.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action
{
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
