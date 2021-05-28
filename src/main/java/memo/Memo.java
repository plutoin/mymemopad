package memo;

public class Memo {
	int memoID;
	String userID;	// ����� ���̵�
	String memoDivide;	// �׷� �з�
	String memoTitle;	// �޸� ����
	String memoContent;	// �޸� ����
	String totalScore;	// ����
	String importantScore;	// �߿䵵
	String memoURL;
	
	public Memo() {
		
	}
	
	public Memo(int memoID, String userID, String memoDivide, String memoTitle, String memoContent,
			String totalScore, String importantScore, String memoURL) {
		super();
		this.memoID = memoID;
		this.userID = userID;
		this.memoDivide = memoDivide;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
		this.totalScore = totalScore;
		this.importantScore = importantScore;
		this.memoURL = memoURL;
	}
	
	public Memo(String userID) {
		this.userID = userID;
	}
	
	public int getMemoID() {
		return memoID;
	}

	public void setMemoID(int memoID) {
		this.memoID = memoID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMemoDivide() {
		return memoDivide;
	}

	public void setMemoDivide(String memoDivide) {
		this.memoDivide = memoDivide;
	}

	public String getMemoTitle() {
		return memoTitle;
	}

	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}

	public String getMemoContent() {
		return memoContent;
	}

	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getImportantScore() {
		return importantScore;
	}

	public void setImportantScore(String importantScore) {
		this.importantScore = importantScore;
	}
	
	public String getMemoURL() {
		return memoURL;
	}

	public void setMemoURL(String memoURL) {
		this.memoURL = memoURL;
	}
	
	

	@Override
	public String toString() {
		return "Memo [memoID=" + memoID + ", userID=" + userID + ", memoDivide=" + memoDivide + ", memoTitle="
				+ memoTitle + ", memoContent=" + memoContent + ", totalScore=" + totalScore + ", importantScore="
				+ importantScore + "]";
	}

	
}