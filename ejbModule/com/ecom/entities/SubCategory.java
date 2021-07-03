package com.ecom.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubCategory
 *
 */
@Entity

public class SubCategory implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;

	@ManyToOne
    private Category category;
    

	public SubCategory() {
		super();
	}
	
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}



    @Override
    public String toString() {
        return "SubCategory[id=" + id + "]";
    }
   
}
