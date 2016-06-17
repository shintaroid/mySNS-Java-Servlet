$(document).ready(function() {
	// sessionにpostidを追加

	// ajax非同期
	$.ajax({
		url: 'tl',
		type : 'POST',
		dataType : 'JSON',
		data : {
			'message' : 'tl'
		}
	}).done(function(data){ //ajaxの通信に成功した場合
//		alert("success!");

//			alert(JSON.stringify(data[0].favoritedto.favorite_id));
			alert(JSON.stringify(data[0].postdto));
			alert(JSON.stringify(data[0]));

		// // ********** は要変更箇所（受け取ったデータにより変更）
		for (var i = 0; i < 3; i++) { // **********
			getTileline(i);
		}
	}).fail(function(data){ //ajaxの通信に失敗した場合
		alert("通信に失敗しました");
	});
})

function getTileline(i){
	$('#timeline').append('<div id="timeline-box-' + i + '" class="container-fluid tl-box" style="margin-left: auto; margin-right: auto;">');
	$('#timeline-box-' + i).append('<div id="timeline-panel-' + i + '">');
	$('#timeline-panel-' + i).append('<div id="timeline-panel-outline-' + i + '" class="col-xs-offset-2 col-xs-8">');
	$('#timeline-panel-outline-' + i).append('<div id="timeline-panel-info-' + i + '" class="well panel-info">');

	// ヘッダーの作成
	$('#timeline-panel-info-' + i).append('<div id="timeline-panel-header-' + i + '" class="panel-header">');
	$('#timeline-panel-header-' + i).append('<div id="timeline-panel-header-icon-' + i + '" class="col-xs-1">');
	$('#timeline-panel-header-icon-' + i).append('<img src=' + '"img/harinezumi.jpg"' + 'width="34" height="34" />'); // **********
	$('#timeline-panel-header-icon-' + i).append('</div>');
	$('#timeline-panel-header-' + i).append('<div id="timeline-panel-header-username-' + i + '" class="col-xs-6">');
	$('#timeline-panel-header-username-' + i).append('<form action="mypage" id="timeline-panel-header-form-' + i + '" method="post">'); // **********
	$('#timeline-panel-header-form-' + i).append('<input type="hidden" name="userid" value=' + '"1"' + '>'); // **********
	$('#timeline-panel-header-form-' + i).append('<label id="timeline-panel-header-label-' + i + '" style="background :none;" >'); // **********
	$('#timeline-panel-header-label-' + i).append('<h4><a><strong>' + 'スズキイチロー' + '</strong></a></h4>'); // **********
	$('#timeline-panel-header-label-' + i).append('<input id="timeline-panel-header-submit-' + i + '" class="mypage-button" type="submit" style="display: none;" value =' + "false" + ' />'); // **********
	$('#timeline-panel-header-label-' + i).append('</label>');
	$('#timeline-panel-header-form-' + i).append('</form>');
	$('#timeline-panel-header-username-' + i).append('</div>');
	$('#timeline-panel-header-' + i).append('</div>');

	// TL内容表示箇所
	$('#timeline-panel-info-' + i).append('<div id="timeline-panel-body-' + i + '" class="panel-body time-line-text-box" style="margin-top: 40px;">');
	$('#timeline-panel-body-' + i).append('<div id="timeline-panel-timeline-' + i + '">');
	$('#timeline-panel-timeline-' + i).append('<div id="timeline-panel-timeline-row-' + i + '" class="row">');
	$('#timeline-panel-timeline-row-' + i).append('<div id="timeline-panel-timeline-text-' + i + '" class="col-xs-12 post-text-box">');
	$('#timeline-panel-timeline-text-' + i).append('古いプラットフォーム使うユーザへのサポート、すごい大変なの分かる…正直もうiOS7対応辞めたいもん…(仕事じゃなかったら絶対に切り捨ててた)'); // **********
	$('#timeline-panel-timeline-text-' + i).append('</div>');
	$('#timeline-panel-timeline-row-' + i).append('</div>');
	$('#timeline-panel-timeline-' + i).append('</div>');
	$('#timeline-panel-body-' + i).append('<div id="timeline-panel-date-' + i + '" class="text-right">');
	$('#timeline-panel-date-' + i).append('<small>' + '2016年4月19日 10:32' + '</small>'); // **********
	$('#timeline-panel-date-' + i).append('</div>');
	$('#timeline-panel-body-' + i).append('<div id="timeline-panel-extends-' + i + '" style="margin-top: 10px;">');

	// いいね
	$('#timeline-panel-extends-' + i).append('<div id="timeline-panel-extends-favorite-box-' + i + '" class="col-sm-4">');
	$('#timeline-panel-extends-favorite-box-' + i).append('<form action="search" id="timeline-panel-extends-favorite-form-' + i + '" method="post" >');
	$('#timeline-panel-extends-favorite-form-' + i).append('<input type="hidden" class="type" name="message" value="favorite" >');
	$('#timeline-panel-extends-favorite-form-' + i).append('<input type="hidden" name="userid" value=' + '"1"' + '>'); // **********
	$('#timeline-panel-extends-favorite-form-' + i).append('<input type="hidden" name="postid" value=' + '"1"' + '>'); // **********
	$('#timeline-panel-extends-favorite-form-' + i).append('<label id="timeline-panel-extends-favorite-label-' + i + '">');
	$('#timeline-panel-extends-favorite-label-' + i).append('いいね！<i id="timeline-panel-extends-favorite-icon-' + i + '" class=' + '"glyphicon glyphicon-heart-empty"' + '></i>'); // **********
	$('#timeline-panel-extends-favorite-label-' + i).append('<input id="timeline-panel-extends-favorite-submit-' + i + '" class="favorite-button" type="button" style="display: none;" value =' + "false" + ' />'); // **********
	$('#timeline-panel-extends-favorite-label-' + i).append('</label>');
	$('#timeline-panel-extends-favorite-form-' + i).append('<input id="timeline-panel-extends-favorite-count-' + i + '" class="favorite-num" type="submit" value =' + i + ' />'); // **********
	$('#timeline-panel-extends-favorite-box-' + i).append('</div>');

	// 返信
	$('#timeline-panel-extends-' + i).append('<div id="timeline-panel-extends-comment-box-' + i + '" class="col-sm-4">');
	$('#timeline-panel-extends-comment-box-' + i).append('<form id="timeline-panel-extends-comment-form-' + i + '" method="post" action="tl">'); // **********
	$('#timeline-panel-extends-comment-form-' + i).append('<input type="hidden" name="message" value="comment" >'); // **********
	$('#timeline-panel-extends-comment-form-' + i).append('<input type="hidden" name="lastpostdate" value="none" >'); // **********
	$('#timeline-panel-extends-comment-form-' + i).append('<input type="hidden" name="pagename" value="post.jsp" >'); // **********
	$('#timeline-panel-extends-comment-form-' + i).append('<label id="timeline-panel-extends-comment-label-' + i + '">');
	$('#timeline-panel-extends-comment-label-' + i).append('返信数 <i id="timeline-panel-extends-comment-icon-' + i + '" class=' + '"glyphicon glyphicon-envelope"' + '></i>');
	$('#timeline-panel-extends-comment-label-' + i).append('<input id="timeline-panel-extends-comment-submit-' + i + '" type="submit" style="display: none;" />'); // **********
	$('#timeline-panel-extends-comment-label-' + i).append('</label>');
	$('#timeline-panel-extends-comment-form-' + i).append('<input id="timeline-panel-extends-comment-count-' + i + '" class="comment-num" type="submit" value =' + i + ' />'); // **********
	$('#timeline-panel-extends-comment-form-' + i).append('</form>');
	$('#timeline-panel-extends-comment-box-' + i).append('</div>');

	// 編集
	$('#timeline-panel-extends-' + i).append('<div id="timeline-panel-extends-edit-box-' + i + '" class="col-sm-4">');
	$('#timeline-panel-extends-edit-box-' + i).append('<form id="timeline-panel-extends-edit-form-' + i + '" class="edit-form" method="post">'); // **********
	$('#timeline-panel-extends-edit-form-' + i).append('<label id="timeline-panel-extends-edit-label-' + i + '">');
	$('#timeline-panel-extends-edit-label-' + i).append('編集 <i id="timeline-panel-extends-edit-icon-' + i + '" class=' + '"glyphicon glyphicon-pencil"' + '></i>');
	$('#timeline-panel-extends-edit-label-' + i).append('<input type="button" class="edit-text-button" style="display: none;" data-toggle="modal" data-target="#timeline-panel-extends-edit-modal-' + i + '">');
	$('#timeline-panel-extends-edit-label-' + i).append('</label>');
	// Modal
	$('#timeline-panel-extends-edit-form-' + i).append('<div id="timeline-panel-extends-edit-modal-' + i + '" class="myModal modal fade">');
	$('#timeline-panel-extends-edit-modal-' + i).append('<div id="timeline-panel-extends-edit-modal-dialog-' + i + '" class="modal-dialog" >');
	$('#timeline-panel-extends-edit-modal-dialog-' + i).append('<div id="timeline-panel-extends-edit-modal-content-' + i + '" class="modal-content edit-post-modal-content">');
	$('#timeline-panel-extends-edit-modal-content-' + i).append('<div id="timeline-panel-extends-edit-modal-header-' + i + '" class="modal-header">');
	$('#timeline-panel-extends-edit-modal-header-' + i).append('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>');
	$('#timeline-panel-extends-edit-modal-header-' + i).append('<h4 class="modal-title">投稿編集</h4>');
	$('#timeline-panel-extends-edit-modal-header-' + i).append('</div>');
	$('#timeline-panel-extends-edit-modal-content-' + i).append('<div id="timeline-panel-extends-edit-modal-body-' + i + '" class="modal-body">');
	$('#timeline-panel-extends-edit-modal-body-' + i).append(' <textarea rows="5" cols="80" maxlength="140" class="edit-text-area">test</textarea> ');
	$('#timeline-panel-extends-edit-modal-body-' + i).append('</div>');
	$('#timeline-panel-extends-edit-modal-content-' + i).append('<div id="timeline-panel-extends-edit-modal-footer-' + i + '" class="modal-footer">');
	$('#timeline-panel-extends-edit-modal-footer-' + i).append('<button type="button" class="btn btn-danger edit-text-box-delete" data-dismiss="modal">投稿削除</button>');
	$('#timeline-panel-extends-edit-modal-footer-' + i).append('<button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>');
	$('#timeline-panel-extends-edit-modal-footer-' + i).append('<input type="button" class="btn btn-secondary edit-text-box-sumbmit" value="保存" />');
	$('#timeline-panel-extends-edit-modal-footer-' + i).append('</div>');
	$('#timeline-panel-extends-edit-modal-content-' + i).append('</div>');
	$('#timeline-panel-extends-edit-modal-dialog-' + i).append('</div>');
	$('#timeline-panel-extends-edit-modal-' + i).append('</div>');

	$('#timeline-panel-extends-edit-form-' + i).append('</form>');

	$('#timeline-panel-extends-edit-box-' + i).append('</div>');
	$('#timeline-panel-extends-' + i).append('</div>');
	$('#timeline-panel-body-' + i).append('</div>');

	// コメントフォーム
	$('#timeline-panel-info-' + i).append('<div id="timeline-panel-footer-' + i + '" class="panel-footer">');
	$('#timeline-panel-footer-' + i).append('<div id="timeline-panel-footer-row-' + i + '" class="row">');
	$('#timeline-panel-footer-row-' + i).append('<form action="post" id="timeline-panel-footer-comment-form-' + i + '" method="post">');
	$('#timeline-panel-footer-comment-form-' + i).append('<input type="hidden" name="message" value="post">');
	$('#timeline-panel-footer-comment-form-' + i).append('<input type="hidden" name="lastpostid" value=' + '"1"' + '>'); // **********
	$('#timeline-panel-footer-comment-form-' + i).append('<input type="hidden" name="pagename" value="post.jsp">');
	$('#timeline-panel-footer-comment-form-' + i).append('<div id="timeline-panel-footer-icon-' + i + '" class="col-sm-2">');
	$('#timeline-panel-footer-icon-' + i).append('<img src=' + '"img/nero.jpg"' + 'width="34" height="34" />'); // **********
	$('#timeline-panel-footer-icon-' + i).append('</div>');
	$('#timeline-panel-footer-comment-form-' + i).append('<div id="timeline-panel-footer-comment-' + i + '">');
	$('#timeline-panel-footer-comment-' + i).append('<div id="timeline-panel-footer-comment-text-' + i + '" class="col-sm-8">');
	$('#timeline-panel-footer-comment-text-' + i).append('<input type="text" class="form-control" placeholder="コメントする" name="post" required/>');
	$('#timeline-panel-footer-comment-text-' + i).append('</div>');
	$('#timeline-panel-footer-comment-form-' + i).append('<div id="timeline-panel-footer-comment-button-' + i + '" class="col-sm-2">');
	$('#timeline-panel-footer-comment-button-' + i).append('<input type="submit" value="返信" class="btn btn-info-outline" style="color:white;" />');
	$('#timeline-panel-footer-comment-button-' + i).append('</div>');
	$('#timeline-panel-footer-comment-' + i).append('</div>');
	$('#timeline-panel-footer-comment-form-' + i).append('</form>');
	$('#timeline-panel-footer-row-' + i).append('</div>');
	$('#timeline-panel-footer-' + i).append('</div>');

	$('#timeline-panel-info-' + i).append('</div>');
	$('#timeline-panel-outline-' + i).append('</div>');
	$('#timeline-box-' + i).append('</div>');
	$('#timeline').append('</div>');

}
