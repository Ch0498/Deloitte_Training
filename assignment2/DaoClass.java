package assignment2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import day6.DBConnecto;

public class DaoClass {

	private static ArrayList<Book> books = new ArrayList<Book>();
	private static ArrayList<Author> authors = new ArrayList<Author>();
	private static ArrayList<Publisher> publishers = new ArrayList<Publisher>(); 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getData();
		listBooks();
		sortBooksbyAuthorAndTitle();
		listBooksPublishedAfterGivenYear(2005);
		listPoemsGivenCity("Hyderabad");
		listBooksGroupByAuthor(authors.get(0));

	}
	private static void listBooksGroupByAuthor(Author a) {
		// TODO Auto-generated method stub
		System.out.println();
		Connection con = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql = " {call totalbooks(?,?)}";
		try {
			CallableStatement cst = con.prepareCall(sql);
			cst.setString(1,a.getName());
			cst.registerOutParameter(2,Types.INTEGER);
			cst.execute();
			System.out.println("Number of books by "+a.getName()+" are: "+cst.getInt(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not call statement "+e.getMessage());
		}
		
	}
	private static void listPoemsGivenCity(String city) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Poems in "+city+" are:");
		for(Book b: books) {
			if(b.getPublisher().getCity().equalsIgnoreCase(city)&&b.getType().equalsIgnoreCase("Poems")) {
				System.out.println(b);
			}
		}
		
	}
	private static void listBooksPublishedAfterGivenYear(int year) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Books published after "+year+" are:");
		for(Book b:books) {
			if(b.getPub_year()>year)
			System.out.println(b);
		}
	}
	private static void sortBooksbyAuthorAndTitle() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Books sorted by Author and title are: ");
		Connection con = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql1 = "select * from book order by author_name,title";
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("ISBN: "+rs.getInt(1)+" Title: "+rs.getString(2)+" Pages: "+rs.getInt(3)+" Pulished_year: "+rs.getInt(4)+" Type: "+rs.getString(5)+" Author: "+rs.getString(6)+" Publisher: "+rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		
	}
	private static void getData() {
		// TODO Auto-generated method stub
		Connection con = new DBConnecto("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql1 = "select name,city from publisher";
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				publishers.add(new Publisher(rs.getInt(1), rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql2 = "select name,nationality from author";
		try {
			PreparedStatement pst = con.prepareStatement(sql2);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				authors.add(new Author(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql3 = "select isbn,title,pages,pub_year,type,author_name,publisher_name from book";
		try {
			PreparedStatement pst = con.prepareStatement(sql3);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Author a = null;
				for(Author i: authors) {
					if(i.getName().equalsIgnoreCase(rs.getString(6))) {
						a=i;
						break;
					}
				}
				Publisher p = null;
				for(Publisher i: publishers) {
					if(i.getName().equalsIgnoreCase(rs.getString(7))) {
						p=i;
						break;
					}
				}
				books.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),a,p));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		
	}
	private static void listBooks() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("List of Books: ");
		for(Book b: books) {
			System.out.println("ISBN: "+b.getIsbn()+" Title: "+b.getTitle()+" Pages: "+b.getPages()+" Author Name: "+b.getAuthor().getName()+" Publisher: "+b.getPublisher().getName()+" City: "+b.getPublisher().getCity());
		}
		
	}
	

}		