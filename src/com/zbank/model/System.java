package com.zbank.model;

public class System {
	
    private String systemEnname;

    private String systemCnname;

    private String remake;

    private String absOne;

    private String absTwo;


    public void setSystemEnname(String systemEnname) {
        this.systemEnname = systemEnname == null ? null : systemEnname.trim();
    }

    public String getSystemCnname() {
        return systemCnname;
    }

    public void setSystemCnname(String systemCnname) {
        this.systemCnname = systemCnname == null ? null : systemCnname.trim();
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    public String getAbsOne() {
        return absOne;
    }

    public void setAbsOne(String absOne) {
        this.absOne = absOne == null ? null : absOne.trim();
    }

    public String getAbsTwo() {
        return absTwo;
    }

    public void setAbsTwo(String absTwo) {
        this.absTwo = absTwo == null ? null : absTwo.trim();
    }

	@Override
	public String toString() {
		return "{\"systemEnname\":\"" + systemEnname + "\",\"systemCnname\":\"" + systemCnname + "\",\"remake\":\""
				+ remake + "\",\"absOne\":\"" + absOne + "\",\"absTwo\":\"" + absTwo + "\"}";
	}
      
}