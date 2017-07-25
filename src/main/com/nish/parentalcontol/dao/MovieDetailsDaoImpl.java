package com.nish.parentalcontol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.nish.parentalcontol.connection.DBConnection;
/**
 * Dao impl class for fetching details from DB
 * @author Nishanth Mathew Joy
 *
 */
public class MovieDetailsDaoImpl implements MovieDetailsDao{
	@Override
	public String getMovieDetails(String movieId) {
		Connection connection = DBConnection.getDBConnection();
		String movieRestriction=null;
		PreparedStatement selectPreparedStatement;
		PreparedStatement createPreparedStatement = null;
		PreparedStatement insertPreparedStatement = null;
		try {
			connection.setAutoCommit(false);
			createPreparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS MOVIE_DETAILS(MOVIE_ID varchar(10) , RESTRICTION varchar(5))");
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();

			insertPreparedStatement = connection.prepareStatement("INSERT INTO MOVIE_DETAILS" + "(MOVIE_ID, RESTRICTION) values" + "(?,?)");
			insertPreparedStatement.setString(1, "Mov1");
			insertPreparedStatement.setString(2, "18");
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			selectPreparedStatement = connection.prepareStatement("SELECT MOVIE_ID,RESTRICTION from MOVIE_DETAILS WHERE MOVIE_ID =?");
			selectPreparedStatement.setString(1, movieId);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while(rs.next()){
				movieRestriction = rs.getString("RESTRICTION");
			}
			selectPreparedStatement.close();

			connection.commit();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}finally{
			try {
				
				connection.close();
			} catch (SQLException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
		return movieRestriction;
	}
}
