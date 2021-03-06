package com.binhk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.binhk.model.MemberVO;
import com.binhk.model.RestautantVO;

public class Restaurant {
	public void create(RestautantVO pvo) {
		String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
		String user = "admin";
		String password = "qlsgus4613";
		StringBuffer qry = new StringBuffer()
				.append(" INSERT INTO review ")
				.append(" SET star = ?, ")
				.append(" name = ?, ")
				.append(" address = ?, ")
				.append(" review = ?, ")
				.append(" memberNum = ? ");

		String sql = qry.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, pvo.getStar());
			stmt.setString(2, pvo.getName());
			stmt.setString(3, pvo.getAddress());
			stmt.setString(4, pvo.getReview());
			stmt.setInt(5, pvo.getMemberNum());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public ArrayList<RestautantVO> read(String getaddress, String getmembernum) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<RestautantVO> al = new ArrayList<RestautantVO>();

		try {

			String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
			String user = "admin";
			String password = "qlsgus4613";
			StringBuffer qry = new StringBuffer().append(" SELECT * FROM review ")
					.append(" WHERE address = "+"'"+getaddress+"'")
					.append(" AND memberNum = " +"'"+getmembernum+"'");
			String sql = qry.toString();
			
			
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while (rs.next()) {
				RestautantVO pvo = new RestautantVO();
				pvo.setNum(rs.getInt("num"));
				pvo.setStar(rs.getInt("star"));
				pvo.setName(rs.getString("name"));
				pvo.setAddress(rs.getString("address"));
				pvo.setReview(rs.getString("review"));
				pvo.setMemberNum(rs.getInt("memberNum"));
				al.add(pvo);
			}

			
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	
	public RestautantVO anotherread(String getaddress, int num, String getmembernum){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		RestautantVO pvo = null;

		try {
			
			String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
			String user = "admin";
			String password = "qlsgus4613";
			StringBuffer qry = new StringBuffer()
					.append(" SELECT * FROM review ")
					.append(" WHERE num ="+num)
					.append(" AND memberNum = "+getmembernum)
					.append(" AND address =  ");
			String sql = qry.toString();
			Class.forName("com.mysql.jdbc.Driver");
			
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			stmt = conn.prepareStatement(sql+"'"+getaddress+"'");
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				pvo = new RestautantVO();
				pvo.setNum(rs.getInt("num"));
				pvo.setStar(rs.getInt("star"));
				pvo.setName(rs.getString("name"));
				pvo.setAddress(rs.getString("address"));
				pvo.setReview(rs.getString("review"));
				pvo.setMemberNum(rs.getInt("memberNum"));
			}
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null) conn.close();
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pvo;		
	}
	
	public void update(RestautantVO pvo, String getaddress, int num, String getmembernum) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
		String user = "admin";
		String password = "qlsgus4613";
		StringBuffer qry = new StringBuffer()				
			.append(" UPDATE review ")
			.append(" SET star = "+pvo.getStar()+",")
			.append(" review = "+"'"+pvo.getReview()+"'")
			.append(" WHERE num = "+num)
			.append(" AND memberNum = " + getmembernum)
			.append(" AND address =  ");
		
		String sql = qry.toString();
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql+"'"+getaddress+"'");
			
			stmt.executeUpdate();
			
			
		}	
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(int num, String getmembernum) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
			String user = "admin";
			String password = "qlsgus4613";
			StringBuffer qry = new StringBuffer()
					.append(" DELETE FROM review ")
					.append(" WHERE num = ? ")
					.append( " AND membernum = ?");
			String sql = qry.toString();
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, num);
			stmt.setString(2, getmembernum);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void memberjoin(MemberVO pvo) {
		String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
		String user = "admin";
		String password = "qlsgus4613";
		StringBuffer qry = new StringBuffer()
				.append(" INSERT INTO smart.member ")
				.append(" SET memberId = ?, ")
				.append(" memberPw = ?, ")
				.append(" memberName = ?, ")
				.append(" memberPhone = ?, ")
				.append(" regDate = now() ");					

		String sql = qry.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pvo.getMemberId());
			stmt.setString(2, pvo.getMemberPw());
			stmt.setString(3, pvo.getMemberName());
			stmt.setString(4, pvo.getMemberPhone());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		public int memberlogin(MemberVO pvo) {
			String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
			String user = "admin";
			String password = "qlsgus4613";
			StringBuffer qry = new StringBuffer()
					.append(" SELECT memberPw, memberNum FROM smart.member WHERE memberId = ? ");		
			Object admin = "admin";
			String sql = qry.toString();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, pvo.getMemberId());
				rs = stmt.executeQuery();
				
				
				
				if(rs.next()) {
					int num = rs.getInt("memberNum");
					pvo.setMemberNum(num);
					if(rs.getString(1).equals(pvo.getMemberPw())) {
						if(rs.getString(1).equals(admin)) {
							
							return 5;
						}
						return 1;
					}
					else {
						return 0;
					}
				}
				return -1;
				

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				
				try {
					if (conn != null)
						conn.close();
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return -2;

		
	}
		
		public ArrayList<RestautantVO> myreview(String getmembernum) throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<RestautantVO> al = new ArrayList<RestautantVO>();

			try {
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" SELECT * FROM review ")
						.append(" WHERE memberNum = "+getmembernum);
				String sql = qry.toString();
				
				Class.forName("com.mysql.jdbc.Driver");
				
				
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.prepareStatement(sql);
				
				rs = stmt.executeQuery();
				while(rs.next()) {
					RestautantVO pvo = new RestautantVO();
					pvo.setNum(rs.getInt("num"));
					pvo.setStar(rs.getInt("star"));
					pvo.setName(rs.getString("name"));
					pvo.setAddress(rs.getString("address"));
					pvo.setReview(rs.getString("review"));
					pvo.setMemberNum(rs.getInt("memberNum"));
					al.add(pvo);
				}

				conn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) conn.close();
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return al;
		}
		
		public RestautantVO anothermyreview(String getmembernum, int num){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			RestautantVO pvo = null;

			try {
				
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" SELECT * FROM review ")
						.append(" WHERE num ="+num)
						.append(" AND memberNum = "+getmembernum);
				String sql = qry.toString();
				System.out.println(sql);
				Class.forName("com.mysql.jdbc.Driver");
				
				
				conn = DriverManager.getConnection(url, user, password);
				
				
				stmt = conn.prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					pvo = new RestautantVO();
					pvo.setNum(rs.getInt("num"));
					pvo.setStar(rs.getInt("star"));
					pvo.setName(rs.getString("name"));
					pvo.setAddress(rs.getString("address"));
					pvo.setReview(rs.getString("review"));
					pvo.setMemberNum(rs.getInt("memberNum"));
				}
						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if(conn != null) conn.close();
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return pvo;		
		}

		
		public void deletemyreview(int num, String getmembernum) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" DELETE FROM smart.review ")
						.append(" WHERE num = ? ")
						.append( " AND memberNum = ?");
				String sql = qry.toString();
				
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(sql);
				
				
				conn = DriverManager.getConnection(url, user, password);
				
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, num);
				stmt.setString(2, getmembernum);
				stmt.executeUpdate();
				
				System.out.println(stmt);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if(conn != null) conn.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void updatemyreview(RestautantVO pvo, int num, String getmembernum) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			
			String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
			String user = "admin";
			String password = "qlsgus4613";
			StringBuffer qry = new StringBuffer()				
				.append(" UPDATE review ")
				.append(" SET star = "+pvo.getStar()+",")
				.append(" review = "+"'"+pvo.getReview()+"'")
				.append(" WHERE num = "+num)
				.append(" AND memberNum = " + getmembernum);
			
			String sql = qry.toString();
			
			try {
			
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection(url, user, password);
				
				stmt = conn.prepareStatement(sql);
				
				stmt.executeUpdate();
				
				
			}	
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if(conn!=null) conn.close();
					if(stmt!=null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		public ArrayList<RestautantVO> adminreview() throws Exception{
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<RestautantVO> al = new ArrayList<RestautantVO>();

			try {
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" SELECT * FROM review AS r ")
						.append(" join member as m on m.membernum = r.memberNum ");
				String sql = qry.toString();
				
				Class.forName("com.mysql.jdbc.Driver");
				
				
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					RestautantVO pvo = new RestautantVO();
					
					pvo.setNum(rs.getInt("num"));
					pvo.setStar(rs.getInt("star"));
					pvo.setName(rs.getString("name"));
					pvo.setAddress(rs.getString("address"));
					pvo.setReview(rs.getString("review"));
					pvo.setMemberNum(rs.getInt("memberNum"));
					pvo.setMemberName(rs.getString("memberName"));
					
					al.add(pvo);
				}

				conn.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) conn.close();
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return al;
		}
		
		public void adminupdate(RestautantVO pvo, int num) {
					
					Connection conn = null;
					PreparedStatement stmt = null;
					
					String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
					String user = "admin";
					String password = "qlsgus4613";
					StringBuffer qry = new StringBuffer()				
						.append(" UPDATE review ")
						.append(" SET star = "+pvo.getStar()+",")
						.append(" review = "+"'"+pvo.getReview()+"'")
						.append(" WHERE num = "+num);
					
					String sql = qry.toString();
					
					try {
					
						Class.forName("com.mysql.jdbc.Driver");
						
						conn = DriverManager.getConnection(url, user, password);
						
						stmt = conn.prepareStatement(sql);
						
						stmt.executeUpdate();
						
						
					}	
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						
						try {
							if(conn!=null) conn.close();
							if(stmt!=null) stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
		}
		
		public RestautantVO adminupdatemyreview(int num){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			RestautantVO pvo = null;

			try {
				
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" SELECT * FROM review ")
						.append(" WHERE num ="+num);
				String sql = qry.toString();
				System.out.println(sql);
				Class.forName("com.mysql.jdbc.Driver");
				
				
				conn = DriverManager.getConnection(url, user, password);
				
				
				stmt = conn.prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					pvo = new RestautantVO();
					pvo.setNum(rs.getInt("num"));
					pvo.setStar(rs.getInt("star"));
					pvo.setName(rs.getString("name"));
					pvo.setAddress(rs.getString("address"));
					pvo.setReview(rs.getString("review"));
					pvo.setMemberNum(rs.getInt("memberNum"));
				}
						
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if(conn != null) conn.close();
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return pvo;		
		}
		
		public void admindelete(int num) {
			Connection conn = null;
			PreparedStatement stmt = null;
			
			try {
				
				String url = "jdbc:mysql://13.209.224.247:3306/smart?characterEncoding=UTF-8";
				String user = "admin";
				String password = "qlsgus4613";
				StringBuffer qry = new StringBuffer()
						.append(" DELETE FROM smart.review ")
						.append(" WHERE num = ? ");
				String sql = qry.toString();
				
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(sql);
				
				
				conn = DriverManager.getConnection(url, user, password);
				
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, num);
				stmt.executeUpdate();
				
				System.out.println(stmt);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					if(conn != null) conn.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}



		
		
		


}
