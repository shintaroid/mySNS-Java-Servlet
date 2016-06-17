<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="navbar-collapse collapse in navbar-inverse navbar-fixed-top" id="navbarEexample" aria-expanded="true">
		<form class="navbar-form navbar-left" method="post" action="tl">
			<input type="hidden" name="message" value="tl">
			<input type="hidden" name="pagename" value="post.jsp">
			<input type="hidden" name="lastpostdate" value="none">
			<div class="form-group">
 				<button type="submit" class="btn btn-secondary-outline" name="search">
					<i class="glyphicon glyphicon-home"></i>
				</button>
			</div>
		</form>
		<form class="navbar-form navbar-left" role="search" method="post" action="search" >
			<input type="hidden" name="message" value="search">
			<input type="hidden" name="pagename" value="post.jsp">
			<div class="form-group">
				<input type="text" name="searchname" class="form-control" placeholder="Search" maxlength="32" required>
				<button type="submit" class="btn btn-secondary-outline" name="search">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
		</form>
		<form class="navbar-form navbar-right" role="logout" action="login" method="post">
			<div class="form-group logout">
				<input type="hidden" name="message" value="logout">
				<button type="submit" class="btn btn-secondary-outline" name="logout" style="height: 32px">
					<p style="color: white;">Logout</p>
				</button>
			</div>
		</form>
		<form class="navbar-form navbar-right" role="mypage" action="mypage" method="post">
			<input type="hidden" name="message" value="userpage">
			<input type="hidden" name="userid" value="1">
			<input type="hidden" name="pagename" value="mypage.jsp">
			<div class="form-group mypage">
				<button id="header-username" type="submit" class="btn btn-secondary-outline" name="mypage" style="height: 32px">
					<p style="color: white">MyPage</p>
				</button>
			</div>
		</form>
	</div>
</body>
</html>