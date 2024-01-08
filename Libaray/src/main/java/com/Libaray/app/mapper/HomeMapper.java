package com.Libaray.app.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.domain.UserDTO;
import com.Libaray.app.security.domain.LoginUserDTO;

public interface HomeMapper {
	
	public List<SeatDTO> getSeat() throws SQLException , ClassNotFoundException;
	
	public int signIn(@Param("signInCheckDTO") UserDTO signInCheckDTO);
	
	public LoginUserDTO read(@Param("studentNumber") int studentNumber);
	
	public int seatReservation(@Param("studentNumber") int studentNumber, @Param("seatId") int seatId);
	
	public int seatReturn(@Param("connectionseq")int connectionseq, @Param("studentNumber") int studentNumber);
	
	public int seatExtension(@Param("connectionseq")int connectionseq, @Param("studentNumber") int studentNumber);
	
	public List<String> getExpireseat();
	
	public int expiredReservation(@Param("connectionseq") List<String> connectionseq);
	
	public int checkReservation(@Param("studentNumber") int studentNumber);
	

}
