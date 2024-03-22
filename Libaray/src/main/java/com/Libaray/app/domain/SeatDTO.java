package com.Libaray.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

	private Long connectionseq;
	private int seatId;
	private String seatName;
	private int studentNumber;
	private String startDate;
	private String endDate;
	private String state;
	
	private boolean mine;
}
