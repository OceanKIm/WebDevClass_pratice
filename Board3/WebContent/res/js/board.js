
// 디테일 이동.
function clkArticle(typ, i_board) {
	var url = `detail?typ=${typ}&i_board=${i_board}`;
	location.href = url;
}

// 글삭제
function clkDel(i_board, typ) {
	if(confirm('정말 삭제 하시겠습니까?')) {
		location.href = `del?typ=${typ}&i_board=${i_board}`;
	}
}


//지금은 사용 X, 혹시나 나중에 욕이 있는지 체크하는 용도로 사용
function chk() {
	var frm = document.querySelector('#frm');
	if (chkEmplyEle(frm.title, '제목') || chkEmptyEle(frm.ctnt, '내용')) {
		return false;
	}
}

