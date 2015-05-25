/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;
@Root(name="calculation")
public class Message {
 
    @Attribute
    public String command = "";
 
    @Attribute
    public String dbname = "";
    
    @ElementArray
    public String[] resultColumns = new String[0];
    
    @ElementArray
    public SelectRow[] resultData = new SelectRow[0];
    
    @Attribute
    public String result="";
    
    public String getType() {                  
        
        final String[] arr = getCommand().split(" ",2);
        
        if (arr.length > 0) {
            return arr[0].toUpperCase();
        }
        
        return getCommand().toUpperCase();
    }

    /**
     * @return the command
     */
    public String getCommand() {                   
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return the resultColumns
     */
    public String[] getResultColumns() {
        return resultColumns;
    }

    /**
     * @param resultColumns the resultColumns to set
     */
    public void setResultColumns(String[] resultColumns) {
        this.resultColumns = resultColumns;
    }

    /**
     * @return the resultData
     */
    public SelectRow[] getResultData() {
        return resultData;
    }

    /**
     * @param resultData the resultData to set
     */
    public void setResultData(SelectRow[] resultData) {
        this.resultData = (resultData);
    }

    /**
     * @return the result
     */
    public String getResult() {        //*
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the dbname
     */
    public String getDbname() {        //*
        return dbname;
    }

    /**
     * @param dbname the dbname to set
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }
    
}

