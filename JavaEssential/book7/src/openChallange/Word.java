package openChallange;

import java.util.HashMap;

public class Word {
  String eng;
  String kor;

  public Word(String eng, String kor) {
    this.eng = eng;
    this.kor = kor;
  }

//  Object 클래스의 toString() 호출을 방지하기 위해 오버라이딩함
//  오브젝트 클래스의 toString()에는 주소값 같은 것 밖에 없음
  @Override
  public String toString() {
    return eng;
  }

  public String getEng() {
    return eng;
  }
  public String getKor() {
    return kor;
  }
}
