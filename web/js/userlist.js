$(document).ready(function() {
	// // ********** は要変更箇所（受け取ったデータにより変更）
	// ユーザリストの表示
	for (var i = 0; i < 3; i++) { // **********
		$('#userlist').append('<div id="userlist-box-' + i + '" class="container-fluid tl-box" style="margin-left: auto; margin-right: auto;">');
		$('#userlist-box-' + i).append('<div id="userlist-panel-' + i + '">');
		$('#userlist-panel-' + i).append('<div id="userlist-panel-outline-' + i + '" class="col-xs-offset-2 col-xs-8">');
		$('#userlist-panel-outline-' + i).append('<div id="userlist-panel-info-' + i + '" class="well panel-info">');

		// ユーザリスト表示箇所
		$('#userlist-panel-info-' + i).append('<div id="userlist-panel-userlist-row-' + i + '" class="row">');
		$('#userlist-panel-userlist-row-' + i).append('<div id="userlist-panel-userlist-icon-' + i + '" class="col-xs-offset-2 col-xs-2" >');
		$('#userlist-panel-userlist-icon-' + i).append('<img src=' + '"img/harinezumi.jpg"' + 'width="34" height="34" />'); // **********
		$('#userlist-panel-userlist-icon-' + i).append('</div>');
		$('#userlist-panel-userlist-row-' + i).append('<div id="userlist-panel-userlist-username-' + i + '" class="col-xs-5" >');
		$('#userlist-panel-userlist-username-' + i).append('<form action="mypage" id="userlist-panel-userlist-form-' + i + '" method="post" >');
		$('#userlist-panel-userlist-form-' + i).append('<input type="hidden" name="userid" value=' + '"1"' + '>'); // **********
		$('#userlist-panel-userlist-form-' + i).append('<label id="userlist-panel-userlist-label-' + i + '" style="background :none;" >'); // **********
		$('#userlist-panel-userlist-label-' + i).append('<h4><a><strong>' + 'スズキイチロー' + '</strong></a></h4>'); // **********
		$('#userlist-panel-userlist-label-' + i).append('<input id="userlist-panel-userlist--submit-' + i + '" class="mypage-button" type="submit" style="display: none;" value =' + "false" + ' />'); // **********
		$('#userlist-panel-userlist-label-' + i).append('</label>');
		$('#userlist-panel-userlist-form-' + i).append('</form>');
		$('#userlist-panel-userlist-username-' + i).append('</div>');
		$('#userlist-panel-userlist-row-' + i).append('<div id="userlist-panel-userlist-follow-' + i + '" class="col-xs-3" >');
		$('#userlist-panel-userlist-follow-' + i).append('<form id="userlist-panel-userlist-follow-form-' + i + '" action="post.jsp" method="post">');
		$('#userlist-panel-userlist-follow-form-' + i).append('<label id="userlist-panel-userlist-follow-label-' + i + '" >');
		$('#userlist-panel-userlist-follow-label-' + i).append('<span class="follow-text">フォロー</span>');
		$('#userlist-panel-userlist-follow-label-' + i).append('<i class="glyphicon glyphicon-user"></i>');
		$('#userlist-panel-userlist-follow-label-' + i).append('<input id="userlist-panel-userlist-button-' + i + '" class="follow-button" type="button" style="display:none;" value="0" >');
		$('#userlist-panel-userlist-follow-label-' + i).append('</label>');
		$('#userlist-panel-userlist-follow-form-' + i).append('</form>');
		$('#userlist-panel-userlist-follow-' + i).append('</div>');
		$('#userlist-panel-userlist-row-' + i).append('</div>');

		$('#userlist-panel-info-' + i).append('</div>');
		$('#userlist-panel-outline-' + i).append('</div>');
		$('#userlist-panel-' + i).append('</div>');
		$('#userlist-box-' + i).append('</div>');
		$('#userlist').append('</div>');
	}

	// ページング処理
	$('#paging').append('<div id="paging-box" class="container-fluid text-center">');
	$('#paging-box').append('<ul id="pagination-box" class="pagination">');
	$('#pagination-box').append('<li id="paging-pre" class="disabled"><a href="#">&laquo;</a></li>');
	for (var i = 1; i <= 5; i++){
		$('#pagination-box').append('<li class="paging-button"><a class="paging-link">' + i + '</a></li>');
	}
	$('#pagination-box').append('<li id="paging-next"><a href="#">&raquo;</a></li>');
	$('#pagination-box').append('</ul>');
	$('#paging-box').append('</div>');

	// 初期処理
	$(function(){
		$('#pagination-box > li:eq(1)').addClass("active");
	});
})

// ページングのボタンが押された時の操作
$(function(){
	// 数字ボタン
	$(document).on('click','.paging-button',function(){
		$('#pagination-box > .active').removeClass("active");
		$(this).addClass("active");
		var num = parseInt($('#pagination-box > .active').find('.paging-link').html());
		if (num == 1) {
			$('#paging-pre').addClass("disabled");
		} else {
			$('#paging-pre').removeClass("disabled");
		}
		if (num == 5) {
			$('#paging-next').addClass("disabled");
		} else {
			$('#paging-next').removeClass("disabled");
		}
	})

	// &laquo;ボタン
	$(document).on('click','#paging-pre',function(){
		var num = parseInt($('#pagination-box > .active').find('.paging-link').html());
		if (num == 1) {
			$('#paging-pre').addClass("disabled");
		} else if (num == 2) {
			$('#pagination-box > .active').prev().addClass("active");
			$('.active + .active').removeClass("active");
			$('#paging-pre').addClass("disabled");
		} else {
			$('#pagination-box > .active').prev().addClass("active");
			$('.active + .active').removeClass("active");
			$('#paging-pre').removeClass("disabled");
		}
		if (num == 5) {
			$('#paging-next').addClass("disabled");
		} else {
			$('#paging-next').removeClass("disabled");
		}

	})

	// &raquo;ボタン
	$(document).on('click','#paging-next',function(){
		var num = parseInt($('#pagination-box > .active').find('.paging-link').html());
		if (num == 1) {
			$('#paging-pre').addClass("disabled");
		} else {
			$('#paging-pre').removeClass("disabled");
		}
		if (num == 5) {
			$('#paging-next').addClass("disabled");
		} else if (num == 4) {
			$('#pagination-box > .active').next().addClass("active");
			$('.active + .active').prev().removeClass("active");
			$('#paging-next').addClass("disabled");
		} else {
			$('#pagination-box > .active').next().addClass("active");
			$('.active + .active').prev().removeClass("active");
			$('#paging-next').removeClass("disabled");
		}
	})

})