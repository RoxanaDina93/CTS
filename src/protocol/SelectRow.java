/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package protocol;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

/**
 *
 * @author Roxana
 */
@Root
public class SelectRow {
    
    /**
     * blabla
     */
    @ElementArray
    public String[] cell;

    /**
     * @return the cell
     */
    public String[] getCell() {
        return cell;
    }

    /**
     * @param cell the cell to set
     */
    public void setCell(String[] cell) {
        this.cell = cell;
    }
}
