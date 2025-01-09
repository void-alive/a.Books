package openChallange;

import java.util.*;

public class WordQuiz {
  public static void main(String[] args) {
    Vector<Word> v = new Vector<>();
    Scanner sc = new Scanner(System.in);
    v.add(new Word("apple", "사과"));
    v.add(new Word("banana", "바나나"));
    v.add(new Word("cat", "고양이"));
    v.add(new Word("dog", "강아지"));
    v.add(new Word("eraser", "지우개"));
    v.add(new Word("foot", "발"));
    v.add(new Word("giraffe", "기린"));
    v.add(new Word("high", "높은"));
    v.add(new Word("ice-cream", "아이스크림"));
    v.add(new Word("juice", "주스"));
    v.add(new Word("king", "왕"));
    v.add(new Word("love", "사랑"));
    v.add(new Word("moon", "달"));
    v.add(new Word("nice", "좋은"));
    v.add(new Word("octopus", "문어"));
    v.add(new Word("pretty", "예쁜"));
    int randomQuiz = 0;
    int myNumber = 0;

    System.out.println("영어 어휘 테스트를 시작합니다. 1~4 외 다른 입력 시 종료합니다.");
    while (true) {
      randomQuiz = (int) ((Math.random() * v.size()));

//      랜덤 문제 내기
      Word word = v.get(randomQuiz);
      System.out.println(word + "?");

//      객관식 답 출력
//      배열?
      String options[] = new String[4];
      options[0] = word.getKor();

      for (int i = 1; i < options.length; i++) {
        while (true) {
          int randomIndex = (int) (Math.random() * v.size());
          String randomKorean = v.get(randomIndex).getKor();

          boolean isDuplicate = false;
          for (int j = 0; j < i; j++) {
            if (options[j].equals(randomKorean)) {
              isDuplicate = true;
              break;
            }
          }
          if (!isDuplicate) {
            options[i] = randomKorean;
            break;
          }
        }
      }

      Collections.shuffle(Arrays.asList(options));

      for (int i = 0; i < options.length; i++) {
        System.out.print("(" + (i + 1) + ") " + options[i] + " ");
      }

      System.out.print(":> ");
      myNumber = sc.nextInt();

//      맞으면 excellent, 틀리면 no 출력
      if (myNumber == 0) {
        System.out.println("프로그램을 종료합니다...");
        break;
      }
      if (options[myNumber - 1].equals(word.getKor())) {
        System.out.println("Excellent !!");
      } else {
        System.out.println("no. !!");
      }
    }
  }
}
