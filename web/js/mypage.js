$(document).ready(function() {
	// jsonを読み込んでデータの書き換えを初期に行う
	// ユーザ名変更
	var username = $('#username-text').children().html();
	$('#username-text').children().html('test');
	// フォロー人数変更
	var follownum = $('#follow-user-num').val(); // input
	$('#follow-user-num-show').html(1);
	// フォロワー人数変更
	var followernum = $('#follower-user-num').val(); // input
	$('#follower-user-num-show').html(2);
	// ユーザID変更
	var userid = $('#profile-follow-num').find('.userid').val(); // hidden
	$('#profile-follow-num').find('.userid').val(3);
	var userid = $('#profile-follower-num').find('.userid').val(); // hidden
	$('#profile-follower-num').find('.userid').val(4);
});