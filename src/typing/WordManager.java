package typing;
 
import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
	import java.util.Vector;

 public class WordManager {
	    private Vector<VisibleWord> wordPool;           // a total of words
	    private Vector<String> exercisePool;       // words for exercise

	    // constructor
	    public WordManager() {	
	        wordPool = new Vector<>();
	        exercisePool = new Vector<>();
	     }

	    // constructor, size indicates the initial size of vector
	    public WordManager(int size) {
	    	wordPool = new Vector<>(size);
	    	exercisePool = new Vector<>(size);
	    }

	    // to insert new VisibleWord object to wordPool vector.
	    // if the insertion is successfully completed, return true. otherwise return false.
	    public boolean insert(String sentence) {
	    	VisibleWord visibleWord = new VisibleWord();
	    	visibleWord.setVisibleWord(sentence);
	    	
	    	if(sentence != null) {
	    		wordPool.add(visibleWord);
	    		System.out.println("Data insertion is completed!!");
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }

	    // to divide sentence to words, and words are stored in String array.
	    // returns String array
	    public String[] divideWords(String sentence) {
	    	String wordSpace [];
			wordSpace = sentence.split("\t|\n");
	    	return wordSpace; 
	    }
	    
	    

	    // to load words from the file and insert new VisibleWord object to wordPool vector.
	    // if the insertion is successfully completed, return true. otherwise return false.
	    public boolean load(String filename) throws IOException{ 
			int i = 0;
			String contentOfFile = "";
			String wordSpace [];
			String currentDirectory = System.getProperty("user.dir");
			File fileLoad = null;
			FileReader fileReader = null;
			VisibleWord visibleWord = new VisibleWord(); 
			
			filename = currentDirectory + "\\" + filename;

			fileLoad = new File(filename);
			
			try {
				fileReader = new FileReader(fileLoad);
				while((i=fileReader.read())!=-1) { 
					contentOfFile = contentOfFile + (char) i;		
				}	
				wordSpace = divideWords(contentOfFile);
				
				for(i = 0 ; i < wordSpace.length ; i++) {
					if(wordSpace[i] != "" ) {
						visibleWord = new VisibleWord(); 
						visibleWord.insert(wordSpace[i].trim());
						wordPool.add(visibleWord);
					}
				} 	 
				System.out.println("File load is completed!!");	 
				
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
				System.out.println("File can't find");
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("File load is fail!");
			}finally {
				if(fileReader != null) 
					fileReader.close();
			} 			 
			
			return false;
		} /* Load =================================================*/

	    // if the value of originalWord is findWord, replace the value of visibleWord to replaceWord
	    // return the number of replaced words.
	    // you have to use Iterator for searching the vector
	    public int replace(String findWord, String replaceWord) {
	    	int replaceCount = 0;
	    	for (VisibleWord word : wordPool) {
	    		 if(word.getVisibleWord().equals(findWord.trim())) {
	    			 replaceCount ++;
	    			 word.setVisibleWord(replaceWord);
	    		 }	
	    	 }
	    	if (replaceCount > 0) {
	    		return replaceCount;
	    	}else
	    		return 0;
	    }

	    // to delete Visible object whose originalWord is word
	    // return the number of deleted words.
	    public int delete(String deleteWord) {
	    	VisibleWord visibleWord = new VisibleWord(); 
	    	int deleteCount = 0;
	    	  for (int i = 0; i < wordPool.size(); i++) {
	    	        if (wordPool.get(i).getVisibleWord().equals(deleteWord.trim())) {
	    	            deleteCount++;
	    	            visibleWord.initialize();
	    	            wordPool.get(i).initialize();
	    	        }
	    	    }
	    	  if (deleteCount > 0) {
	    		return deleteCount;
	    	}else
	    		return 0;
	    }

	    // to set visibleWord value to originalWord value for all words
	    public void restore() {
	    	VisibleWord visibleWord = new VisibleWord(); 
	    	String originalWord;
			for(int i = 0 ; i < wordPool.size() ; i++) {
				originalWord = wordPool.get(i).getOriginalWord(); 
				visibleWord.setVisibleWord(originalWord);
				wordPool.get(i).setVisibleWord(originalWord);;
				
			}
	    } /* restore =========================================== */

	    // to print all data
	    // you have to use size and get method of Vector class
	    public void print() {
	    	int size = 0;
	    	 for (VisibleWord word : wordPool) {
	    		 if(word.getVisibleWord() != null) {
	    	        System.out.print(word.getVisibleWord()+" ");
	    	        size ++;
	    		 }
	    	    } 
	    	 System.out.println();
	           
	    	 System.out.println(size+" Word(s) are stored as follows");
	    }

	    
	    
	    
	    /* 
	        wordPool 벡터로 문제를 만들어 타이핑 연습을 합니다
			흰색 공간의 길이는 무작위로 결정되며, 길이는 반올림됩니다.
			문자열에 단어와 공백이 포함된 문자열을 반환합니다		
	     */
	    public void makeExercise(int cntOfWord, int widthOfLine) {
	    	Random random = new Random();    
    		
	    	int getRandomNum = 0;    		
    		int randomWidth;
    		String empty = "";
    		String randomWord ="";
	    	for (int i = 1; i <= cntOfWord; i++) {   	
	        	getRandomNum = random.nextInt(wordPool.size()); 
	        	randomWord = wordPool.get(getRandomNum).getVisibleWord();
	        	randomWidth= random.nextInt(widthOfLine - randomWord.length());
	        	
	        	for(int j = 0 ; j < randomWidth ; j++) {
	        		empty += " ";
	        	}
	    		exercisePool.add(empty+randomWord);
	    	}    	
	    
	    	
	    }

	    // check whether the answer is contained in exercisePool vector
	    // if the answer is included, replace the word of exercisePool to white space with equal size
	    // return the number of matched words
	 // 정답이 pool vector에 포함되어 있는지 확인합니다
	 // 답이 포함되어 있으면 운동 단어를 바꿉니다. 같은 크기의 흰색 공간으로 풀을 바꿉니다
	 // 일치된 단어의 수를 반환합니다

	    public int checkAnswer(String answer) {
	    	int rightWordCnt = 0;
	    	for (int i = 0; i < exercisePool.size(); i++) {
    	        if (exercisePool.get(i).trim().equals(answer)) {
    	        	rightWordCnt++;
    	        	exercisePool.set(i,"");
    	        }
    	    }
	    	return rightWordCnt;
	    }

	    // make a sentence from exercisePool vector for displaying the exercise
	    // return the display sentence
	    
	 // 연습문제를 표시하기 위해 pool 벡터로 문장을 만듭니다
	 // 표시 문장을 반환합니다
	    public String displayExercise() {
	     	String displayWord = "";
	    	for(int i = 0; i < exercisePool.size(); i++) {
	    		displayWord += exercisePool.get(i) + "\n";
	    	}   	
	    	return displayWord;    
	    }

	    // run exercise using makeExercise, checkAnswer, and displayExercise method until user enter all correct words
	 // 사용자가 올바른 단어를 모두 입력할 때까지 "Make Practice, Check Answer and display Practice" 방법을 사용하여 연습을 실행합니다
	    public void runExercise(Scanner sc, int cntOfWord, int widthOfLine) {
	    	exercisePool = new Vector<String>(cntOfWord);
	    	int rightWordCnt = 0;
	    	String userAnswer;
	    	
	    	makeExercise(cntOfWord, widthOfLine);
	    	while(rightWordCnt != cntOfWord) {
	    		System.out.println(displayExercise());
		    	System.out.print("Enter a word: ");
		    	userAnswer = sc.next();
		    	rightWordCnt += checkAnswer(userAnswer);
		    	
		    	System.out.println(rightWordCnt + " out of " + cntOfWord + " words are correct");
	    	}
	    	
	    	exercisePool.clear();    
	    }

	    // return VisibleWord object which is stored at 'index' in Vector
	    public VisibleWord getData(int index) {
	    	return wordPool.get(index); 
	    }

	    // return VisibleWord object which is recently stored in Vector
	    public VisibleWord getLastData() {
	    	VisibleWord visibleWord = new VisibleWord();
	    	String lastData;
	    	lastData = wordPool.lastElement().getVisibleWord();
	    	visibleWord.setVisibleWord(lastData);
			return visibleWord; 
	    } 
	

}
 
