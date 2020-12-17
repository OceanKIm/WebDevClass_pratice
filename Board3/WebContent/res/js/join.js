function joinChk() {
	var frm = document.querySelector('#frm');	
	var eleId = frm.user_id;
	
	var reUserId = /^[A-Za-z0-9+]*$/;
	if(!reUserId.test(eleId.value)) {
		alert('Check you id please');
		eleId.focus();
		return false;
	}
	
	var pw = frm.user_pw;
	var pw_chk = frm.user_pw_chk
	if(pw.value !== pw_chk.value) {
		alert('Check you password please');
		pw.focus();
		return false;
	}
	
	var eleNm = frm.nm;
	var reNm = /^[가-힣]*$/;
	if(!reNm.test(eleNm.value)) {
		alert('Name is only Korean.');
		eleNm.focus();
		return false;
	}
	
}