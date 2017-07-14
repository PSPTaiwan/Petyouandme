package com.dateitem.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Clob;

public class DateItemJDBCDAO implements DateItemDAO_interface{

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "petym";
	private static final String PASSWORD = "123456";
	
	
	private static final String INSERT_STMT = "INSERT INTO DATEITEM(DATEITEMNO,SELLERNO,RESTLISTNO,"
			+ "DATEITEMTITLE,DATEITEMIMG,DATEITEMTEXT,DATEITEMTIME,DATEMEETINGTIME,DATEITEMLOCATE,"
			+ "DATEITEMPEOPLE,HASMATE,DATEITEMPRICE,DATEITEMSTATUS,DATEITEMVIEWER,BUYERNO,"
			+ "ISQRCCHECKED,BUYERREP,SELLERREP)"
			+ " VALUES(DATEITEMNO_SQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE DATEITEM SET DATEITEMNO = ?, SELLERNO = ?, RESTLISTNO = ?, "
			+ "DATEITEMTITLE = ?, DATEITEMIMG = ?, DATEITEMTEXT = ?, DATEITEMTIME = ?, DATEMEETINGTIME = ?, "
			+ "DATEITEMLOCATE = ? ,DATEITEMPEOPLE = ? , HASMATE =?, DATEITEMPRICE =? , DATEITEMSTATUS=? ,"
			+ "DATEITEMVIEWER=?, BUYERNO=?, ISQRCCHECKED=?, BUYERREP=? , SELLERREP=? WHERE PETNO =¡@?";
	private static final String DELETE_STMT = "DELETE FROM DATEITEM WHERE DATEITEMNO = ?";
	private static final String FIND_BY_PK = "SELECT * FROM DATEITEM WHERE DATEITEMNO = ?";
	private static final String GET_ALL = "SELECT * FROM DATEITEM";
	
	
	
	@Override
	public void add(DateItem dateItem) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt=con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, dateItem.getSellerNo());
			pstmt.setInt(2, dateItem.getRestListNo());
			pstmt.setString(3, dateItem.getDateItemTitle());
			Blob blob=con.createBlob();
			blob.setBytes(1, dateItem.getDateItemImg());
			pstmt.setBlob(4, blob);
			Clob clob=con.createClob();
			clob.setString(1, dateItem.getDateItemText());
			pstmt.setClob(5, clob);
			pstmt.setDate(6, dateItem.getDateItemTime());
			pstmt.setDate(7, dateItem.getDateMeetingTime());
			pstmt.setString(8, dateItem.getDateItemLocate());
			pstmt.setInt(9, dateItem.getDateItemPeople());
			pstmt.setBoolean(10, dateItem.getHasMate());
			pstmt.setInt(11, dateItem.getDateItemPrice());
			pstmt.setInt(12, dateItem.getDateItemStatus());
			pstmt.setInt(13, dateItem.getDateItemViewer());
			pstmt.setInt(14, dateItem.getBuyerNo());
			pstmt.setBoolean(15, dateItem.getIsQRCChecked());
			pstmt.setInt(16, dateItem.getBuyerRep());
			pstmt.setInt(17, dateItem.getSellerRep());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(DateItem dateItem) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt=con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, dateItem.getDateItemNo());
			pstmt.setInt(2, dateItem.getSellerNo());
			pstmt.setInt(3, dateItem.getRestListNo());
			pstmt.setString(4, dateItem.getDateItemTitle());
			Blob blob=con.createBlob();
			blob.setBytes(1, dateItem.getDateItemImg());
			pstmt.setBlob(5, blob);
			Clob clob=con.createClob();
			clob.setString(1, dateItem.getDateItemText());
			pstmt.setClob(6, clob);
			pstmt.setDate(7, dateItem.getDateItemTime());
			pstmt.setDate(8, dateItem.getDateMeetingTime());
			pstmt.setString(9, dateItem.getDateItemLocate());
			pstmt.setInt(10, dateItem.getDateItemPeople());
			pstmt.setBoolean(11, dateItem.getHasMate());
			pstmt.setInt(12, dateItem.getDateItemPrice());
			pstmt.setInt(13, dateItem.getDateItemStatus());
			pstmt.setInt(14, dateItem.getDateItemViewer());
			pstmt.setInt(15, dateItem.getBuyerNo());
			pstmt.setBoolean(16, dateItem.getIsQRCChecked());
			pstmt.setInt(17, dateItem.getBuyerRep());
			pstmt.setInt(18, dateItem.getSellerRep());
			pstmt.setInt(19, dateItem.getDateItemNo());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void delete(int dateItemNo) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt=con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, dateItemNo);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public DateItem findByPk(int dateItemNo) {
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		DateItem dateItem=null;
		
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt=con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, dateItemNo);
			rs=pstmt.executeQuery();
			while(rs.next()){
				dateItem=new DateItem();
				dateItem.setDateItemNo(rs.getInt("dateItemNo"));
				dateItem.setSellerNo(rs.getInt("sellerNo"));
				dateItem.setRestListNo(rs.getInt("restListNo"));
				dateItem.setDateItemTitle(rs.getString("dateItemTitle"));
				dateItem.setDateItemImg(rs.getBytes("dateItemImg"));
				dateItem.setDateItemText(rs.getString("dateItemText"));
				dateItem.setDateItemTime(rs.getDate("dateItemTime"));
				dateItem.setDateMeetingTime(rs.getDate("dateMeetingTime"));
				dateItem.setDateItemLocate(rs.getString("dateItemLocate"));
				dateItem.setDateItemPeople(rs.getInt("dateItemPeople"));
				dateItem.setHasMate(rs.getBoolean("hasMate"));
				dateItem.setDateItemPrice(rs.getInt("dateItemPrice"));
				dateItem.setDateItemStatus(rs.getInt("dateItemStatus"));
				dateItem.setBuyerNo(rs.getInt("buyerNo"));
				dateItem.setIsQRCChecked(rs.getBoolean("isQRCChecked"));
				dateItem.setBuyerRep(rs.getInt("buyerRep"));
				dateItem.setSellerRep(rs.getInt("SellerRep"));		
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return dateItem;
	}

	@Override
	public List<DateItem> getAll() {
		List<DateItem> dateItemList = new ArrayList<>();
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			pstmt=con.prepareStatement(GET_ALL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				DateItem dateItem=new DateItem();
				dateItem.setDateItemNo(rs.getInt("dateItemNo"));
				dateItem.setSellerNo(rs.getInt("sellerNo"));
				dateItem.setRestListNo(rs.getInt("restListNo"));
				dateItem.setDateItemTitle(rs.getString("dateItemTitle"));
				dateItem.setDateItemImg(rs.getBytes("dateItemImg"));
				dateItem.setDateItemText(rs.getString("dateItemText"));
				dateItem.setDateItemTime(rs.getDate("dateItemTime"));
				dateItem.setDateMeetingTime(rs.getDate("dateMeetingTime"));
				dateItem.setDateItemLocate(rs.getString("dateItemLocate"));
				dateItem.setDateItemPeople(rs.getInt("dateItemPeople"));
				dateItem.setHasMate(rs.getBoolean("hasMate"));
				dateItem.setDateItemPrice(rs.getInt("dateItemPrice"));
				dateItem.setDateItemStatus(rs.getInt("dateItemStatus"));
				dateItem.setBuyerNo(rs.getInt("buyerNo"));
				dateItem.setIsQRCChecked(rs.getBoolean("isQRCChecked"));
				dateItem.setBuyerRep(rs.getInt("buyerRep"));
				dateItem.setSellerRep(rs.getInt("SellerRep"));	
				dateItemList.add(dateItem);		
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return dateItemList;
	}
	
}
