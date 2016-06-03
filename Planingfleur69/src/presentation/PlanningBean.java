package presentation;

public class PlanningBean {

	String date1;
	String date2;
	String taches;

	public PlanningBean() {
	}

	public PlanningBean(String date1, String date2, String taches) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.taches = taches;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getTaches() {
		return taches;
	}

	public void setTaches(String taches) {
		this.taches = taches;
	}

	@Override
	public String toString() {
		return "PlanningBean [date1=" + date1 + ", date2=" + date2 + ", taches=" + taches + "]";
	}

}
