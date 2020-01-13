package mvc2.member.controller;

import mvc2.member.action.Action;
import mvc2.member.action.IndexAction;
import mvc2.member.action.LoginAction;

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
            default:
                action = new IndexAction();
                break;
        }
        return action;
    }
}
