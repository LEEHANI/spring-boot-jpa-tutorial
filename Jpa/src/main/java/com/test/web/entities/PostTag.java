package com.test.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor(staticName= "on")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class PostTag extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn( name = "post_seq", foreignKey = @ForeignKey(name = "FKEY_POST_SEQ_IN_POST_TAG"))
	@JsonBackReference
	private Post post;
	
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn( name = "tag_seq", foreignKey = @ForeignKey(name = "FKEY_TAG_SEQ_TITLE__IN_POST_TAG"))
	@JoinColumns({@JoinColumn( name = "tag_seq"), @JoinColumn( name = "tag_title")})
	@JsonManagedReference
	private Tag tag;
	
}
