/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import protocol.Message;
import protocol.SelectRow;

/**
 *
 * @author Roxana
 */
public class KnockKnockProtocol {
    Serializer serializer = new Persister();
    Db dbb = new Db();
    
    public Connection getConnection(String dbName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    	return dbb.getConnection(dbName);
    }
    
    public Db getDbb() {
		return dbb;
	}

	public void setDbb(Db dbb) {
		this.dbb = dbb;
	}

	public Message executeSelect(Message msg, Statement statement) throws SQLException {
    	ResultSet rs = statement.executeQuery(msg.getCommand());
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        
        String[] resultColumns = new String[numberOfColumns]; 
        
        for (int i=0;i<numberOfColumns;i++) {
            resultColumns[i] = rsmd.getColumnLabel(i+1);
        }
        
        msg.setResultColumns(resultColumns);
        
        
        int k=0;
        rs.last();
        
        int rowCount = rs.getRow();
        
        msg.setResultData(new SelectRow[rowCount]);
        
        rs.first();
        if (rowCount >0) {
            msg.setResult(rowCount + " found");
            do {
                SelectRow srr = new SelectRow();
                srr.cell = new String[resultColumns.length];

                msg.getResultData()[k] = srr;

                for (int j=0;j<resultColumns.length;j++) {
                    msg.resultData[k].cell[j] = rs.getString(resultColumns[j]);
                }

                k++;
            } while (rs.next());

        }
        // close all the connections.
        rs.close();

        return msg;
    }
    
    public Message executeUpdate(Message msg, Statement statement) throws SQLException {
    	int rows = statement.executeUpdate(msg.getCommand());
        
        msg.setResult(rows + " modified");
        
        return msg;
    }
    
    
    public Message processInput(Message msg) throws Exception {   
    
    	
    	
        try {
            Connection con = this.getConnection(msg.getDbname());
            Statement statement = con.createStatement();
            
            if ("SELECT".equals(msg.getType())) {
                msg = this.executeSelect(msg,statement);

            }
            else {
                msg = this.executeUpdate(msg, statement);
            }
        }
        catch (Exception ex) {
            msg.setResult("Error executing command: " + ex.toString());
        }
        
        return msg;
    }
}
