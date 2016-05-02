package cn.zk.basd;

import java.io.Serializable;

public class Dict implements Serializable{
	private int dict_id;
	private String dict_type;
	private String dict_item;
	private String dict_value;
	private String dict_is_editable;
	public int getDict_id() {
		return dict_id;
	}
	public void setDict_id(int dictId) {
		dict_id = dictId;
	}
	public String getDict_type() {
		return dict_type;
	}
	public void setDict_type(String dictType) {
		dict_type = dictType;
	}
	public String getDict_item() {
		return dict_item;
	}
	public void setDict_item(String dictItem) {
		dict_item = dictItem;
	}
	public String getDict_value() {
		return dict_value;
	}
	public void setDict_value(String dictValue) {
		dict_value = dictValue;
	}
	public String getDict_is_editable() {
		return dict_is_editable;
	}
	public void setDict_is_editable(String dictIsEditable) {
		dict_is_editable = dictIsEditable;
	}
	
	
}
