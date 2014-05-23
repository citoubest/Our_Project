package com.thosepeople.constant;

public enum OperateType {

	LIKE("likes",1),COLLECT("collects",2);
	private String value;
	private int index;
	OperateType(String value,int index)
	{
		this.value = value;
		this.index = index;
	}
	
	public static String getValue(int index) {  
        for (OperateType c : OperateType.values()) {  
            if (c.getIndex() == index) {  
                return c.value;  
            }  
        }  
        return null;  
    }
	
	public static OperateType getType(int index) {  
        for (OperateType c : OperateType.values()) {  
            if (c.getIndex() == index) {  
                return c; 
            }  
        }  
        return null;  
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}  
	
	
	
}
