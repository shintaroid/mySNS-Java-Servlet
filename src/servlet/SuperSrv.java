package com.mySNS.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.arnx.jsonic.JSON;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SuperSrv
 *
 * @param <T>
 * @param <T>
 * @param <S>
 */
public class SuperSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String URL = "C:/test/img/";
	public void setUrl(String url){
		this.URL = url;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("aaa");
	}

	/**
	 *
	 * ListをJSONに変換するメソッド
	 *
	 * @param list
	 *            DtoList
	 * @return JSON
	 */
	protected <T> String encodeJson(ArrayList<T> list) {
		return JSON.encode(list, true);
	}

	/**
	 * List以外をJSONに変換するメソッド
	 *
	 * @param flg
	 *            リスト以外のすべての型を受け取る
	 * @return String Json
	 */
	protected <S> String encodeJson(S flg) {
		return JSON.encode(flg, true);
	}

	/**
	 *
	 * @param arg0
	 *            HttpServletRequest
	 * @return session接続情報
	 *
	 *         セッションに接続するメソッド
	 */
	protected HttpSession getSession(HttpServletRequest arg0) {
		HttpSession session = arg0.getSession(false);
		// セッションが切れてたらlogin.jspへ飛ばす
		if (session == null) {
			// System.out.println("セッション切れ");
			arg0.getRequestDispatcher("login.jsp");
		}
		return session;
	}

	/**
	 *
	 * @param request
	 *            HttpServletRequest
	 * @return String 分岐メッセージ メッセージを取得するメソッド
	 */
	protected String getMessage(HttpServletRequest request) {
		return request.getParameter("message");
	}

	/**
	 * 送信元URLを取得するメソッド
	 *
	 * @param request
	 *            HttpServletRequest
	 * @return String 送信元URL
	 */
	protected String getPageName(HttpServletRequest request) {
		return request.getParameter("pagename");
	}

	/**
	 * JSONからPOJOへデコードするメソッド
	 *
	 * @param json
	 *            JSON
	 * @return String POJO
	 */
	protected String decodeJson(String json) {
		return JSON.decode(json, String.class);
	}

	/**
	 * 例外処理を行うメソッド
	 *
	 * @param request
	 *            HttpServletRequest
	 * @param e
	 *            SNSException
	 * @throws IOException
	 * @throws ServletException
	 */
	protected void doErrorAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				//out.println("<h1>"+e.errorMessage()+"</h1>");
		//System.out.println(e.errorMessage());
		//request.setAttribute("error", e.errorMessage());
		//request.getRequestDispatcher(request.getParameter("pagename")).forward(request, response);
	}

	/**
	 * エラー処理を行うメソッド
	 *
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param e
	 *            SNSException
	 * @throws IOException
	 */
	protected void doAjaxErrorAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		//out.print(encodeJson(e.errorMessage()));
		return;
	}

	/**
	 * 画像のリネームを行い、レジストリに保存し、リネームしたurlを返すメソッド
	 *
	 * @param request
	 *            HttpServletRequest
	 * @return HashMap<String,String> URL,message,etc・・・
	 * @throws Exception
	 */
	/*protected HashMap<String, String> uploadImage(HttpServletRequest request,int imgname) throws Exception {
//		int increment = ImgService.editPicture();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		HashMap<String, String> map = new HashMap<>();
		factory.setSizeThreshold(0);
		factory.setRepository(new File("C:/test/tmp/")); // 一時的に保存する際のディレクトリ

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(10 * 1024 * 1024);
		upload.setFileSizeMax(10 * 1024 * 1024);

		List<FileItem> items;

//		int imgname = increment;S

		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// エラー処理
			e.printStackTrace();
		}
		// 全フィールドに対するループ
		int imgnum = 0;
		for (Object val : items) {
			FileItem item = (FileItem) val;
			if (!item.isFormField()) {
				String input = item.getName();
				if (!input.equals("")) {
					imgnum++;
					String url = URL + imgname + ".png";
					item.write(new File(url));
					map.put("url" + imgnum, url);
					imgname++;
				}
			} else {
				map.put(item.getFieldName(), item.getString());
			}

		}
		map.put("imgnum", String.valueOf(imgnum));

		for (Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		return map;
	}*/

}
