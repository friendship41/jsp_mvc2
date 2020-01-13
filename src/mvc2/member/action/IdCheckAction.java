package mvc2.member.action;

import mvc2.member.controller.ActionForward;
import mvc2.member.model.MemberDAO;
import mvc2.member.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdCheckAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String formId = request.getParameter("id");

        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberVO memberVO = memberDAO.selectSingle(formId);
        if(memberVO == null || memberVO.getId() == null || memberVO.getId().equals(""))
        {
            request.setAttribute("msg", "사용가능한 아이디 입니다.");
        }
        else
        {
            request.setAttribute("msg", "중복된 아이디입니다.");
        }

        return new ActionForward("member/join/idCheck.jsp",false);
    }
}
