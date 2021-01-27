package hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hangman {
	private ArrayList<String> wordAnimalData;
	private ArrayList<String> wordFoodData;
	private Map<String, ArrayList<String>> wordDataMap;
	private int gameCount;//알파벳 입력할 수 있는 횟수(게임 가능 횟수)
	private String hintKeyWord; //힌트 호출 키워드
	private int hintPrice;
	private String undoKeyWord; //되돌리기 호출 키워드
	private int undoPrice;
	private int winPoint;//승리 시 포인트 얼마로?
	private ArrayList<String> quizWordList;
	private ArrayList<String> wordList;
	private ArrayList<String> wrongList;
	
	public Hangman() {
		gameCount = 7;
		hintKeyWord = "hint";
		hintPrice = 10;
		undoKeyWord = "undo";
		undoPrice = 10;
		winPoint = 20;
		wordAnimalData = new ArrayList<String>();
		wordFoodData = new ArrayList<String>();
		wordDataMap = new HashMap<String, ArrayList<String>>();
		quizWordList = new ArrayList<String>(); //블랭크로 이뤄진 리스트 - 플레이어에게 보여짐
		wordList = new ArrayList<String>(); // 단어 알파벳으로 이뤄진 리스트
		wrongList = new ArrayList<String>(); //틀린 답이 입력 됨 - 플레이어에게 보여짐
	}
	
	public void addWord() {
		wordAnimalData.add("penguin");
		wordAnimalData.add("kangaroo");
		wordAnimalData.add("rabbit");
		wordAnimalData.add("camel");
		wordAnimalData.add("orangutan");
		wordAnimalData.add("quokka");
		wordAnimalData.add("dolphin");
		wordAnimalData.add("giraffe");
		wordAnimalData.add("monkey");
		wordAnimalData.add("llama");
		wordAnimalData.add("elephant");
		wordDataMap.put("animal", wordAnimalData);
		
		wordFoodData.add("hamburger");
		wordFoodData.add("pizza");
		wordFoodData.add("gambas");
		wordFoodData.add("churros");
		wordFoodData.add("steak");
		wordFoodData.add("tiramisu");
		wordFoodData.add("spaghetti");
		wordFoodData.add("curry");
		wordFoodData.add("sandwich");
		wordFoodData.add("fishandchips");
		wordFoodData.add("creambrulee");
		wordDataMap.put("food", wordFoodData);

	}
	
	public String getQuizWordByCate(String cate) {
		ArrayList<String> wordData=wordDataMap.get(cate);
		
		int random = (int)(Math.random()*10);
		String quizWord = wordData.get(random);
		return quizWord;
		
	}
	
	public Map<String, ArrayList<String>> getWordDataMap() {
		return wordDataMap;
	}

	
	public int getGameCount() {
		return gameCount;
	}

	public String getHintKeyWord() {
		return hintKeyWord;
	}

	public int getHintPrice() {
		return hintPrice;
	}

	public String getUndoKeyWord() {
		return undoKeyWord;
	}

	public int getUndoPrice() {
		return undoPrice;
	}

	public int getWinPoint() {
		return winPoint;
	}
	
	public ArrayList<String> getQuizWordList() {
		return quizWordList;
	}

	public ArrayList<String> getWordList() {
		return wordList;
	}

	public ArrayList<String> getWrongList() {
		return wrongList;
	}

}
