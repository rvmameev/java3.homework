package java3.lesson2.homework;

import java.sql.*;

public class AuthService
{
    private final String connectionString;

    public AuthService(String connectionString)
    {
        this.connectionString = connectionString;
    }

    public static void init(String driver) throws ClassNotFoundException
    {
        Class.forName(driver);
    }

    public void initUsers() throws SQLException
    {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement())
        {
            statement.execute("DELETE FROM users; VACUUM;");
        }
    }

    public boolean register(String login, String password, String nickname) throws SQLException
    {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement())
        {
            try
            {
                String sql = String.format("INSERT INTO users (login, password, nickname) VALUES ('%s', '%s', '%s');",
                    login, password, nickname);

                statement.executeUpdate(sql);

                return true;

            } catch (SQLException e)
            {
                return false;
            }
        }
    }

    public String getNickname(String login, String password) throws SQLException
    {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement())
        {
            try
            {
                String sql = String.format("SELECT nickname FROM users WHERE login ='%s' AND password = '%s';",
                    login, password);

                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next())
                {
                    return resultSet.getString("nickname");
                }
            } catch (SQLException e)
            {
            }

            return null;
        }
    }

    public boolean changeNickName(String oldNickname, String newNickname) throws SQLException
    {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement())
        {
            try
            {
                String sql = String.format("SELECT nickname FROM users WHERE nickname ='%s'", oldNickname);

                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next())
                {
                    sql = String.format("UPDATE users SET nickname = '%s' WHERE nickname = '%s'",
                        newNickname, oldNickname);

                    statement.execute(sql);

                    return true;
                }
                else
                {
                    return false;
                }
            } catch (SQLException e)
            {
                return false;
            }
        }
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(connectionString);
    }
}
