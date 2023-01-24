package modelo;

import utills.Utills;

public class Produto {
	private static int count = 1;
	
	private int id;
	private String name;
	private Double price;
	
	public Produto(String name, Double price) {
		this.id = count;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Id: " + this.getId() +
				"\nNome: " + this.getName() +
				"\nPreço" + Utills.doubletoString(this.getPrice());
	}
	
}


