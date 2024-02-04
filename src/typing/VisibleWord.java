package typing;

 
public class VisibleWord extends OriginalWord{
	private String visibleWord;

	// constructor
	public VisibleWord() {  
		super();
		this.visibleWord = "";
	}

	// constructor
	public VisibleWord(String originalWord) {
		super(originalWord); 
        this.visibleWord = originalWord;
	}

	// constructor
	public VisibleWord(String originalWord, String visibleWord) {
		super(originalWord);  // Calls the constructor of OriginalWord with a parameter
        this.visibleWord = visibleWord;
	}
	

	// to return visibleWord
	public String getVisibleWord() {
		return visibleWord;
	}

	// to set visibleWord
	public void setVisibleWord(String visibleWord) {
		this.visibleWord = visibleWord;
	}
	
	// to set originalWord and visibleWord simultaneously
	public void insert(String word) {
		setVisibleWord(word);
		setOriginalWord(word);
		
	}
	
	// if otherWord is same to visibleWord, return true.
	// otherwise, return false. 
	public boolean isSameVisibleWord(String otherWord) {
		if(visibleWord.equals(otherWord)) 
			return true;
		else	
			return false;
	}
	
	// copy originalWord and visibleWord from otherWord object
	public void copyFrom(VisibleWord otherWord) {

	}
	
	// initialize originalWord and visibleWord 
	public void initialize() {
		setVisibleWord(null);
		setOriginalWord(null);
	}

	// to return string for this object. The format is as follows.
	// originalWord = originalWord value, visibleWord = visibleWord value
	public String toString() {
		return visibleWord;
	}
}