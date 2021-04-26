package com.property.application.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Base class for all Model classes. Provides basic fields for all Model
 * classes.
 * <p>
 */
@Data
@SuppressWarnings("serial")
@MappedSuperclass
@FilterDef(name = "activeFilter", parameters = @ParamDef(name = "cond", type = "boolean"))
public abstract class BaseModel implements Serializable {

	/**
	 * Boolean field used for soft delete(active/deactive row).
	 */
	@Column(name = "active", columnDefinition = "BIT", length = 1)
	private boolean active;
	/**
	 * Creation time.
	 */
	@Basic(optional = true)
	@Column(name = "createdAt", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdAt;
	/**
	 * Modification time.
	 */
	@Basic(optional = true)
	@Column(name = "modifiedAt", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date modifiedAt;
	/**
	 * Deletion time.
	 */
	@Basic(optional = true)
	@Column(name = "deletedAt", nullable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date deletedAt;
	/**
	 * User who creates the model.
	 */
	private String createdBy;
	/**
	 * User who modifies the model.
	 */
	
	private String modifiedBy;
	/**
	 * User who deletes the model.
	 */
	
	private String deletedBy;

}
