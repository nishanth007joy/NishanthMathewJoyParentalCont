package com.nish.parentalcontol.enums;
/**
 * Enum representing parental control levels
 * @author Nishanth Mathew Joy
 *
 */
public enum ParentalControlLevelEnum {
	U(1,"U"),
	PG(2,"PG"),
	Twelve(3,"12"),
	Fifteen(4,"15"),
	Eighteen(5,"18");
	private final int value;
	private final String description;

	ParentalControlLevelEnum(final int value, final String desc){
		this.value = value;
		this.description = desc;
	}
	/**
	 * Get value
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Get description
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Get enum from code
	 * @param code
	 * @return
	 */
	public static ParentalControlLevelEnum fromCode(final String code){
		switch (code) {
		case "U":
			return U;
		case "PG":
			return PG;
		case "12":
			return Twelve;
		case "15":
			return Fifteen;
		case "18":
			return Eighteen;
		default:
			throw new IllegalArgumentException("Invalid code " );
		}
	}
}
