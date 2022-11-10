/**
 * 
 */
package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tejas
 *
 */

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	private String catId;
	private String categoryName;

}
