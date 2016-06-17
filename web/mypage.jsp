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
<title>マイページ</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />

	<div class="container-fluid" style="margin-top: 60px; margin-left: auto; margin-right: auto;">
		<div class="post-panel">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="well panel-info">
						<div class="panel-body">
							<div class="row">
								<div class="container">
									<div class="user-icon">
										<img class="img-responsive col-xs-3" src="img/harinezumi.jpg" style="width: 150px; height: auto;" />
									</div>
									<div class="username-box col-xs-6">
										<h4 id="username-text"><strong>スズキイチロー</strong></h4>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-xs-4">
									<form action="search" id="profile-follow-num" method="post" enctype='multipart/form-data'>
										<input type="hidden" name="message" value="follow">
										<input type="hidden" class="userid" name="userid" value="1">
										<input type="hidden" name="lastuserid" value="0">
										<label class="follo-button-show">
											<span class="follow-text">フォロー人数</span>
											<input type="submit" id="follow-user-num" name="follow" style="display: none;" value="1001" >
											<span id="follow-user-num-show">0</span>
										</label>
									</form>
								</div>
								<div class="col-xs-4">
									<form action="search" id="profile-follower-num" method="post" enctype='multipart/form-data'>
										<input type="hidden" name="message" value="follower">
										<input type="hidden" class="userid" name="userid" value="2">
										<label class="folloer-button-show">
											<span class="follower-text">フォロワー人数</span>
											<input type="submit" id="follower-user-num" name="follower" style="display: none;" value="1002" >
											<span id="follower-user-num-show">0</span>
										</label>
									</form>
								</div>
								<div class="col-xs-3">
									<form action="profile" method="post" enctype='multipart/form-data'>
										<input type="hidden" name="message" value="get">
										<label class="edit-button-show">
											<span id="edit-text">編集</span>
											<i class="glyphicon glyphicon-pencil"></i>
											<input type="submit" id="edit-data" name="edit" style="display: none;" >
										</label>
									</form>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>

	<div id="timeline"></div>

	<div class="conteiner text-center">
		<button id="more-read" class="btn btn-secondary-outline">もっと読む</button>
	</div>


	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/tl.js"></script>
	<script src="js/post.js"></script>
	<script src="js/post_modal.js"></script>
	<script src="js/mypage.js"></script>
</body>
</html>