package dao;

import dto.MovieDto;

import java.sql.*;

public class MovieDao {
    private MovieDto movieDto;
    private Connection conn;
    String url = "jdbc:mysql://localhost:3306/project";
    String user = "root";
    String password = "123456";

    public MovieDao() {
        movieDto = new MovieDto();
        try {
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovieDto search(String movieTitle) {
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM movie WHERE movie_title = ?;";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, movieTitle);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                movieDto.setMovieTitle(rs.getString("movie_title"));
                movieDto.setDirectorName(rs.getString("director_name"));
                movieDto.setOpenDate(rs.getDate("open_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movieDto;
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }
}
