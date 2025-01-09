import java.util.Scanner;

public class RSP {
  //  컴퓨터랑 내가 가위바위보를 함
//  가위는 1, 보는 2, 바위는 3
//  나는 숫자를 입력해서 낼걸 정하고
//  컴퓨터는 랜덤하게 낼걸 고름
//  그리고 가위바위보 게임을 함
  public static void main(String[] args) {
//    변수 선언, 스캐너 객체 만듦
    int player = 0;
    int com = 0;
    Scanner sc = new Scanner(System.in);

//    참이면 계속해서 반복
    while (true) {
      System.out.print("가위(1), 바위(2), 보(3), 끝내기(4) >> ");
//      나는 내가 넣은 값을 가지고 컴퓨터는 1~3의 랜덤 값을 가짐
      player = sc.nextInt();
      com = (int)((Math.random()*3)+1);

      if (player == 4) {
        break;
      }

      switch (player) {
        case 1:
          switch (com) {
            case 1:
              System.out.println("사용자 가위 : 컴퓨터 가위");
              System.out.println("비겼습니다.");
              break;
            case 2:
              System.out.println("사용자 가위 : 컴퓨터 바위");
              System.out.println("사용자가 졌습니다.");
              break;
            case 3:
              System.out.println("사용자 가위 : 컴퓨터 보");
              System.out.println("사용자가 이겼습니다.");
              break;
          }
          break;
        case 2:
          switch (com) {
            case 1:
              System.out.println("사용자 바위 : 컴퓨터 가위");
              System.out.println("사용자가 이겼습니다.");
              break;
            case 2:
              System.out.println("사용자 바위 : 컴퓨터 바위");
              System.out.println("비겼습니다.");
              break;
            case 3:
              System.out.println("사용자 바위 : 컴퓨터 보");
              System.out.println("사용자가 졌습니다.");
              break;
          }
          break;
        case 3:
          switch (com) {
            case 1:
              System.out.println("사용자 보 : 컴퓨터 가위");
              System.out.println("사용자가 졌습니다.");
              break;
            case 2:
              System.out.println("사용자 보 : 컴퓨터 바위");
              System.out.println("사용자가 이겼습니다.");
              break;
            case 3:
              System.out.println("사용자 보 : 컴퓨터 보");
              System.out.println("비겼습니다.");
              break;
          }
          break;
      }
    }
  }
}
