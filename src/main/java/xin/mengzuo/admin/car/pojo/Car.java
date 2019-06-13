package xin.mengzuo.admin.car.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Car {
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	private String brand; // 车牌
	private String model; // 型号
	private Double displacement;// 排量
	private Double mileage;// 里程数		
	private Double oldPrice;// 二手价
	private Integer status;// 状态0未处理1已处理3已取消
	private Integer userId;// 用户Id
	private String createdAt;// 创建时间
	private String faceImage;//车的正面照片
	private String otherImage;// 车俩其他图片
	private String phone;// 联系电话
	private String area;// 地址
	private String cardTime; // 上牌时间
	
	
	
	public String getCardTime() {
		return cardTime;
	}
	public void setCardTime(String cardTime) {
		this.cardTime = cardTime;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getDisplacement() {
		return displacement;
	}
	public void setDisplacement(Double displacement) {
		this.displacement = displacement;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public Double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFaceImage() {
		return faceImage;
	}
	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}
	public String getOtherImage() {
		return otherImage;
	}
	public void setOtherImage(String otherImage) {
		this.otherImage = otherImage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", displacement=" + displacement
				+ ", mileage=" + mileage + ", oldPrice=" + oldPrice + ", status=" + status + ", userId=" + userId
				+ ", faceImage=" + faceImage + ", otherImage=" + otherImage + ", phone=" + phone + "]";
	}
	
	
	 
	
}
