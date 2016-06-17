<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
<link rel=stylesheet type="text/css" href="css/tl.css">
<link rel=stylesheet type="text/css" href="css/post.css">
<link rel=stylesheet type="text/css" href="css/follow.css">
<title>検索結果</title>
</head>
<body>
	<div id="header" style="margin-top: 60px; margin-left: auto; margin-right: auto;" >
		<jsp:include page="header.jsp" flush="true" />
	</div>

	<div id="userlist"></div>

	<div id="paging"></div>

	<div class="container">
		<div class="row">
			<form action="tl" method="post">
				<input type="hidden" name="message" value="tl">
				<input type="hidden" name="pagename" value="post.jsp">
				<input type="hidden" name="lastpostdate" value="none">
				<label class="col-xs-offset-10 col-xs-1">
					<span>戻る</span>
					<input type="submit" name="return-page" style="display: none;" >
				</label>
			</form>
		</div>
	</div>

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/jquery.uploadThumbs.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/post.js"></script>
	<script src="js/follow.js"></script>
	<script src="js/userlist.js"></script>
</body>
</html>