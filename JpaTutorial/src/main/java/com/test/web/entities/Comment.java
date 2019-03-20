package com.test.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@Column(name = "content", nullable = false, updatable = false)
	private String content;
	
	@ManyToOne
	@JoinColumn( name = "post_seq", foreignKey = @ForeignKey(name = "FKEY_POST_SEQ_IN_COMMENT"))
	@JsonBackReference
	private Post post;
	
}
