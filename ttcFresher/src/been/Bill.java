package been;

public class Bill {
	private int id;
	private String name;
	private long money;
	private String date;
	
	public Bill() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", name=" + name + ", money=" + money + ", date=" + date + "]";
	}
	
}
