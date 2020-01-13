package mvc2.member.controller;

import mvc2.member.action.*;

public class ActionFactory
{
    private static ActionFactory factory;

    private ActionFactory(){
    }

    public static synchronized ActionFactory getInstance()
    {
        if(factory == null)
        {
            factory = new ActionFactory();
        }
        return factory;
    }

    public Action getAction(String cmd){
        Action action = null;
        switch (cmd)
        {
            case "index":
                action = new IndexAction();
                break;
            case "login":
                action = new LoginAction();
                break;
            case "loginProc":
                action = new LoginProcAction();
                break;
            case "logout":
                action = new LogoutProcAction();
                break;
            default:
                action = new IndexAction();
                break;
        }
        return action;
    }
}
