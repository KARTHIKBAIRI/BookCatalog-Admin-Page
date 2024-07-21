package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.bookcatalog;

public class bookservice {
	private Connection conn;

	public bookservice(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addbook(bookcatalog bc) {
		boolean f = false;
		try {
			String sql = "insert into books(id,title,author,genre) values (?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, bc.getId());
			pmst.setString(2, bc.getTitle());
			pmst.setString(3, bc.getAuthor());
			pmst.setString(4, bc.getGenre());
			int i = pmst.executeUpdate();
			if(i>0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<bookcatalog> fetchall(){
		List<bookcatalog> bs = new ArrayList<bookcatalog>();
		bookcatalog bc = null;
		try {
			String sql = "select * from books";
			PreparedStatement pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				bc = new bookcatalog();
				bc.setId(rs.getInt(1));
				bc.setTitle(rs.getString(2));
				bc.setAuthor(rs.getString(3));
				bc.setGenre(rs.getString(4));
				bs.add(bc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bs;
	}
	
	public boolean deletebook(int id) {
		boolean f = false;
		try {
			String sql = "delete from books where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			int i = pmst.executeUpdate();
			if(i>0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean updatebook(bookcatalog bc) {
		boolean f = false;
		try {
			String sql = "update books set title =?, author =?, genre =? where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, bc.getTitle());
			pmst.setString(2, bc.getAuthor());
			pmst.setString(3, bc.getGenre());
			pmst.setInt(4, bc.getId());
			int i = pmst.executeUpdate();
			if(i>0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public bookcatalog getbyid(int id) {
		bookcatalog bc = null;
		try {
			String sql = "select * from books where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				bc = new bookcatalog();
				bc.setId(rs.getInt(1));
				bc.setTitle(rs.getString(2));
				bc.setAuthor(rs.getString(3));
				bc.setGenre(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bc;
	}
}
