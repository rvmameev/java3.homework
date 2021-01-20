package java3.lesson2.homework;

import java.sql.SQLException;

public class App
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        AuthService.init("org.sqlite.JDBC");

        AuthService service = new AuthService("jdbc:sqlite:database.db");

        service.initUsers();

        demoRegisterUser(service, "login1", "pass1", "nick1"); // true
        demoRegisterUser(service, "login1", "pass2", "nick2"); // false
        demoRegisterUser(service, "login2", "pass2", "nick1"); // false
        demoRegisterUser(service, "login2", "pass2", "nick2"); // true

        System.out.println();

        demoGetNickname(service, "login1", "pass1"); // nick1
        demoGetNickname(service, "login1", "pass2"); // null
        demoGetNickname(service, "login2", "pass2"); // nick2

        System.out.println();

        demoChangeNickname(service, "nick1", "nick3"); // 'nick1'->'nick3'
        demoChangeNickname(service, "nick3", "nick2"); // Error
        demoChangeNickname(service, "nick3", "nick1"); // 'nick3'->'nick1'
        demoChangeNickname(service, "nick10", "nick11"); // Error
    }

    private static void demoRegisterUser(AuthService service, String login, String password, String nickname) throws SQLException
    {
        System.out.println("User has been registered: " + service.register(login, password, nickname));
    }

    private static void demoGetNickname(AuthService service, String login, String password) throws SQLException
    {
        System.out.println("Nickname: " + service.getNickname(login, password));
    }

    private static void demoChangeNickname(AuthService service, String oldNickname, String newNickname) throws SQLException
    {
        boolean hasChanged = service.changeNickName(oldNickname, newNickname);

        System.out.println("Change nickname: " + (hasChanged ? String.format("'%s'->'%s'", oldNickname, newNickname) : "Error"));
    }
}
