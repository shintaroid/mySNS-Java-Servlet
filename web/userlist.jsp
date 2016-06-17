<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="userlist-box" class="container-fluid tl-box" style="margin-left: auto; margin-right: auto;">
		<div id="userlist-panel">
			<div class="col-xs-offset-2 col-xs-8">
				<div id="user-box" class="well panel-info">
					<div class="row">
						<div id="user-box-icon" class="col-xs-offset-2 col-xs-2">
							<img class="media-object" src="img/harinezumi.jpg" width="34px" height="34px" />
						</div>
						<div id="user-box-username" class="col-xs-2">
							<a href="mypage.jsp" style="font-size:24px"><strong>UserName</strong></a>
						</div>
						<div id="user-box-username" class="col-xs-offset-4 col-xs-2">
							<form action="post.jsp" method="post">
								<label>
									<span class="follow-text">フォロー</span>
									<i class="glyphicon glyphicon-user"></i>
									<input id="follow" class="follow-button" type="button" style="display:none;" value="0" >
								</label>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>