var pageNo = 1,
pageSize = 3,
tbody = document.querySelector('tbody'),
prevPageLi = document.querySelector('#prevPage'),
nextPageLi = document.querySelector('#nextPage'),
currSpan = document.querySelector('#currPage > span');

//JSON 형식의 데이터 목록 가져오기
function loadList(pn) {
	
	$.getJSON('../../app/json/board/list?pageNo=' + pn + '&pageSize=' + pageSize, 
			function (obj){
			// 서버에 받은 데이터 중에서 페이지 번호를 글로벌 변수에 저장한다.
			pageNo = obj.pageNo;

			// TR 태그를 생성하여 테이블 데이터를 갱신한다.
			tbody.innerHTML = ''; // 이전에 출력한 내용을 제거한다.
			for (data of obj.list) {
				var tr = '<tr>'
					+ '<th scope="row">' + data.no + '</th>'
					//+ '<td><a href="view.html?no=' + data.no + '">' + data.contents + '</a></td>'
					+ '<td><a class="bit-view-link" href="#" data-no="' + data.no + '">' + data.contents + '</a></td>'
					+ '<td>' + data.createdDate + '</td>'
					+ '<td>' + data.viewCount + '</td>'
					+ '</tr>';
				tbody.innerHTML = tbody.innerHTML + tr;
			}

			// 현재 페이지의 번호를 갱신한다.
			currSpan.innerHTML = String(pageNo)

			// 1페이지일 경우 버튼을 비활성화 한다.
			if (pageNo == 1) {
				prevPageLi.className = prevPageLi.className + ' disabled';
			} else {
				prevPageLi.className = prevPageLi.className.replace(' disabled', '');
			} 

			// 마지막 페이지일 경우 버튼을 비활성화 한다.
			if (pageNo == obj.totalPage) {
				nextPageLi.className = nextPageLi.className + ' disabled';
			} else {
				nextPageLi.className = nextPageLi.className.replace(' disabled', '');
			}
			document.body.dispatchEvent(new Event('loaded-list'));
});
	
} // loadList()

document.querySelector('#prevPage > a').onclick = (e) => {
	e.preventDefault();
	loadList(pageNo - 1);
};

document.querySelector('#nextPage > a').onclick = (e) => {
	e.preventDefault();
	loadList(pageNo + 1);
};

//페이지를 출력한 후 1페이지 목록을 로딩한다.
loadList(1);

document.body.addEventListener('loaded-list', () => {

	var alist = document.querySelectorAll('.bit-view-link');
	for (a of alist) {
		a.onclick = (e) => {
			e.preventDefault();
			window.location.href = 'view.html?no=' + e.target.getAttribute('data-no');
		};
	}
});











