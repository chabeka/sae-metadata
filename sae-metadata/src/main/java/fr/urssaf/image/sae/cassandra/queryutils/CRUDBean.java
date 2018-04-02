package fr.urssaf.image.sae.cassandra.queryutils;

import java.util.LinkedList;
import java.util.List;

import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;

public class CRUDBean {
	private List<String> columns = new LinkedList<String>();
	private Select select;
	private Insert insert;
	private Delete delete;
	private Update update;
    
    /*private FieldInformation searchField;

    public FieldInformation getSearchField() {
        return searchField;
    }

    public void setSearchField(FieldInformation searchField) {
        this.searchField = searchField;
    }*/

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public Insert getInsert() {
		return insert;
	}

	public void setInsert(Insert insert) {
		this.insert = insert;
	}

	public Delete getDelete() {
		return delete;
	}

	public void setDelete(Delete delete) {
		this.delete = delete;
	}

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	String[] getArray() {
        return columns.toArray(new String[0]);
    }
}
