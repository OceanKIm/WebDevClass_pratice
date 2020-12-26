
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

//댓글에서 수정버튼 클릭 > 수정FORM 나타나게 처리
function clkCmtMod(i_cmt) {
	var trForm = document.querySelector('#mod_' + i_cmt);
	trForm.classList.remove('cmd_mod_form');
}

function clkCmtClose(i_cmt) {
	var trForm = document.querySelector('#mod_' + i_cmt);
	trForm.classList.add('cmd_mod_form');
}

function toggleFavorite(i_board) {
	var fc = document.querySelector('#favoriteContainer');
	var state = fc.getAttribute('is_favorite'); 	// 1:좋아요 , 0:안좋아요
	var state = 1 - state;
	
	// get방식으로 처리
	axios.get('/board/ajaxfavorite', {
		params: {	
			'state':state,
			'i_board':i_board			
		}
	}).then(function(res) { // 통신성공
		console.log(res);
		if (res.data.result == 1) {
			var iconClass = state == 1? 'fas' : 'far';
			fc.innerHTML = `<i class="${iconClass} fa-heart"></i>`;
			fc.setAttribute('is_favorite', state);
		} else {
			alert('에러가 발생하였습니다.');
		}
	}).catch(function(err) {
		console.log('err 발생 : ' + err);
	});
}

// 댓글 공감
function clkEmp(i_cmt) {
	var emp = document.querySelector('#emp_' + i_cmt);
	var unemp = document.querySelector('#unemp_' + i_cmt);
	console.log('emp_' + i_cmt);
	axios.get('/board/cmt/reg', {
		params: {
			'i_cmt':i_cmt,
			'emp':'emp'
		}
	}).then(function(res) {
		console.log(res);
		console.log('action : ' + res.data.action);
		if (res.data.result == 0) {
			// 에러 처리
		} 
		switch(res.data.action) {
		case 1: // 처음 공감 
			emp.innerHTML = `${res.data.e}`;
			break;
		case 2: // 비공감 -> 공감
			emp.innerHTML = `${res.data.e}`;
			unemp.innerHTML = `${res.data.une}`;
			break;
		case 3: // 공감 -> 비공감
			emp.innerHTML = `${res.data.e}`;
			unemp.innerHTML = `${res.data.une}`;
			break;
		case 4: // 공감 취소.
			emp.innerHTML = `${res.data.e}`;
			break;
		}
	}).catch(function(err){
		console.log('err 발생 : ' + err);
	});
}

// 댓글 비공감
function clkUnemp(i_cmt){
	var emp = document.querySelector('#emp_' + i_cmt);
	var unemp = document.querySelector('#unemp_' + i_cmt);
	axios.get('/board/cmt/reg', {
		params: {
			'i_cmt':i_cmt,
			'emp':'unemp'
		}
	}).then(function(res) {
		console.log(res);
		console.log('action : ' + res.data.action);
		if (res.data.result == 0) {
			// 에러 처리
		} 
		switch(res.data.action) {
		case 1:
			unemp.innerHTML = `${res.data.une}`;
			break;
		case 2:
			emp.innerHTML = `${res.data.e}`;
			unemp.innerHTML = `${res.data.une}`;
			break;
		case 3:
			emp.innerHTML = `${res.data.e}`;
			unemp.innerHTML = `${res.data.une}`;
			break;
		case 5:
			unemp.innerHTML = `${res.data.une}`;
		break;	
		}
	}).catch(function(err){
		console.log('err 발생 : ' + err);
	});
}






































