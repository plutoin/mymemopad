package tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import memo.Memo;
import user.User;
import util.DatabaseUtil;


public class TabDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// �ɼ� ������ �ҷ��� �� ����Ʈ
	public ArrayList<Tab> getList(String userID, String tabName) {	
		ArrayList<Tab> tabList = null;
		String sql = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, tabName);
			rs = pstmt.executeQuery();
			tabList = new ArrayList<Tab>();
			while(rs.next()) {
				Tab tab = new Tab(
						rs.getString(1),
						rs.getString(2)
				);
				tabList.add(tab);
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
		return tabList;	// DB ����
	}
	
	public void tabList(String userID) {
	      // db���� ���� ���� ���̺� ����ϱ�
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
				conn = DatabaseUtil.getConnection();
			    String sql = "SELECT tabName FROM TAB WHERE userID = ? GROUP BY tabName ORDER BY tabName;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				rs = pstmt.executeQuery();
	       while (rs.next()) {
	    	   String tabName = rs.getString("tabName");
	        }
	      } catch (Exception e) {
	    	  System.out.println(e.getMessage());
	      } finally {
	       try {
	        if (rs != null)
	        	rs.close();
	        if (pstmt != null)
	        	pstmt.close();
	        if (con != null)
	        	con.close();
	       } catch (Exception e) {
	    	   System.out.println(e.getMessage());
	       }

	      }
	}
	
	// ī�װ� �߰� �Լ�
	public int add (String userID, String tabName) {	
		String sql = "INSERT INTO TAB VALUES(?, ?);";
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, tabName);
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
	
	// ī�װ� ���� �Լ�
	public int delete(String userID, String tabName) {	
		String sql = "DELETE FROM TAB WHERE userID = ? AND tabName = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, tabName);
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
	
	// ī�װ� �̸� �ҷ����� �Լ�
	public String getTabName(String tabName) {	
		String sql = "SELECT tabName FROM TAB WHERE tabName = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tabName);
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
	
}
