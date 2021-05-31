package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DatabaseUtil;

public class MemoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// �޸� �� �� DB�� �����ϴ� �Լ�
	public int write (Memo memo) {	
		String sql = "INSERT INTO MEMOTABLE VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo.getUserID().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>"));
			pstmt.setString(2, memo.getMemoDivide().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>"));
			pstmt.setString(3, memo.getMemoTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>"));
			pstmt.setString(4, memo.getMemoContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
			pstmt.setString(5, memo.getTotalScore().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>"));
			pstmt.setString(6, memo.getImportantScore().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>"));
			pstmt.setString(7, memo.getMemoURL().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
			return pstmt.executeUpdate();
		} catch(Exception e) {	// ���� ó��
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return -1;	// DB ����
	}
	
	// DB���� ȭ������ �޸� ��� ���� �Լ�
	public ArrayList<Memo> getList(String memoDivide, String userID, String searchType, String search, int pageNumber) {	
		if(memoDivide.equals("��ü") ) 
			memoDivide = "";
		ArrayList<Memo> memoList = null;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if(searchType.equals("�ֽż�")) {
				sql = "SELECT * FROM MEMOTABLE WHERE userID = ? AND memoDivide LIKE ? AND CONCAT(memoTitle, memoContent) LIKE ? ORDER BY memoID DESC;";
			} else if (searchType.equals("�߿䵵��")) {
				sql = "SELECT * FROM MEMOTABLE WHERE userID = ? AND memoDivide LIKE ? AND CONCAT(memoTitle, memoContent) LIKE ? ORDER BY importantScore DESC;";
			} else if (searchType.equals("��������")) {
				sql = "SELECT * FROM MEMOTABLE WHERE userID = ? AND memoDivide LIKE ? AND CONCAT(memoTitle, memoContent) LIKE ? ORDER BY totalScore DESC;";
			}
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, "%" + memoDivide + "%");
			pstmt.setString(3, "%" + search + "%");
			rs = pstmt.executeQuery();
			memoList = new ArrayList<Memo>();
			while(rs.next()) {
				Memo memo = new Memo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
				);
				memoList.add(memo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return memoList;	// DB ����
	}
	
	// DB���� �޸� ���� �Լ�
	public int delete(String memoID) {	
		String sql = "DELETE FROM MEMOTABLE WHERE memoID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(memoID));
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return -1; 
	}
	
	public String getUserID(String memoID) {	// ����� ���̵� �о���� �Լ�
		String sql = "SELECT userID FROM MEMOTABLE WHERE memoID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(memoID));
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getString(1);
		} catch(Exception e) {	// ���� ó��
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return null; 
	}
	
	public Memo getBBS(int MemoID) {	
		String SQL = "SELECT * FROM MEMOTABLE WHERE memoID = ? ";
		Memo memo = new Memo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, MemoID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memo.setMemoID(rs.getInt(1));
				memo.setUserID(rs.getString(2));
				memo.setMemoDivide(rs.getString(3));
				memo.setMemoTitle(rs.getString(4));
				memo.setMemoContent(rs.getString(5));
				memo.setTotalScore(rs.getString(6));
				memo.setImportantScore(rs.getString(7));
				memo.setMemoURL(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memo;
	}
	
	// ������ �� ������ �޸� ���̵� ���ϱ� ���� �Լ�
	public Memo WriterCheck(int memoID) {
		String sql = "SELECT userID FROM MEMOTABLE WHERE memoID = ?";
		Memo memo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memoID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memo = new Memo(rs.getString(1));
				return memo;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return null; 
	}
	
	// ���� �Լ�
	public int update(Memo memo) {
		// Ư�� memoID�� �ش��ϴ� ���� �ٲٱ�
		String sql = "UPDATE MEMOTABLE SET memoTitle = ?, memoContent = ?, memoDivide = ?, totalScore = ?, importantScore = ?, memoURL = ? WHERE memoID = ?;";
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
//			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, memo.getMemoTitle()); // �Խñ� ����
			pstmt.setString(2, memo.getMemoContent()); // �Խñ� ����
			pstmt.setString(3, memo.getMemoDivide()); // �Խñ� �з�
			pstmt.setString(4, memo.getTotalScore()); 
			pstmt.setString(5, memo.getImportantScore());
			pstmt.setString(6, memo.getMemoURL());
			pstmt.setInt(7, memo.getMemoID()); // �Խñ� ��ȣ
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� �����߻�
	}
	
	// ���к� ���� ���ϱ�
	public int countDivide(String divide) {
		String sql = "SELECT COUNT(*) FROM memotable WHERE memoDivide = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, divide);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // �����ͺ��̽� �����߻�
	}
}