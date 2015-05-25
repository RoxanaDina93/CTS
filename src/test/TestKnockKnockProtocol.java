package test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import protocol.Message;
import protocol.SelectRow;
import server.Db;
import server.KnockKnockProtocol;
import static org.mockito.Mockito.*;
public class TestKnockKnockProtocol {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Db db = mock(Db.class);
		Connection conn = mock(Connection.class);
		when (db.getConnection("test")).thenReturn(conn);
		
		KnockKnockProtocol kkp = new KnockKnockProtocol();
		kkp.setDbb(db);
		Object rez = kkp.getConnection("test");
		
		assertNotNull(rez);
		
	}
	
	@Test
	public void testExecuteSelectCommand() throws SQLException, NullPointerException{     
		KnockKnockProtocol kkp = new KnockKnockProtocol();
		
		String command = "select * from db";
		Message msg = new Message();
		msg.setCommand(command);
		Statement statement = mock(Statement.class);
		ResultSet rs = mock(ResultSet.class);
		ResultSetMetaData rsm = mock(ResultSetMetaData.class);
		
		when(statement.executeQuery(msg.getCommand())).thenReturn(rs);
		when(rs.getMetaData()).thenReturn(rsm);
		when(rsm.getColumnCount()).thenReturn(0);
		
		Message rezMsg = kkp.executeSelect(msg, statement);
		
		SelectRow[] sr = rezMsg.getResultData();
		
		
		
		assertNotNull(sr);
	}

	@Test
	public void testExecuteUpdateCommand() throws SQLException {
		KnockKnockProtocol kkp = new KnockKnockProtocol();
		Statement statement = mock(Statement.class);
		
		when(statement.executeUpdate("")).thenReturn(3);
		Message result = kkp.executeUpdate(new Message(), statement);
		
		assertTrue("3 modified".equals(result.getResult()));
		
	}
}
