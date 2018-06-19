package com.hexun.pointQuartz.common.enums;


public enum PointTypeEnum{
	BULL_MONEY("BULL_MONEY","牛币"),
	SUPGOD_MONEY("SUPGOD_MONEY","神币");
	 
	private String code;
    private String msg;
    
    
	private PointTypeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	 public static PointTypeEnum getByCode(String code) {
	        for (PointTypeEnum ls : PointTypeEnum.values()) {
	            if (ls.code.equals(code)) {
	                return ls;
	            }
	        }
	        return null;
	    }

	    public static PointTypeEnum getByMsg(String msg) {
	        for (PointTypeEnum ls : PointTypeEnum.values()) {
	            if (ls.msg.equalsIgnoreCase(msg)) {
	                return ls;
	            }
	        }
	        return null;
	    }
	    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	 public boolean equals(String code) {
	        return getCode().equals(code);
	    }
}
