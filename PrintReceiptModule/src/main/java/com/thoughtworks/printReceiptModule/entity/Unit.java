package com.thoughtworks.printReceiptModule.entity;

public enum Unit {
	BOTTLE("瓶"), ONE("个"), JIN("斤"), BAG("袋"),BOOK("本");

	  private String name;

	  Unit(String name) {
	    this.name = name;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

}
