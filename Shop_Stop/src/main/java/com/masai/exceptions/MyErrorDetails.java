/**
 * 
 */
package com.masai.exceptions;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tejas
 *
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {

	private LocalDate timestamp;
	private String message;
	private String details;

	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

}
