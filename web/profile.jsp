<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/bootstrap-theme.min.css">
<link rel=stylesheet type="text/css" href="css/tl.css">
<link rel=stylesheet type="text/css" href="css/post.css">
<title>ユーザ編集</title>
</head>
<body>

	<jsp:include page="header.jsp" flush="true" />

	<div class="container-fluid" style="margin-top: 60px; margin-left: auto; margin-right: auto;">
		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="well panel-secondary">
					<h3 class="text-center">ユーザ編集</h3>

					<div class="panel-heading">
						<div class="container">
							<div>
								<img class="img-responsive" src="img/harinezumi.jpg" style="width: 150px; height: auto;" />
							</div>
							<div class="col-xs-offset-5 col-xs-2">
								<form action="login" method="post">
									<input type="hidden" name="message" value="delete">
									<label>
										<span>アカウント削除</span>
										<input type="submit" id="follow-user-num" name="follow" style="display: none;" value="1001" >
									</label>
								</form>
							</div>
						</div>
					</div>

					<div class="panel-body">
						<form action="profile" class="form-horizontal" method="post" enctype='multipart/form-data'>
							<input type="hidden" name="message" value="edit">
							<p class="icon-upload col-xs-offset-1">
								<label>
									<span>写真を選択</span>
									<input type="file" name="icon" size="30" style="display: none;" accept="image/*">
								</label>
							</p>
							<div class="form-panel">
								<div class="form-content">
									<div class="panel-username" style="margin-top: 10px">
										<div class="form-group" id="username-text">
											<span class="col-xs-4 control-label">ユーザ名：</span>
											<div class="col-xs-7">
												<input type="text" class="form-control" name="name" placeholder="ユーザ名" required />
											</div>
										</div>
									</div>
									<div class="panel-email" style="margin-top: 10px">
										<div class="form-group" id="email-text">
											<span class="col-xs-4 control-label">メールアドレス：</span>
											<div class="col-xs-7">
												<input type="email" class="form-control" name="mail" placeholder="メールアドレス" required />
											</div>
										</div>
									</div>
									<div class="panel-password" style="margin-top: 10px;">
										<div class="form-group" id="password-text">
											<span class="col-xs-4 control-label">現在のパスワード：</span>
											<div class="col-xs-7">
												<input type="password" name="oldpass" class="form-control" placeholder="現在のパスワード" required />
											</div>
										</div>
									</div>
									<div class="panel-password_conf" style="margin-top: 10px;">
										<div class="form-group" id="password-text-conf">
											<span class="col-xs-4 control-label">新しいパスワード：</span>
											<div class="col-xs-7">
												<input type="password" name="newpass" class="form-control" placeholder="新しいパスワード" required />
											</div>
										</div>
									</div>
									<div class="panel-password_conf" style="margin-top: 10px;">
										<div class="form-group" id="password-text-conf">
											<span class="col-xs-4 control-label">パスワード確認：</span>
											<div class="col-xs-7">
												<input type="password" name="confpass" class="form-control" placeholder="パスワード確認" required />
											</div>
										</div>
									</div>

								</div>
								<div style="margin-top: 10px;">
									<div class="form-group" id="registration-button">
										<div class="text-center">
											<input type="submit" value="編集完了" class="btn btn-info-outline" style="color:white;" />
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>