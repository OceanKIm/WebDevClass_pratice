'use strict';

function chkEmptyEle(ele, eleNm) {
	if (ele.value == '') {
		alert(eleNm + '을(를) 입력해 주세요');
		ele.focus();
		return ture;
	}
	return false;
}



