package dao;

import dto.UserDto;

import java.sql.*;

public class UserDao {
    private UserDto userDto;
    private Connection conn;
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String password = "123456";

    public UserDao() {
        userDto = new UserDto();
        try {
            this.conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String id, String password) {
        boolean isSuccess = false;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM user WHERE user_id = ? AND user_password = ?;";
        try {
            pstmt= this.conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                isSuccess = true;
                System.out.println("로그인 성공");
                userDto.setId(rs.getInt("id"));
                userDto.setUserPassword(rs.getString("user_password"));
                userDto.setUserName(rs.getString("user_name"));
                userDto.setUserId(rs.getString("user_id"));
            } else {
                System.out.println("실패");
                isSuccess = false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isSuccess;
    }

    public boolean signUp(String id, String password, String name) {
        boolean isSuccess = false;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user (user_id, user_password, user_name) VALUES (?, ?, ?);";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);

            int rowInserted = pstmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("new user added");
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isSuccess;

    }


    public UserDto getUserDto() {
        return userDto;
    }
}
