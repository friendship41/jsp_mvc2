package mvc2.member.action;

import mvc2.member.controller.ActionForward;
import mvc2.member.model.MemberDAO;
import mvc2.member.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberModAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        String url="";

        if(id != null || !id.equals(""))
        {
            MemberDAO memberDAO = MemberDAO.getInstance();
            MemberVO memberVO = memberDAO.selectSingle(id);

            request.setAttribute("memberVO", memberVO);
            url = "member/mod/memberMod.jsp";
        }
        else
        {
            request.setAttribute("msg", "로그인을 해주세요.");
            url = "main.do?cmd=login";
        }

        return new ActionForward(url, false);
    }
}
