package mvc2.member.action;

import mvc2.member.controller.ActionForward;
import mvc2.member.model.MemberDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ConfirmEmailCodeAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String confirmCode = request.getParameter("confirmCode");
        String code = request.getParameter("code");
        String email = request.getParameter("email");

        String url = null;
        if(code.equals(confirmCode))
        {
            MemberDAO memberDAO = MemberDAO.getInstance();
            List<String> idList = memberDAO.selectIds(email);
            request.setAttribute("idList", idList);
            url = "member/login/showIds.jsp";
        }
        else
        {
            request.setAttribute("msg", "잘못된 인증번호 입니다. 처음부터 다시해주세요");
            url = "main.do?cmd=login";
        }

        return new ActionForward(url, false);
    }
}
