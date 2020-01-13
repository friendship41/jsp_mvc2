package mvc2.member.action;

import mvc2.member.controller.ActionForward;
import mvc2.member.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberDeleteProcAction implements Action
{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        String formPw = request.getParameter("pw");

        MemberDAO memberDAO = MemberDAO.getInstance();
        String dbPw = memberDAO.selectPw(id);

        String url = "";

        session.setAttribute("id", null);
        if(formPw.equals(dbPw))
        {
            memberDAO.deleteMember(id);
            request.setAttribute("msg", "정상적으로 탈퇴되었습니다. 안녕히가세요...");
            url = "main.do?cmd=login";
        }
        else
        {
            request.setAttribute("msg", "잘못된 비밀번호입니다. 다시 로그인 해주세요.");
            url = "main.do?cmd=login";
        }

        return new ActionForward(url, false);
    }
}
