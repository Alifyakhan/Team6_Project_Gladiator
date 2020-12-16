package com.lti.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@SequenceGenerator(name = "seq5", sequenceName = "seq5", allocationSize = 1)
public class Product implements Serializable {
	private static final long serialVersionUID=425345L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq5")
	private Long id;
	
	private String productname;
	private String categoryy;
	private String screensize;
	private String color;
	private String oss;
	private String battery;
	private String ram;
	private String storagee;
	private String frontcam;
	private String rearcam;
	private String brand;
	private int price;
	private boolean activee=true;
	private int inStockNumber;
	private String descriptionn;

	@Transient
	private MultipartFile productImage;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCategoryy() {
		return categoryy;
	}
	public void setCategoryy(String categoryy) {
		this.categoryy = categoryy;
	}
	public String getScreensize() {
		return screensize;
	}
	public void setScreensize(String screensize) {
		this.screensize = screensize;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOss() {
		return oss;
	}
	public void setOss(String oss) {
		this.oss = oss;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getStoragee() {
		return storagee;
	}
	public void setStoragee(String storagee) {
		this.storagee = storagee;
	}
	public String getFrontcam() {
		return frontcam;
	}
	public void setFrontcam(String frontcam) {
		this.frontcam = frontcam;
	}
	public String getRearcam() {
		return rearcam;
	}
	public void setRearcam(String rearcam) {
		this.rearcam = rearcam;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isActivee() {
		return activee;
	}
	public void setActivee(boolean activee) {
		this.activee = activee;
	}
	public int getInStockNumber() {
		return inStockNumber;
	}
	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}
	public String getDescriptionn() {
		return descriptionn;
	}
	public void setDescriptionn(String descriptionn) {
		this.descriptionn = descriptionn;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	

}
