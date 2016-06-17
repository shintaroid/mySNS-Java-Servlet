package com.mySNS.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mySNS.dto.UserDto;
import com.mySNS.dto.UserFollowDto;

public class UserDao {

  private static Connection conn;

  UserDao(){}

    /**
     * 新規ユーザ登録を行うメソッド
     */
  public static void addUser(UserDto dto, InputStream input) throws SQLException{
    conn = ConnectionDao.getConnection();
    try{
      String sql = "INSERT INTO user VALUES(null,?,?,md5(?),?,null,0,0,0)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, dto.getUser_name());
      stmt.setString(2, dto.getEmail());
      stmt.setString(3, dto.getPassword());
      stmt.setBlob(4, input);
      stmt.executeUpdate();
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
    //delete a user by setting the existence_type equals 1.
  public static void deleteUser(int userId) throws SQLException {
    try {
      PreparedStatement stmt = conn.prepareStatement("UPDATE user SET existence_type=1 WHERE user_id=?");
      stmt.setInt(1, userId);
      stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
  // update a user
  public static void updateUser(UserDto user, InputStream input) throws SQLException {
    try {
      PreparedStatement stmt = conn.prepareStatement("UPDATE user SET user_name=?, passworde=?, ? where user_id=?");
      stmt.setString(1, user.getUser_name());
      stmt.setString(2, user.getPassword());
      stmt.setBlob(3, input);
      stmt.setInt(4, user.getUser_id());
      stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  // get a user by his/her email and password, used for login
  public static UserDto getUser(String email, String password) throws SQLException {
    Connection conn = ConnectionDao.getConnection();
    UserDto user = null;
    try{
      String sql = "SELECT * FROM user WHERE email=?"; //AND password=md5(?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, email);
      //stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();

      if(rs.next()){
        user = new UserDto();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        user.setFollow_count(rs.getInt("follow"));
        user.setFollower_count(rs.getInt("follower"));
        user.setExistence_type(rs.getInt("existence_type"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  // get a user by his/her id
  public UserDto getUser(int userId) throws SQLException {
    UserDto user = new UserDto();
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE user_id=?");
      preparedStatement.setInt(1, userId);
      ResultSet rs = preparedStatement.executeQuery();

      if (rs.next()) {
          user.setUser_id(rs.getInt("user_id"));
          user.setUser_name(rs.getString("user_name"));
          user.setEmail(rs.getString("email"));
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
  }

    /**
     * ユーザ新規登録情報取得を行うメソッド
     */
    public static UserDto userSelect() throws SQLException{
        String sql = "select us.user_id,us.user_name "
                +"from user as us "
                +"where us.user_id = (select last_insert_id());";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        UserDto returndto = null;
        while(rs.next()){
            returndto = new UserDto();
            returndto.setUser_id(rs.getInt("user_id"));
            returndto.setUser_name(rs.getString("user_name"));
        }
        return returndto;
    }
    /**
     * ユーザアイコンupdate
     * @param dto
     * @param con
     * @return
     * @throws SQLException
     */
    public static boolean userImgUpdate(UserDto dto) throws SQLException{
        String sql = "update user as us "
                +"set us.icon_url = ? "
                +"where us.user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dto.getIcon_url());
        stmt.setInt(2, dto.getUser_id());
        stmt.executeUpdate();
        return true;
    }
    /**
     * mypageに表示するプロフィール情報を取得するメソッド
     * @param userid
     * @param con
     * @return
     * @throws SQLException
     */
    public static UserDto mypageSelect(int userid) throws SQLException{
        String sql = "select us.user_id,us.icon_url,us.user_name,us.follow_count,us.follower_count "
                +"from user as us "
                +"where us.user_id = ? "
                +"and us.existence_type = 0";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        ResultSet rs = stmt.executeQuery();
        UserDto returndto = null;
        while(rs.next()){
            returndto = new UserDto();
            returndto.setUser_id(rs.getInt("user_id"));
            returndto.setIcon_url(rs.getString("icon_url"));
            returndto.setUser_name(rs.getString("user_name"));
            returndto.setFollow_count(rs.getInt("follow_count"));
        }
        return returndto;
    }
    /**
     * ログインを行うメソッド
     * @param dto
     * @param con
     * @return
     * @throws SQLException
     */
    public static void loginSelect(UserDto dto) throws SQLException{
        String sql = "select us.user_id,us.user_name "
                +"from user as us "
                +"where us.email = ? "
                +"and us.password = md5(?) "
                +"and us.existence_type = 0";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dto.getEmail());
        stmt.setString(2, dto.getPassword());
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            dto.setUser_id(rs.getInt("user_id"));
            dto.setUser_name(rs.getString("user_name"));
        }
    }
    /**
     * ユーザ検索を行うメソッド
     * @param userid
     * @param search
     * @param con
     * @return
     * @throws SQLException
     */
    public static ArrayList<UserFollowDto> userSearch(int userid, String search) throws SQLException{
        ArrayList<UserFollowDto> usersearchlist = new ArrayList<>();
        String sql = "select us.user_id,us.user_name,us.icon_url,fo.user_id as fol "
                +"from user as us "
                +"left outer join (select * from follow where user_id = ?) as fo on us.user_id = fo.follow_user_id "
                +"where us.user_name like ? "
                +"and us.existence_type = 0 "
                +"order by us.user_id desc ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.setString(2, search);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            UserFollowDto dto = new UserFollowDto();
            dto.getUserdto().setUser_id(rs.getInt("user_id"));
            dto.getUserdto().setUser_name(rs.getString("user_name"));
            dto.getUserdto().setIcon_url(rs.getString("icon_url"));
            dto.getFollowdto().setUser_id(rs.getInt("fol"));
            usersearchlist.add(dto);
        }
        return usersearchlist;
    }
    /**
     * ユーザ検索の続きを行うメソッド
     * @param userid
     * @param lastuserid
     * @param search
     * @param con
     * @return
     * @throws SQLException
     */
    public static ArrayList<UserFollowDto> continuationUserSearch(int userid,int lastuserid, String search) throws SQLException{
        ArrayList<UserFollowDto> usersearchlist = new ArrayList<>();
        String sql = "select us.user_id,us.user_name,us.icon_url,fo.user_id "
                +"from user as us "
                +"left outer join (select * from follow where user_id = ?) as fo on us.user_id = fo.follow_user_id "
                +"where us.user_name like ? "
                +"and us.existence_type = 0 "
                +"and us.user_id < ?"
                +"order by us.user_id desc "
                +"limit 30";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.setString(2, search);
        stmt.setInt(3, lastuserid);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            UserFollowDto dto = new UserFollowDto();
            dto.getUserdto().setUser_id(rs.getInt("user_id"));
            dto.getUserdto().setUser_name(rs.getString("user_name"));
            dto.getUserdto().setIcon_url(rs.getString("icon_url"));
            dto.getFollowdto().setUser_id(rs.getInt("follow"));
            usersearchlist.add(dto);
        }
        return null;
    }
    /**
     * プロフィール編集情報取得
     * @param userid
     * @param con
     * @return
     * @throws SQLException
     */
    public static UserDto profileSelect(int userid) throws SQLException{
        UserDto dto = null;
        String sql = "select us.icon_url,us.user_name,us.email "
                +"from user as us "
                +"where user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            dto = new UserDto();
            dto.setIcon_url(rs.getString("icon_url"));
            dto.setUser_name(rs.getString("user_name"));
            dto.setEmail(rs.getString("email"));
        }
        return dto;
    }
    /**
     * userレコードupdate
     * @param dto
     * @param con
     * @return
     * @throws SQLException
     */
    public static boolean userUpdate(UserDto dto) throws SQLException{
        String sql = "update user as us "
                +"set us.user_name = ? "
                +",us.email = ? "
                +"where us.user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dto.getUser_name());
        stmt.setString(2, dto.getEmail());
        stmt.setInt(3, dto.getUser_id());
        System.out.println(sql);
        stmt.executeUpdate();
        return true;

    }
    /**
     * 同じパスワードが何個あるかを取得する
     * @param dto
     * @param con
     * @return
     * @throws SQLException
     */
    public static int passCount(UserDto dto) throws SQLException{

        String sql = "select count(us.user_id) as pass "
                +"from user as us "
                +"where us.user_id = ? "
                +"and us.password = md5(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, dto.getUser_id());
        stmt.setString(2, dto.getPassword());
        ResultSet rs = stmt.executeQuery();
        rs.next();
        System.out.println(rs.getInt("pass"));
        return rs.getInt("pass");
    }
    /**
     * userレコードパスワードupdate
     * @param dto
     * @param con
     * @return
     * @throws SQLException
     */
    public static boolean passUpdate(UserDto dto) throws SQLException{
        String sql = "update user as us "
                +"set us.password = md5(?)"
                +"where us.user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dto.getPassword());
        stmt.setInt(2, dto.getUser_id());
        stmt.executeUpdate();
        return true;

    }
    /**
     * フォローカウントをプラス１するメソッド
     * @param userid
     * @param con
     * @throws SQLException
     */
    public static void followCountUp(int userid) throws SQLException{
        String sql = "update user as us "
                +"set us.follow_count = us.follow_count + 1 "
                +"where us.user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.executeUpdate();
    }
    /**
     * フォローカウントをマイナス１するメソッド
     * @param userid
     * @param con
     * @throws SQLException
     */
    public static void followCountDown(int userid) throws SQLException{
        String sql = "update user as us "
                +"set us.follow_count = us.follow_count - 1 "
                +"where us.user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.executeUpdate();
    }
    /**
     * フォロワーカウントをプラス１するメソッド
     * @param userid
     * @param con
     * @throws SQLException
     */
    public static void followerCountUp(int userid) throws SQLException{
        String sql = "update user as us "
                +"set us.follower_count = us.follower_count + 1 "
                +"where us.user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.executeUpdate();
    }
    /**
     * フォロワーカウントをマイナス１するメソッド
     * @param userid
     * @param con
     * @throws SQLException
     */
    public static void followerCountDown(int userid) throws SQLException{
        String sql = "update user as us "
                +"set us.follower_count = us.follower_count - 1 "
                +"where us.user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.executeUpdate();
    }
    /**
     * アカウントの削除(別情報の上書き)
     * @param userid
     * @param con
     * @return
     * @throws SQLException
     */
    public static boolean accountDelete(int userid) throws SQLException{
        String sql = "update user as us "
                +"set us.user_name = '名無し' "
                +",us.email = null "
                +",us.password = null "
                +",us.existence_type = 1 "
                +"where user_id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userid);
        stmt.executeUpdate();
        return true;
    }

    public static int incrementShow() throws SQLException{
        String sql = "show table status like 'user'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt("Auto_increment");
    }
}
