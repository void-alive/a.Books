$(function () {
  // main-visual-slide 클래스에 박스 슬라이더(슬라이드 효과 제공 플러그인)를 넣는다
  // 자동 전환하고, 2초에 한번씩 바뀌고, 슬라이드에 마우스를 올리면 중지된다
  // 재생, 정지 버튼을 만든다(autoControls) 그리고 결합한다 (autoControlsCombine)
  $(".main-visual-slide").bxSlider({
    auto: true,
    pause: 2000,
    autoHover: true,
    autoControls: true,
    autoControlsCombine: true
  });

  // notice-tab-wrap의 h4와 a를 누르면 tabmenu 함수 실행
  $("#notice-tab-wrap h4 a").on("click", tabmenu);

  function tabmenu(e) {
    // <a> 요소에 리크된 페이지로 이동하는 기본 이벤트 차단 
    e.preventDefault();

    // %ts : 현재 클릭한 요소 (jquery 객체)
    // next 변수에 내가 누르고 있는 객체의 부모의 다음 형제 요소를 대입한다
    var $ts = $(this);
    var $next = $ts.parent().next();

    // 만약에 내가 누르고 있는 객체의 부모의 다음 형제 요소가 숨겨져있다면
    // notice-tab-wrap에서 on클래스를 없앤다
    // ts에 on 클래스를 추가한다
    // notice-tab-wrap의 보이는 div를 숨긴다
    // 다음 것을 보여준다
    if ($next.is(":hidden")) {
      $("#notice-tab-wrap h4 a").removeClass("on");
      $ts.addClass("on");
      $("#notice-tab-wrap > div:visible").hide();
      $next.show();
    }
  }

  // 클래스가 grid인 요소를 isotope (지정된 컨테이너 내부의 요소를 정렬하거나 필터링)한다
  // grid-item 클래스를 선택하고 정렬한다
  // layoutmode는 firRows(요소 행단위 정렬, 꽉 채우기)
  $(".grid").isotope({
    itemSelector: '.grid-item',
    layoutMode: 'fitRows'
  });
});