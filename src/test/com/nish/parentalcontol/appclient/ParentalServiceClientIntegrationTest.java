package com.nish.parentalcontol.appclient;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nish.parentalcontol.connection.DBConnection;
import com.nish.parentalcontol.enums.ParentalControlLevelEnum;
import com.nish.parentalcontol.factory.ParentalBeanFactory;
import com.nish.parentalcontol.service.ParentalControlService;

public class ParentalServiceClientIntegrationTest {
	private static ParentalControlService parentControlService;
	@BeforeClass
	public static void setUp() {
		parentControlService = ParentalBeanFactory.getParentalControlService();
	}
	@Before
	public void setUpData(){
		Connection connection = DBConnection.getDBConnection();
		String movieRestriction=null;
		PreparedStatement deletePreparedStatement = null;
		
		PreparedStatement createPreparedStatement = null;
		PreparedStatement insertPreparedStatement = null;
		try {
			connection.setAutoCommit(false);
			
			createPreparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS MOVIE_DETAILS(MOVIE_ID varchar(10) , RESTRICTION varchar(5))");
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			
			deletePreparedStatement = connection.prepareStatement("DELETE FROM MOVIE_DETAILS");
			deletePreparedStatement.executeUpdate();
			deletePreparedStatement.close();

			insertPreparedStatement = connection.prepareStatement("INSERT INTO MOVIE_DETAILS" + "(MOVIE_ID, RESTRICTION) values" + "(?,?)");
			insertPreparedStatement.setString(1, "Mov1");
			insertPreparedStatement.setString(2, ParentalControlLevelEnum.PG.getDescription());
			insertPreparedStatement.addBatch();
			
			insertPreparedStatement.setString(1, "Mov2");
			insertPreparedStatement.setString(2, ParentalControlLevelEnum.U.getDescription());
			insertPreparedStatement.addBatch();
			
			insertPreparedStatement.setString(1, "Mov4");
			insertPreparedStatement.setString(2, ParentalControlLevelEnum.PG.getDescription());
			insertPreparedStatement.addBatch();
			
			insertPreparedStatement.setString(1, "Mov4");
			insertPreparedStatement.setString(2, ParentalControlLevelEnum.Twelve.getDescription());
			insertPreparedStatement.addBatch();
			
			insertPreparedStatement.setString(1, "Mov5");
			insertPreparedStatement.setString(2, ParentalControlLevelEnum.Fifteen.getDescription());
			insertPreparedStatement.addBatch();
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();
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
	}
	@Test
	public void integrationTestTrue() {
		assertTrue(parentControlService.isMovieSatifiesParentalControl(ParentalControlLevelEnum.Eighteen.getDescription(), "Mov5"));
	}
	
	@Test
	public void integrationTestFalse() {
		assertFalse(parentControlService.isMovieSatifiesParentalControl(ParentalControlLevelEnum.Twelve.getDescription(), "Mov5"));
	}
	@AfterClass
	public static void tearDown(){

	}
}
