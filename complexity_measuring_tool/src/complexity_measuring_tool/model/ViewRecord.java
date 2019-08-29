package complexity_measuring_tool.model;

/*
 * @Author Peiris.M.R.P
 * IT16173064
 * 
 * This model class can use for records data retrieve
 */
public class ViewRecord {
	
	String date;
	String value;
	int cs;//Set complexity of statement value here 
	int cns;//Set complexity of nesting statement value here
	int cts;//Set complexity of type of the statement value here
	int ci;//Set complexity of inheritance value here
	int cr;//Set complexity of recursion value here
	
	public ViewRecord() {
		super();
	}
	public ViewRecord(String date, String value) {
		super();
		this.date = date;
		this.value = value;
	}
	
	
	public ViewRecord(String date, String value, int cs, int cns, int cts, int ci, int cr) {
		super();
		this.date = date;
		this.value = value;
		this.cs = cs;
		this.cns = cns;
		this.cts = cts;
		this.ci = ci;
		this.cr = cr;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}
	public int getCns() {
		return cns;
	}
	public void setCns(int cns) {
		this.cns = cns;
	}
	public int getCts() {
		return cts;
	}
	public void setCts(int cts) {
		this.cts = cts;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public int getCr() {
		return cr;
	}
	public void setCr(int cr) {
		this.cr = cr;
	}
	
	

}
