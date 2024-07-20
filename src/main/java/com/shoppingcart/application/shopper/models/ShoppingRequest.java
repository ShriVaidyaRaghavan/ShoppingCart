package com.shoppingcart.application.shopper.models;

import java.util.Objects;

public class ShoppingRequest {

	private String name;

	private String type;

	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(link, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingRequest other = (ShoppingRequest) obj;
		return Objects.equals(link, other.link) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ShoppingRequest [name=" + name + ", type=" + type + ", link=" + link + "]";
	}

}
