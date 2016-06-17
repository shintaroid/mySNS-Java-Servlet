package com.mySNS.facade;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.mySNS.dao.*;
import com.mySNS.dto.*;

public class Facade {

	private static Connection conn;

	Facade(){
	}
	/**
	 * ユーザの新規登録を行いセッションに保存する情報を返すメソッド
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	public static UserDto addUser(UserDto dto, InputStream input) {
		conn = ConnectionDao.getConnection();
		try {
			conn.setAutoCommit(false);
			UserDao.addUser(dto, input);
			conn.commit();
		} catch (Exception e) {
			try{
				conn.rollback();
			} catch(SQLException ignored){}
			e.printStackTrace();
		}
		return dto;
	}

	/**
	 * ログイン処理を行うメソッド 成功ならdtoを返す 失敗ならnullを返す
	 */
	public static UserDto loginAuth(String email, String password) {
		UserDto user = null;
		try {
			user = UserDao.getUser(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * フォロー処理を行う
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean follow(FollowDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			FollowDao.followInsert(dto, con);
			UserDao.followCountUp(dto.getUser_id(), con);
			UserDao.followerCountUp(dto.getFollow_user_id(), con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * アンフォローの処理を行う
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean unFollow(FollowDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			FollowDao.followDelete(dto, con);
			UserDao.followCountDown(dto.getUser_id(), con);
			UserDao.followerCountDown(dto.getFollow_user_id(), con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * いいねの処理を行う
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean favorite(FavoriteDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			FavoriteDao.favoriteInsert(dto, con);
			PostDao.favoriteCountUp(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * いいね取消の処理を行う
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean unFavorite(FavoriteDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			FavoriteDao.favoriteDelete(dto, con);
			PostDao.favoriteCountDown(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * マイページ情報取得
	 *
	 * @param userid
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static UserDto mypage(int userid) throws SNSException {
		Connection con = BaseDao.getConnection();
		UserDto returndto = null;
		try {
			con.setAutoCommit(false);
			returndto = UserDao.mypageSelect(userid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return returndto;
	}

	/**
	 * post情報の編集
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean postEdit(PostDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			PostDao.postUpdate(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;

	}

	/**
	 * パスワードが一致していればtrue、違えばfalseを返す
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean passCheck(UserDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			int pass = UserDao.passCount(dto, con);
			if (pass == 1) {
				return true;
			}
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return false;
	}

	/**
	 * パスワードの変更
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean passEdit(UserDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			UserDao.passUpdate(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * 編集するためのプロフィール情報を取得
	 *
	 * @param userid
	 * @return
	 * @throws SNSException
	 */
	/*public static UserDto profileSelect(int userid) throws SNSException {
		Connection con = BaseDao.getConnection();
		UserDto dto = null;
		try {
			con.setAutoCommit(false);
			dto = UserDao.profileSelect(userid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return dto;
	}

	/**
	 * プロフィールを変更する処理
	 *
	 * @param dto
	 * @param con
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean profileEdit(UserDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			UserDao.userUpdate(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * プロフィール画像変更処理
	 *
	 * @param dto
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean profileImgEdit(UserDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			UserDao.userImgUpdate(dto, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * アカウントの削除
	 *
	 * @param userid
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean userDelete(int userid) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			UserDao.accountDelete(userid, con);
			FollowDao.deleteFollowCountDown(userid, con);
			FollowDao.deleteFollowerCountDown(userid, con);
			FollowDao.followDelete(userid, con);
			FollowDao.followerDelete(userid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;

	}

	/**
	 * 投稿の削除
	 *
	 * @param postid
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean postDelete(int postid) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			PostDao.deletePost(postid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * 現在のaoutincrementの最大値を取得
	 *
	 * @return
	 * @throws SNSException
	 */
	/*public static int getIncrement() throws SNSException {
		Connection con = BaseDao.getConnection();
		int increment = 0;
		try {
			con.setAutoCommit(false);
			increment = ImgDao.incrementShow(con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return increment;

	}

	/**
	 * 画像の投稿
	 *
	 * @param dto
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean imgInsert(ImgDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			for (int i = 0; i < dto.getUrl().length; i++) {
				ImgDao.imgInsert(dto, i, con);
			}
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;

	}

	/**
	 * 画像を削除する処理
	 *
	 * @param postid
	 * @return
	 * @throws SNSException
	 */
	/*public static boolean imgDelete(int postid) throws SNSException {
		Connection con = BaseDao.getConnection();
		try {
			con.setAutoCommit(false);
			ImgDao.imgDelete(postid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return true;
	}

	/**
	 * ユーザ名検索
	 *
	 * @param userid
	 * @param search
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> nameSearch(int userid, String search) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = UserDao.userSearch(userid, search, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;

	}

	/**
	 * ユーザ名検索の続きを読み込む
	 *
	 * @param userid
	 * @param search
	 * @param lastuserid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> continuationNameSearch(int userid, String search, int lastuserid)
			throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = UserDao.continuationUserSearch(userid, lastuserid, search, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;

	}

	/**
	 * 投稿にいいねしてるユーザの一覧取得
	 *
	 * @param userid
	 * @param postid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> favoriteSearch(int userid, int postid) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FavoriteDao.favoriteUserSelect(userid, postid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;

	}

	/**
	 * 投稿にいいねしてるユーザの続き一覧取得
	 *
	 * @param userid
	 * @param lastuserid
	 * @param postid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> continuationFavoriteSearch(int userid, int lastuserid, int postid)
			throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FavoriteDao.continuationFavoriteUserSelect(userid, lastuserid, postid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;

	}

	/**
	 * フォローしているユーザ一覧取得
	 *
	 * @param userid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> followSearch(int userid) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FollowDao.followSelect(userid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;
	}

	/**
	 * フォローしているユーザ続き一覧取得
	 *
	 * @param userid
	 * @param lastuserid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> continuationFollowSearch(int userid, int lastuserid) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FollowDao.continuationFollowSelect(userid, lastuserid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;
	}

	/**
	 * フォロワーユーザ一覧取得
	 *
	 * @param userid
	 * @param lastuserid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> followerSearch(int userid) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FollowDao.followerSelect(userid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;
	}

	/**
	 * フォロワーユーザ続き一覧取得
	 *
	 * @param userid
	 * @param lastuserid
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserFollowDto> continuationFollowerSearch(int userid, int lastuserid) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserFollowDto> list = new ArrayList<>();
		try {
			con.setAutoCommit(false);
			list = FollowDao.continuationFollowerSelect(userid, lastuserid, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return list;
	}

	/**
	 * 投稿を行う
	 *
	 * @param dto
	 * @return
	 * @throws SNSException
	 */
	/*public static int post(PostDto dto) throws SNSException {
		Connection con = BaseDao.getConnection();
		int imgid = 0;
		try {
			con.setAutoCommit(false);
			PostDao.insertPost(dto, con);
			imgid = PostDao.incrementShow(con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return imgid;
	}

	/**
	 * mypageで利用するpostタイムラインの取得
	 *
	 * @param userid
	 * @param date
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserPostImgFavoriteDto> mypageTl(int userid, String date) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserPostImgFavoriteDto> dto = null;
		try {
			con.setAutoCommit(false);
			dto = PostDao.mypageTlSelect(userid, date, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return dto;
	}

	/**
	 * 返信コメント表示で利用するcommentタイムラインの取得
	 *
	 * @param userid
	 * @param date
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserPostImgFavoriteDto> commentTl(int userid, int topid, String date) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserPostImgFavoriteDto> dto = null;
		try {
			con.setAutoCommit(false);
			dto = PostDao.commentTlSelect(userid, topid, date, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return dto;
	}

	/**
	 * 投稿タイムラインの取得
	 *
	 * @param userid
	 * @param date
	 * @return
	 * @throws SNSException
	 */
	/*public static ArrayList<UserPostImgFavoriteDto> postTl(int userid, String date) throws SNSException {
		Connection con = BaseDao.getConnection();
		ArrayList<UserPostImgFavoriteDto> dto = null;
		try {
			con.setAutoCommit(false);
			dto = PostDao.postTlSelect(userid, date, con);
			con.commit();
		} catch (SQLException e) {
			BaseDao.rollBack(con);
		} finally {
			BaseDao.setAutoCommit(con);
		}
		return dto;
	}*/

	//public static

}
