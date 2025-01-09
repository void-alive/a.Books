(function (win, $) {

	// $html = index.html 문서 전체
	var $html = $("html");

	// deviceSize에 pc, tablet, mobile 값 넣음 
	var deviceSize = {
		pc: 1009,
		tablet: 801,
		mobile: 800
	};

	// scrollShowHide함수
	// overflow-x : 왼쪽/오른쪽 가장자리
	// overflow-y : 위/아래 가장자리
	// html의 css가 y 축으로 넘치면 html의 너비값 리턴

	// css overflow 속성
	// visible : 넘친게 안잘림. 콘텐츠는 요소의 상자 밖에서 출력
	// hidden : 넘친게 잘리고 나머지는 안보임
	// scroll : 넘친게 잘리고 스크롤바 추가
	// auto : 위와 유사하지만 필요할 때에만 추가
	function scrollShowHide(status) {
		$html.css({ "overflow-y": status });
		return $html.width();
	}

	// sc_w1 변수는 스크롤바가 안보일때의 너비 
	// sc_w2 변수는 스크롤바가 보일때의 너비 
	// sc_w3에는 w1과 w2를 뺀 값을 넣음 
	// -> 스크롤바의 너비 
	var sc_w1 = scrollShowHide("hidden"),
		sc_w2 = scrollShowHide("scroll"),
		sc_w3 = sc_w1 - sc_w2;

	// 스크롤바가 있으면 각각의 디바이스 기준 너비에서 sc_3을 뺀 값을 넣음
	if (sc_w3 > 0) {
		deviceSize.pc = deviceSize.pc - sc_w3;
		deviceSize.tablet = deviceSize.tablet - sc_w3;
		deviceSize.mobile = deviceSize.mobile - sc_w3;
	}

	// 확인용 
	// console.log(deviceSize.pc);

	// window 창의 크기를 바꾸면 함수 실행
	$(win).on("resize", function () {

		// w_size는 window 창의 너비
		var w_size = $(win).width();

		// 만약에 window 창의 너비가 pc 너비보다 크거나 같고
		// index.html 파일이 pc 클래스를 가지고 있지 않다면
		// mobile과 tablet 클래스를 없애고 pc 클래스 추가
		// 스크롤을 보이게 함 
		if (w_size >= deviceSize.pc && !$("html").hasClass("pc")) {
			$html.removeClass("mobile tablet").addClass("pc");
			scrollShowHide("scroll");
		}

		// window창의 너비가 pc보다 작고 table보다 크고 
		// index.html에 tablet 클래스가 없다면
		// mobile pc 클래스를 지우고 tablet 클래스 넣기
		// 스크롤을 보이게 함
		else if (w_size < deviceSize.pc && w_size >= deviceSize.tablet
			&& !$("html").hasClass("tablet")) {
			$html.removeClass("mobile pc").addClass("tablet");
			scrollShowHide("scroll");
		}

		// window창의 크기가 mobile보다 작고 index.html에 tablet 클래스가 없다면
		// pc tablet 클래스를 지우고 mobile 클래스 넣기
		// menu_pos에는 mobile-menu-wrap 클래스의 왼쪽 공백을 정수형으로 바꿔서 넣기
		// mewnu_pos가 0보다 크다면 (왼쪽 공백이 있다면) 스크롤은 없애기
		else if (w_size <= deviceSize.mobile && !$html.hasClass("mobile")) {
			$html.removeClass("pc tablet").addClass("mobile");
			var menu_pos = parseInt($(".mobile-menu-wrap").css("left"));
			if (menu_pos >= 0) {
				scrollShowHide("hidden");
			};
		};
	});

	// 
	$(function () {
		// window 창이 크기가 바뀌면 
		// trigger : 강제 실행. 
		$(win).trigger("resize");
		
		// pc 클래스의 a와 tablet 클래스의 a에 마우스를 올리거나 tab키로 포커스가 되면
		// gnbPlay() 함수 실행
		$(document).on("mouseover focus", ".pc #gnb>ul>li>a, .tablet #gnb>ul>li>a", gnbPlay);
		// mobile클래스의 a (no-sub 제외)를 누르면 gnbPlay() 함수 실행
		$(document).on("click", ".mobile #gnb>ul>li:not(.no-sub)>a", gnbPlay);

		// 함수 gnbPlay()
		function gnbPlay() {
			// $ts변수에 이 객체 (사용자가 누르는 버튼이나 다른 뭔가) 대입
			var $ts = $(this);

			// 만약에 index.html 파일에 mobile 클래스가 있다면
			// mobile 클래스의 a 의 on 클래스를 없앤다
			// 그리고 #gnb의 ul을 보이게 한다. 그리고 300px 올린다
			if ($("html").hasClass("mobile")) {
				$(".mobile $gnb>ul>li>a").removeClass("on");
				$("#gnb ul ul:visible").slideUp(300);

				// 만약에 이 요소의 다음 요소가 숨겨졌다면
				// 이 요소에 on 클래스를 더한다
				// 그리고 다음 요소는 stop(true,true) 하고 300px 내린다

				// stop : 요소에 적용한 애니메이션 정지. (clearQueue, finish);
				// (true, true) : 큐에서 대기 중인 모든 애니메이션 제거. 진행 중인 애니메이션 강제 종료

				// 큐 : 선입선출인 메모리 구조. 다음 애니메이션이 저장되어 있음 
				if ($ts.next().is(":hidden")) {
					$ts.addClass("on");
					$ts.next().stop(true, true).slideDown(300);
				}
			}
			// 혹은
			// #gnb ul이 보인다면 300px만큼 올린다
			// 그리고 이 요소의 다음 요소는 0.3초동안 끄집어 내린다
			else {
				$("#gnb ul ul:visible").slideUp(300);
				$ts.next().stop(true, true).slideDown(300);
			}
		}

		// pc와 태블릿 환경에서 마우스를 gnb 영역 밖으로 이동하면
		// 펼쳐진 메뉴를 닫고 on 클래스 제거 
		// 문서에서 마우스를 내리면 pc와 table클래스의 #gnb는 gnbleave 함수를 실행한다
		$(document).on("mouseleave", ".pc #gnb, .table #gnb", gnbleave);

		// #gnb의 ul이 보이면 0.3초동안 위로 접는다
		// #gnb의 a는 on 클래스를 없앤다
		function gnbleave() {
			$("#gnb ul ul:visible").slideUp(300);
			$("#gnb>ul>li>a").removeClass("on");
		}

		// mobile-menu-open 버튼을 누르면 
		// mobile-menu-wrap 클래스가 0.2초동안 좌측에 나온다.
		// 그리고 scroll바를 숨긴다
		$(".mobile-menu-open button").on("click", function () {
			$(".mobile-menu-wrap").animate({
				"left": "0px"
			}, 200);
			scrollShowHide("hidden");
		});

		// mobile-menu-close 버튼을 누르면 
		// mobile-menu-wrap 클래스가 0.2초동안 좌측 -1000px 으로 이동한다.
		// 그리고 scroll바를 보이게 한다 
		// 마지막으로 gnbleave()함수를 실행한다
		$(".mobile-menu-close button").on("click",function(){
			$(".mobile-menu-wrap").animate({
				"left" : "-1000px"
			},200);
			scrollShowHide("scroll");
			gnbleave();
		});
	});
}(window, jQuery));
